package users;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Users {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<Data> data;
    private Support support;
}