package pl.connectis.authexample;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    private final UserService userService;

    public ResourceController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello/{name}")
    String hello(@PathVariable String name){
        return "Greetings, " + name;
    }

    @PostMapping("/secret")
    String secret(@RequestBody Token token){
        if(!userService.isLoggedIn(token.getValue())){
            throw new IllegalArgumentException("invalid token");
        }
        return "very important secret";
    }

}
