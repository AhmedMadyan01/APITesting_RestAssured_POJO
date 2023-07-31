package api.driver;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIResponse {
    private static Response response;
}