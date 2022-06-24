package linear_tests.api;

import api.pojo_response_payload.content.Content;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.api_driver.RequestBuilder;
import utilities.api_driver.RequestMethod;
import utilities.reader_manager.json_reader.JSONDataManager;

import java.util.List;

public class TestContent {
    private static Response response;
    private static final String jsonFilePath = ("src/test/resources/expected_response_payload/GetContentList.json");

    @Test
    public void invokeContentEndpoint() {
        response = RequestBuilder.performRequest("https://wj0ek.mocklab.io", null, "/content-management-api/v1/content", null,
                RequestMethod.GET, null, null, null, null, HttpStatus.SC_OK).then().extract().response();

    }

    @Test(dependsOnMethods = "invokeContentEndpoint")
    public void assertResponseCodeSCOK() {
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "assertResponseCodeSCOK")
    public void assertResponsePayloadUsingPojo() {
        List<Content> contentList = response.as(new TypeRef<>() {
        });
        for (int i = 0; i <= contentList.size() - 1; i++) {
            List<?> expectedListOfContentIDs = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.contentId", JSONDataManager.Types.LIST);
            List<?> expectedListContentTypes = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.contentType", JSONDataManager.Types.LIST);
            List<?> expectedListOfIconURLs = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.iconURL", JSONDataManager.Types.LIST);
            List<?> expectedListOfMarginBottoms = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.marginBottom", JSONDataManager.Types.LIST);
            List<?> expectedListOfMarginLefts = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.marginLeft", JSONDataManager.Types.LIST);
            List<?> expectedListOfMarginRights = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.marginRight", JSONDataManager.Types.LIST);
            List<?> expectedListOfMarginTops = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.marginTop", JSONDataManager.Types.LIST);
            List<?> expectedListOfShapeURLs = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.shapeURL", JSONDataManager.Types.LIST);
            List<?> expectedListOfThumbnailURLs = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.thumbnailURL", JSONDataManager.Types.LIST);
            List<?> expectedListOfTitles = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.title", JSONDataManager.Types.LIST);
            Assert.assertEquals(contentList.get(i).getContentId(), expectedListOfContentIDs.get(i));
            Assert.assertEquals(contentList.get(i).getContentType(), expectedListContentTypes.get(i));
            Assert.assertEquals(contentList.get(i).getIconURL(), expectedListOfIconURLs.get(i));
            Assert.assertEquals(contentList.get(i).getMarginBottom(), expectedListOfMarginBottoms.get(i));
            Assert.assertEquals(contentList.get(i).getMarginLeft(), expectedListOfMarginLefts.get(i));
            Assert.assertEquals(contentList.get(i).getMarginRight(), expectedListOfMarginRights.get(i));
            Assert.assertEquals(contentList.get(i).getMarginTop(), expectedListOfMarginTops.get(i));
            Assert.assertEquals(contentList.get(i).getShapeURL(), expectedListOfShapeURLs.get(i));
            Assert.assertEquals(contentList.get(i).getThumbnailURL(), expectedListOfThumbnailURLs.get(i));
            Assert.assertEquals(contentList.get(i).getTitle(), expectedListOfTitles.get(i));
        }
    }

    @Test(dependsOnMethods = "assertResponsePayloadUsingPojo")
    public void assertResponsePayloadUsingJsonPath() {
        List<?> content = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content", JSONDataManager.Types.LIST);
        JsonPath jsonPath = new JsonPath(response.getBody().asPrettyString());
        Assert.assertEquals(jsonPath.get(), content);
    }
}