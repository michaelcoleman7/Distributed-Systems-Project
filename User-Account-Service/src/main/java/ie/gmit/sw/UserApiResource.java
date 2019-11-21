package ie.gmit.sw;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResource {
	//create an instance of the client
	PasswordServiceClient psc = new PasswordServiceClient("localhost", 50551);
	//hash map that is used as a database for applications
    public static HashMap<Integer, UserInfo> usersMap = new HashMap<>();

    //Constructor
    public UserApiResource() {
    }

    //get request to view to all users
    @GET
    public Collection<UserInfo> getUsers() {
    	//return all users in map's info
        return usersMap.values();
    }

    //get request to view a specific user based on their user id
    @GET
    @Path("{userId}")
    public UserInfo getUser(@PathParam("userId") int id) {
    	//return a single requested user's info by id
        return usersMap.get(id);
    }
    
    //post request to create a new user
	@POST
	public Response createUser(User user) throws InterruptedException, UnsupportedEncodingException {
		
		//hash user password
    	psc.hashNewPassword(user.getUserId(),user.getPassword());
    	
    	//return hash and salt values from client
    	byte[] hash = psc.getPasswordHash().toByteArray();
    	byte[] salt = psc.getSalt().toByteArray();
    	
    	//convert byte arrays returned to strings, encoded using "ISO-8859-1"
    	String hashString = new String(hash,"ISO-8859-1");
    	String saltString = new String(salt,"ISO-8859-1");
    	
    	//create a new userInfo object
    	UserInfo newUser = new UserInfo(user.getUserId(),user.getUsername(),user.getEmail(),hashString,saltString);
    	
    	//put new UserInfo into the hash map
    	usersMap.put(user.getUserId(), newUser);
    	
    	//set response to server when created
        String response = "New user of ID: "+ newUser.getUserId()+" has been added successfully!";

        //return 200(success) response
        return Response.status(200).entity(response).build();
	}
	
	//method to update a users details
	@PUT
	@Path("{userId}")
	public Response update(@PathParam("userId") int id, User user) throws InterruptedException {
		//if user doesn't exist in map
        if(usersMap.get(id)==null) {
        	//set failed request response message
        	String response = "User of ID: "+ id+" does not exist in the database";
        	
        	//return 404 not found response
            return Response.status(404).entity(response).build();
        }
        else {
        	//create a new user using using updated information
        	UserInfo updatedUser = new UserInfo(user.getUserId(),user.getUsername(),user.getEmail(),new String(psc.getPasswordHash().toByteArray()),new String(psc.getSalt().toByteArray()));
        	
        	//put updated user into hash map
        	usersMap.put(user.getUserId(), updatedUser);
        	
        	//set response message
            String response = "The user of ID: "+ id+" has been added successfully updated!";
           //return response
            return Response.ok().status(200).entity(response).build();
        }

	}
	
	//delete request to remove a user by id
	@DELETE
	@Path("{userId}")
	public Response delete(@PathParam("userId") int id) {
		//if user id doesn't exit in the database/map
      if(usersMap.get(id)==null) {
    	  //set failed request response message
    	  String response = "User of ID: "+ id+" does not exist in the database";
    	  //return 404 not found response
    	  return Response.status(404).entity(response).build();
      }
      else {
    	  //remove the user by id from the map
    	  usersMap.remove(id);
    	  //set valid response message
    	  String response = "The user of ID: "+ id+" has been added successfully deleted!";
    	  //return valid response
          return Response.ok().status(200).entity(response).build();
      }
	}
	
	@POST
	@Path("/login")
	public Response loginValidate(Login login) throws InterruptedException, UnsupportedEncodingException {
		UserInfo user = usersMap.get(login.getUserId());
		
		if(psc.validatePassword(login,user).getValue()) {
			//print acknowledgement of success to service
			System.out.println("Validation of Password Successful!");
			
			//Set success response message
		    String response = "Validation of Password Successful!, Login was successful";
		    //return successful response
		    return Response.ok().status(200).entity(response).build();
		}else {
			//print acknowledgement of failure to service
			System.out.println("Validation of Password Failed!");
			//Set failed login response message
		    String response = "Validation of Password Failed!, Login has failed, Please check your password";
		    //return 400(bad request) response
		    return Response.ok().status(400).entity(response).build();
		}
	}
	
	
}
