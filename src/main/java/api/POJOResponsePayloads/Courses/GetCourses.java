package api.POJOResponsePayloads.Courses;

import java.util.ArrayList;

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

    //    public ArrayList<GetCourses.courses> getCourses() {
//        return courses;
//    }
    public Courses getCourses() {
        return courses;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

//    private static class courses {
//        ArrayList<webAutomation> webAutomations;
//        ArrayList<api> apis;
//        ArrayList<mobile> mobiles;
//    }
//
//    private static class webAutomation {
//        private String courseTitle;
//        private String price;
//    }
//
//    private static class api {
//        private String courseTitle;
//        private String price;
//    }
//
//    private static class mobile {
//        private String courseTitle;
//        private String price;
//    }
}
