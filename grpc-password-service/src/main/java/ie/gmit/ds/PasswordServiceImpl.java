package ie.gmit.ds;

import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;

public class PasswordServiceImpl extends PasswordServiceGrpc.PasswordServiceImplBase {
    @Override
    public void hash(PasswordInput request, StreamObserver<PasswordOutput> responseObserver) {

        PasswordOutput.Builder passwordOutput = PasswordOutput.newBuilder();
        Password password = request.getPassword();
        int userId = password.getUserId();

        char[] passwordToChar=password.getPassword().toCharArray();

        byte[] salt = Passwords.getNextSalt();
        ByteString userSalt = ByteString.copyFrom(salt);

        byte[] hashedPassword = Passwords.hash(passwordToChar, salt);
        ByteString userHashedPassword = ByteString.copyFrom(salt);

        passwordOutput.setSalt(userSalt);
        passwordOutput.setHashedPassword(userHashedPassword);
        passwordOutput.setUserId(userId);
        responseObserver.onNext(passwordOutput.build());
        responseObserver.onCompleted();
    }

    @Override
    public void validate(ValidateInput request, StreamObserver<BoolValue> responseObserver) {
        char[] userEnteredPassword = request.getPassword().toCharArray();
        byte[] hashedPassword = request.getHashedPassword().toByteArray();
        byte[] salt = request.getSalt().toByteArray();

        boolean valid = Passwords.isExpectedPassword(userEnteredPassword,salt, hashedPassword);

        if(valid)
        {
            responseObserver.onNext(BoolValue.newBuilder().setValue(true).build());
        }
        else {
            responseObserver.onNext(BoolValue.newBuilder().setValue(false).build());
        }
        responseObserver.onCompleted();
    }
}
