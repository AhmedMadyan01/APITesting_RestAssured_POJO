package api.pojo_response_payload.all_courses;

public class Course {
    private String name;
    private String author;
    private String imgURL;
    private String courseURL;
    private double old_price;
    private double old_price_in_dollar;
    private double actual_price;
    private double actual_price_in_dollar;
    private double noOfCourses;
    private double userEnrolled;
    private double userComments;
    private double rate;
    private Boolean isBundle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getCourseURL() {
        return courseURL;
    }

    public void setCourseURL(String courseURL) {
        this.courseURL = courseURL;
    }

    public double getOld_price() {
        return old_price;
    }

    public void setOld_price(double old_price) {
        this.old_price = old_price;
    }

    public double getOld_price_in_dollar() {
        return old_price_in_dollar;
    }

    public void setOld_price_in_dollar(double old_price_in_dollar) {
        this.old_price_in_dollar = old_price_in_dollar;
    }

    public double getActual_price() {
        return actual_price;
    }

    public void setActual_price(double actual_price) {
        this.actual_price = actual_price;
    }

    public double getActual_price_in_dollar() {
        return actual_price_in_dollar;
    }

    public void setActual_price_in_dollar(double actual_price_in_dollar) {
        this.actual_price_in_dollar = actual_price_in_dollar;
    }

    public double getNoOfCourses() {
        return noOfCourses;
    }

    public void setNoOfCourses(double noOfCourses) {
        this.noOfCourses = noOfCourses;
    }

    public double getUserEnrolled() {
        return userEnrolled;
    }

    public void setUserEnrolled(double userEnrolled) {
        this.userEnrolled = userEnrolled;
    }

    public double getUserComments() {
        return userComments;
    }

    public void setUserComments(double userComments) {
        this.userComments = userComments;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Boolean getBundle() {
        return isBundle;
    }

    public void setBundle(Boolean bundle) {
        isBundle = bundle;
    }
}
