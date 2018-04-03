
package cr.ac.ucr.IF3000.BiblioTech.domain;

import java.io.Serializable;


public class RequestAudioVisual extends AudioVisual implements Serializable{
    
    private String id_card;
    private int available;
    private String date_remove;
    private String date_delivery;
    private String name;
    private String brand;
    private int amount;
    
    //constructor

    public RequestAudioVisual() {
        
    }

    public RequestAudioVisual(String id_card, int available, String date_remove, String date_delivery, String name, String brand, String model, int code, int amount) {
        super(name, brand, model, code, amount);
        this.id_card = id_card;
        this.available = available;
        this.date_remove = date_remove;
        this.date_delivery = date_delivery;
        this.name = name;
        this.brand = brand;
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
    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public int getAmount() {
        return amount;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }
    //toString()

    @Override
    public String toString() {
        return super.toString()+"RequestAudioVisual{" + "id_card=" + id_card + ", available=" + available + ", date_remove=" + date_remove + ", date_delivery=" + date_delivery + ", name=" + name + ", brand=" + brand + ", amount=" + amount + '}';
    }

    
}
