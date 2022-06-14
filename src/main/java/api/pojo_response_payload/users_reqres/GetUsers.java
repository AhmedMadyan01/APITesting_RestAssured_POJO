package api.pojo_response_payload.users_reqres;

import java.util.List;

public class GetUsers {
    private double page;
    private double per_page;
    private double total;
    private double total_pages;
    private List<Users> data;
    private Support support;

    public double getPage() {
        return page;
    }

    public void setPage(double page) {
        this.page = page;
    }

    public double getPer_page() {
        return per_page;
    }

    public void setPer_page(double per_page) {
        this.per_page = per_page;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(double total_pages) {
        this.total_pages = total_pages;
    }

    public List<Users> getData() {
        return data;
    }

    public void setData(List<Users> data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
