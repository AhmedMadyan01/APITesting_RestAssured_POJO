package api.POJOResponsePayloads.Courses;

import java.util.List;

public class GetCourses {
    private String url;
    private String services;
    private String expertises;
    private List<Courses> courses;
    private String instructor;
    private String linkedIn;

    public String getUrl() {
        return url;
    }

    public String getServices() {
        return services;
    }

    public String getExpertises() {
        return expertises;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getLinkedIn() {
        return linkedIn;
    }
}
