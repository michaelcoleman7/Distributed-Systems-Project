package ie.gmit.ds;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class PasswordServiceServer {
    private Server grpcServer;
    private static final Logger logger = Logger.getLogger(PasswordServiceServer.class.getName());
    private static final int PORT = 50551;

    private void start() throws IOException {
        //Build Server on port 50551
        grpcServer = ServerBuilder.forPort(PORT)
                .addService(new PasswordServiceImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + PORT);

    }

    //Method to shutdown server
    private void stop() {
        if (grpcServer != null) {
            //Shutdown Server
            grpcServer.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (grpcServer != null) {
            grpcServer.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        //Create new PasswordServiceServer
        final PasswordServiceServer passwordServiceServer = new PasswordServiceServer();
        //Start Server
        passwordServiceServer.start();
        //Call block until shutdown method which keeps server on until signalled to shutdown
        passwordServiceServer.blockUntilShutdown();
    }
}
