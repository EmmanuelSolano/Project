
package cr.ac.ucr.IF3000.BiblioTech.domain;


public class Books {
    
    private String title;
    private String authors;
    private String type;
    private String code;
    private int amount;
    private int age;

    //constructor
    public Books(){
        this.title = "";
        this.authors = "";
        this.type = "";
        this.code = "";
        this.amount = 0;
        this.age = 0;
    }

    public Books(String title, String authors, String type, String code, int amount, int age) {
        this.title = title;
        this.authors = authors;
        this.type = type;
        this.code = code;
        this.amount = amount;
        this.age = age;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAge() {
        return age;
    }

    //settter's and getter's
    public void setAge(int age) {
        this.age = age;
    }

    //String

    @Override
    public String toString() {
        return "Books{" + "title=" + title + ", authors=" + authors + ", type=" + type + ", code=" + code + ", amount=" + amount + ", age=" + age + '}';
    }
    
    public int sizeInBytesBook(){
        return 8 + this.getTitle().length() * 2 +
                this.getAuthors().length() * 2 +
                this.getType().length() * 2;
    }
            
}
