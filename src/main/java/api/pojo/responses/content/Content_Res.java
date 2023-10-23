package api.pojo.responses.content;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Content_Res {
    private int contentId;
    private String contentTitle;
    private String contentType;
    private int duration;
    private String iconURL;
    private String imageURL;
    public List<Object> keywords;
    private String marginBottom;
    private String marginLeft;
    private String marginRight;
    private String marginTop;
    private String shapeURL;
    private boolean suggested;
    public List<Object> topics;
}