package d.androidapps.ecommerceapp;

public class Offer {
    private String oid;
    private String category;
    private int cashback;
    private String link;
    private String title;
    private String terms;
    private String store;

    public Offer(String oid, String category, int cashback, String link, String title, String terms, String store) {
        this.oid = oid;
        this.category = category;
        this.cashback = cashback;
        this.link = link;
        this.title = title;
        this.terms = terms;
        this.store = store;
    }

    public String getOid() {
        return oid;
    }

    public String getCategory() {
        return category;
    }

    public int getCashback() {
        return cashback;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public String getTerms() {
        return terms;
    }

    public String getStore() {
        return store;
    }
}
