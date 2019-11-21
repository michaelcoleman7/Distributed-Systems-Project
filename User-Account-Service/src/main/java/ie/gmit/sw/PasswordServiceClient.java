package ie.gmit.sw;

import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;

import ie.gmit.ds.Password;
import ie.gmit.ds.PasswordInput;
import ie.gmit.ds.PasswordOutput;
import ie.gmit.ds.PasswordServiceGrpc;
import ie.gmit.ds.ValidateInput;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordServiceClient {
    private static final Logger logger =
            Logger.getLogger(PasswordServiceClient.class.getName());
    private final ManagedChannel channel;
    private final PasswordServiceGrpc.PasswordServiceStub asyncPasswordService;
    private final PasswordServiceGrpc.PasswordServiceBlockingStub syncPasswordService;
    private ByteString passwordHash;
    private ByteString salt;  

    //get hashed password
    public ByteString getPasswordHash() {
		return passwordHash;
	}

    //get salt
	public ByteString getSalt() {
		return salt;
	}

	//client constructor
	public PasswordServiceClient(String host, int port) {
        channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();
        syncPasswordService = PasswordServiceGrpc.newBlockingStub(channel);
        asyncPasswordService = PasswordServiceGrpc.newStub(channel);
    }

	//shutdown client
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    //hash passsword method
    public void hashNewPassword(int id,String pass) throws UnsupportedEncodingException {
    	//Create a new password object
        Password password = Password.newBuilder().setPassword(pass).setUserId(id).build();
        
        //create a new password input to be sent to the Password service (part 1)
        PasswordInput pi = PasswordInput.newBuilder().setPassword(password).build();
        try {
        	//create a password output
            StreamObserver<PasswordOutput> po = new StreamObserver<PasswordOutput>() {
            	
                @Override
                public void onNext(PasswordOutput po) {
                	//get password from password (part 1)
                	passwordHash = po.getHashedPassword();
                	//get salt from pasword service (part 1)
                	salt = po.getSalt();
                }

                @Override
                public void onError(Throwable t) {
                    Status status = Status.fromThrowable(t);

                    logger.log(Level.WARNING, "RPC Error: {0}", status);
                }

                @Override
                public void onCompleted() {
                    logger.info("Finished hashing Password");
                }
            };
            
            //hash password
            asyncPasswordService.hash(pi, po);
            
            try{
            	//get client to sleep so that aysnc is finished before completion of post
            	TimeUnit.SECONDS.sleep(2);
            }catch(InterruptedException e){
            	e.printStackTrace();
            }
        } catch (StatusRuntimeException ex) {
            logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
        }     
    }

    // Validate Password
    public BoolValue validatePassword(Login login, UserInfo user) throws UnsupportedEncodingException {    	
    	//get login objects password
    	String loginPassword = login.getPassword();
    	
    	// create byte arrays from users hashed password and salt
    	byte[] hashedPasswordByte = user.getHashedPassword().getBytes("ISO-8859-1");
    	byte[] salt = user.getSalt().getBytes("ISO-8859-1");
    	
    	//change hash password and salt to bytestrings to match ValidateInput parameters
    	ByteString hashedPasswordByteString = ByteString.copyFrom(hashedPasswordByte);
    	ByteString saltByteString = ByteString.copyFrom(salt);
		
    	//create a ValidateInput object to be sent to password service for validation
    	ValidateInput vi = ValidateInput.newBuilder().setPassword(loginPassword).setHashedPassword(hashedPasswordByteString).setSalt(saltByteString).build();
        try {
        	// call validate method and return result
            BoolValue result = syncPasswordService.validate(vi);
            
            //if result is true/ password is valid
            if (result.getValue()) {
            	//log  result
                logger.info("Successfully validated password ");
                return result;
            } else {
            	//log  result
                logger.warning("Failed to validate password");
                return result;
            }
        } catch (StatusRuntimeException ex) {
            logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
            return null;
        }
    }
}
