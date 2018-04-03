
package cr.ac.ucr.IF3000.BiblioTech.domain;


public class AudioVisual {
    
    private String name;
    private String brand;
    private String model;
    private int code;
    private int amount;
    
    //constructor
    public AudioVisual(){
        this.name = "";
        this.brand = "";
        this.model = "";
        this.code = 0;
        this.amount = 0;
    }

    public AudioVisual(String name, String brand, String model, int code, int amount) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.code = code;
        this.amount = amount;
    }
    
    //setter's and getter's

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
        return "AudioVisual{" + "name=" + name + ", brand=" + brand + ", model=" + model + ", code=" + code + ", amount=" + amount + '}';
    }
    
    public int sizeInBytesAudio(){
        return 8 + this.getName().length() * 2 +
                this.getBrand().length() * 2 +
                this.getModel().length() * 2;
    }
    
}
