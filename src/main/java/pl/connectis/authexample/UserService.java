package pl.connectis.authexample;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private final Set<User> registeredUsers = new HashSet<>();
    private final Set<User> loggedUser = new HashSet<>();

    public User register(UserToRegister userToRegister){
        if(!userToRegister.getPass().equals(userToRegister.getRepass())){
            throw new IllegalArgumentException("Passwords need to match!");
        }

        User user = new User();
        user.setName(userToRegister.getName());
        user.setPassword(userToRegister.getPass());
        registeredUsers.add(user);
        return user;
    }

    public String login(User toBeLoggedIn) {
        validateUserExists(toBeLoggedIn);
        loggedUser.add(toBeLoggedIn);
        return "" + toBeLoggedIn.hashCode();
    }

    private void validateUserExists(User toBeLoggedIn) {
        for (User registeredUser : registeredUsers) {
            if (registeredUser.getName().equals(toBeLoggedIn.getName())) {
                return;
            }
        }
        throw new IllegalStateException("No such user");
    }

    public boolean isLoggedIn(String token) {
        for (User user : loggedUser) {
            if(String.valueOf(user.hashCode()).equals(token)){
                return true;
            }
        }
        return false;
    }
}
