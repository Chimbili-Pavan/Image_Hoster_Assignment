package ImageHoster.service;

import ImageHoster.model.User;
import ImageHoster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Call the registerUser() method in the UserRepository class to persist the user record in the database
    public void registerUser(User newUser) {
        userRepository.registerUser(newUser);
    }

    //Since we did not have any user in the database, therefore the user with username 'upgrad' and password 'password' was hard-coded
    //This method returned true if the username was 'upgrad' and password is 'password'
    //But now let us change the implementation of this method
    //This method receives the User type object
    //Calls the checkUser() method in the Repository passing the username and password which checks the username and password in the database
    //The Repository returns User type object if user with entered username and password exists in the database
    //Else returns null
    public User login(User user) {
        User existingUser = userRepository.checkUser(user.getUsername(), user.getPassword());
        if (existingUser != null) {
            return existingUser;
        } else {
            return null;
        }
    }

    // This method checks the password strength and return boolean
	public Boolean passwordCheck(String password){
		Boolean letters = false;
		Boolean numbers = false;
		Boolean special = false;
		int asc = 0;
		for(int i=0;i<password.length();i++){
		    asc = (int)password.charAt(i);
			if((asc>=65 && asc<=90) || (asc>=97 && asc<=122)){
				letters = true;
			}
			else if(asc>=48 && asc<=57){
				numbers = true;
			}
			else if((asc>=33 && asc<=47) || (asc>=58 && asc<=126)){
				special = true;
			}
			else{
			
			}	
		}
	
		if(letters!=false && numbers!=false && special!=false){
			return true;
		}
		else{
			return false;
		}
       }

}
