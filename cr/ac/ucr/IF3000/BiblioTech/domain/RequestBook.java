
package cr.ac.ucr.IF3000.BiblioTech.domain;

import java.io.Serializable;


public class RequestBook extends Books implements Serializable{
    private String id_card;
    private int available;
    private String date_remove;
    private String date_delivery;
    private String title;
    private String authors;
    private int amount;
    
    //construtor

    public RequestBook() {
        
    }


    public RequestBook(String id_card, int available, String date_remove, String date_delivery, String title, String authors, String type, String code, int amount, int age) {
        super(title, authors, type, code, amount, age);
        this.id_card = id_card;
        this.available = available;
        this.date_remove = date_remove;
        this.date_delivery = date_delivery;
        this.title = title;
        this.authors = authors;
        this.amount = amount;
    }

    
    
    //setter's and getter's

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getDate_remove() {
        return date_remove;
    }

    public void setDate_remove(String date_remove) {
        this.date_remove = date_remove;
    }

    public String getDate_delivery() {
        return date_delivery;
    }

    public void setDate_delivery(String date_delivery) {
        this.date_delivery = date_delivery;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    //toString

    @Override
    public String toString() {
        return super.toString()+"RequestBook{" + "id_card="+ id_card+ ", available=" + available + ", date_remove=" + date_remove + ", date_delivery=" + date_delivery + ", title=" + title +", authors=" + authors +", amount=" + amount + '}';
    }
}
