package api.base_uris;

import lombok.Getter;

@Getter
public enum BaseURI {
    FIREBASE_AUTHENTICATION("https://www.googleapis.com"),
    FIREBASE_ANONYMOUS("https://identitytoolkit.googleapis.com"),
    ST("https://cybersa.mocklab.io"),
    SIT("https://api.dev.to-zi.com");

    private final String baseURI;

    BaseURI(String baseURI) {
        this.baseURI = baseURI;
    }
}