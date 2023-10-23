package api.pojo.responses.firebase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticatedToken_Res {
    private String kind;
    private String localId;
    private String email;
    private String displayName;
    private String idToken;
    private Boolean registered;
    private String refreshToken;
    private String expiresIn;
}