package pl.connectis.authexample;

import lombok.Data;

@Data
public class UserToRegister {
    private String name;
    private String pass;
    private String repass;
}
