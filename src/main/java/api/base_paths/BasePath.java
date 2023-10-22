package api.base_paths;

import lombok.Getter;

@Getter
public enum BasePath {
    AUTHENTICATION_TOKEN("/identitytoolkit/v3/relyingparty/verifyPassword"),
    ANONYMOUS_TOKEN("/v1/accounts:signUp"),
    CONTENT("/content-management-api/content"),
    POST_PROFILE("/profile-management-api/profile"),
    PROFILE("/profile-management-api/profile/{username}"),
    VERIFY_SECURITY_ANSWER("/profile-management-api/profile/{username}/verify-security-answer"),
    NEW_PARENT_EMAIL("/profile-management-api/profile/{username}/parent-email"),
    NEW_PIN_CODE("/profile-management-api/profile/{username}/new-pin-code");

    public final String basePath;

    BasePath(String basePath) {
        this.basePath = basePath;
    }
}