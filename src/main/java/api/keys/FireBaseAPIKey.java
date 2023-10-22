package api.keys;

import lombok.Getter;

@Getter
public enum FireBaseAPIKey {
    KEY_DEV("AIzaSyAKKukGTd6HJmyTsj-phKADa9uGNVKOQlY"),
    KEY_PROD("AIzaSyDAtspUmg9QFsw1E3aQs9KWqbsiHpEn67A");

    private final String fireBaseAPIKey;

    FireBaseAPIKey(String fireBaseAPIKey) {
        this.fireBaseAPIKey = fireBaseAPIKey;
    }
}