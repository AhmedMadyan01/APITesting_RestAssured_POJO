package api.POJOResponsePayloads.Users;

import java.util.ArrayList;

public class GetUsers {
    public double page;
    public double per_page;
    public double total;
    public double total_pages;
    public ArrayList<data> users;

    public class data{
        public double id;
        public String email;
        public String first_name;
        public String last_name;
        public String avatar;
    }

    public  class support{
        public String url;
        public String text;
    }
}
