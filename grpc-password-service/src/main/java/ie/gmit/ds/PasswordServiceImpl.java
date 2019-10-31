package ie.gmit.ds;

import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;

public class PasswordServiceImpl extends PasswordServiceGrpc.PasswordServiceImplBase {
    //Override hash method
    @Override
    public void hash(PasswordInput request, StreamObserver<PasswordOutput> responseObserver) {
        //Build new password output
        PasswordOutput.Builder passwordOutput = PasswordOutput.newBuilder();

        //Get password from client request
        Password password = request.getPassword();

        //Get user Id from client request
        int userId = password.getUserId();

        //Convert the password to a char array for the hash() method
        char[] passwordToChar=password.getPassword().toCharArray();

        //get new salt from the getNextSalt() method from the Passwords class
        byte[] salt = Passwords.getNextSalt();
        //Convert the salt returned to a ByteString in order to return to client
        ByteString userSalt = ByteString.copyFrom(salt);

        //Hash password using Hash() method from Passwords class
        byte[] hashedPassword = Passwords.hash(passwordToChar, salt);
        //Convert the hashed password returned to a ByteString in order to return to client
        ByteString userHashedPassword = ByteString.copyFrom(hashedPassword);

        //set password output values to be returned to client
        passwordOutput.setSalt(userSalt);
        passwordOutput.setHashedPassword(userHashedPassword);
        passwordOutput.setUserId(userId);
        // build password output
        responseObserver.onNext(passwordOutput.build());
        //call onCompleted()
        responseObserver.onCompleted();
    }
    //Override Validate Method
    @Override
    public void validate(ValidateInput request, StreamObserver<BoolValue> responseObserver) {
        // Get the user entered Password from client
        char[] userEnteredPassword = request.getPassword().toCharArray();
        //Get the hashed password from client
        byte[] hashedPassword = request.getHashedPassword().toByteArray();
        //get the salt from client
        byte[] salt = request.getSalt().toByteArray();

        //Return value of true if passwords match
        boolean valid = Passwords.isExpectedPassword(userEnteredPassword,salt, hashedPassword);

        //if passwords match return true to client
        if(valid)
        {
            responseObserver.onNext(BoolValue.newBuilder().setValue(true).build());
        }
        //if value is false return false to client
        else {
            responseObserver.onNext(BoolValue.newBuilder().setValue(false).build());
        }
        responseObserver.onCompleted();
    }
}
