package api.POJOResponsePayloads.Courses;

public class GetCourses {
    private String url;
    private String services;
    private String expertises;
    private Courses courses;
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

    public Courses getCourses() {
        return courses;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getLinkedIn() {
        return linkedIn;
    }
}
