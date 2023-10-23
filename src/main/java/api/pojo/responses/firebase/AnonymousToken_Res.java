package api.pojo.responses.firebase;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnonymousToken_Res {
    private String kind;
    private String idToken;
    private String refreshToken;
    private String expiresIn;
    private String localId;
}