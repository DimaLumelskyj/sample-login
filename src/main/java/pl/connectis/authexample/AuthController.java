package pl.connectis.authexample;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    User register(@RequestBody UserToRegister toBeRegistered){
        return userService.register(toBeRegistered);
    }

    @PostMapping("/login")
    String login(@RequestBody User toBeLoggedIn){
        return userService.login(toBeLoggedIn);
    }
}