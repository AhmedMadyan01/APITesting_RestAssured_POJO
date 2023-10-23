package api.pojo.responses.profile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Profile_Res {
    private String username;
    private String displayName;
    private int age;
    private int avatar;
    private String parentEmail;
    private boolean parentConsent;
    private int securityQuestion;
}