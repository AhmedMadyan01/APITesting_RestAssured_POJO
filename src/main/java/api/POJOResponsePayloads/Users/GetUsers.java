package api.POJOResponsePayloads.Users;

public class GetUsers {
    private double page;
    private double per_page;
    private double total;
    private double total_pages;
    private Users users;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
