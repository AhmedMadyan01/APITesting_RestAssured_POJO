package api.pojo.requests.profile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostProfile_Req {
    private String username;
    private String displayName;
    private int age;
    private int avatar;
    private String parentEmail;
    private Boolean parentConsent;
    private int securityQuestion;
    private String securityAnswer;
}