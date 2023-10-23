package api.pojo.requests.firebase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticatedToken_Req {
    private String email;
    private String password;
    private Boolean returnSecureToken;
}