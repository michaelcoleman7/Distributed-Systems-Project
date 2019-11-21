package ie.gmit.sw;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class UserApiApplication extends Application<UserApiConfig> {

    public static void main(String[] args) throws Exception {
    	//run application
        new UserApiApplication().run(args);
    }

    public void run(UserApiConfig userApiConfig, Environment environment) throws Exception {
        
    	final UserHealthCheck healthCheck = new UserHealthCheck();
        environment.healthChecks().register("user", healthCheck);
        
        final UserApiResource resource = new UserApiResource();

        environment.jersey().register(resource);
    }
}
