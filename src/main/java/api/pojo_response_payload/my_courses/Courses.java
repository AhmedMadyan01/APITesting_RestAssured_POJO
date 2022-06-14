package api.pojo_response_payload.my_courses;

import java.util.List;

public class Courses {
    private List<WebAutomationCourses> webAutomationCourses;
    private List<APICourses> apiCourses;
    private List<MobileCourses> mobileCourses;

    public List<WebAutomationCourses> getWebAutomation() {
        return webAutomationCourses;
    }

    public void setWebAutomation(List<WebAutomationCourses> webAutomationCourses) {
        this.webAutomationCourses = webAutomationCourses;
    }

    public List<APICourses> getApi() {
        return apiCourses;
    }

    public void setApi(List<APICourses> apiCourses) {
        this.apiCourses = apiCourses;
    }

    public List<MobileCourses> getMobile() {
        return mobileCourses;
    }

    public void setMobile(List<MobileCourses> mobileCourses) {
        this.mobileCourses = mobileCourses;
    }
}
