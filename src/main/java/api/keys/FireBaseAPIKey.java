package api.keys;

import lombok.Getter;

@Getter
public enum FireBaseAPIKey {
    KEY("AIzaSyAKKukGTd6HJmyTsj-phKADa9uGNVKOQlY");
    private final String fireBaseAPIKey;

    FireBaseAPIKey(String fireBaseAPIKey) {
        this.fireBaseAPIKey = fireBaseAPIKey;
    }
}