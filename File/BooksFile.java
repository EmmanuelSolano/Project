
package File;

import cr.ac.ucr.IF3000.BiblioTech.domain.AudioVisual;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import cr.ac.ucr.IF3000.BiblioTech.domain.Books;
import java.util.ArrayList;

public class BooksFile {
    //Characteristic
    public RandomAccessFile randomAccessFile;
    private int regSize;
    private int regQuantity;
    private String myPath;
    public int numberBooks = 0;
    
    //constructor
    public BooksFile(){
        
    }
    
    public BooksFile(File file) throws IOException{
        this.myPath = file.getPath();
        this.regSize = 180;
        if(file.exists() && !file.isFile()){
            throw  new IOException(file.getName() + "is a invalid file");
        }else{
            randomAccessFile = new RandomAccessFile(file, "rw");
            this.regQuantity = (int)Math.ceil((double)randomAccessFile.length() / (double)this.regSize);
        }
    }//end of the constructor
    
    //method to insert the book using the randomaccessfile
    public boolean insertBook(int position, Books insertBook) throws IOException{
        if(position >= 0 && position <= this.regQuantity){
            if(insertBook.sizeInBytesBook()> this.regSize){
                System.err.println("102  record size is large");
                return false;
            }else{
                randomAccessFile.seek(position * this.regSize);
                randomAccessFile.writeUTF(insertBook.getTitle());
                randomAccessFile.writeUTF(insertBook.getAuthors());
                randomAccessFile.writeUTF(insertBook.getType());
                randomAccessFile.writeUTF(insertBook.getCode());
                randomAccessFile.writeInt(insertBook.getAmount());
                randomAccessFile.writeInt(insertBook.getAge());
                
                randomAccessFile.close();
                
                return true;
            }
        }else{
            System.err.println("101  position is out of bounds");
            return false;
        }
    }//end method to insertBook
    //method to insert the book in the end of the file
    public boolean insertToEnd(Books book) throws IOException{
        boolean success = insertBook(this.regQuantity, book);
        
        if(success){
            ++this.regQuantity;
        }
        return success;
    }//end method insertToEnd
    
    //method to generate the code of the books
    public String codeBook() throws IOException{
        Books bookTemp;
        String code="", num="0";
        for(int i = 0; i<this.regQuantity;i++){
            bookTemp = this.getBook(i);
            code = bookTemp.getCode();
            i=regQuantity;
        }
        for(int c=15; c<code.length();c++){
            num+=code.charAt(c);
        }
        int number = Integer.parseInt(num);
        ++number;
        return "ISBN -ficticio-"+number;
    }
    
    //method to get the book of the file
    public Books getBook(int position) throws IOException{
        if(position >= 0 && position <= this.regQuantity){
            randomAccessFile.seek(position * this.regSize);
            Books bookTemp = new Books();
            bookTemp.setTitle(randomAccessFile.readUTF());
            bookTemp.setAuthors(randomAccessFile.readUTF());
            bookTemp.setType(randomAccessFile.readUTF());
            bookTemp.setCode(randomAccessFile.readUTF());
            bookTemp.setAmount(randomAccessFile.readInt());
            bookTemp.setAge(randomAccessFile.readInt());
            return bookTemp;
        }else{
            System.err.println("103 - position is out of bounds");
            return null;
        }
    }//end method
    //method to charge the list of book
    public ArrayList<Books> getBooksList() throws IOException{
        ArrayList<Books> arrayListOfBooks = new ArrayList<>();
        for(int i = 0;i<this.regQuantity;i++){
            Books bookTemp = this.getBook(i);
            if(bookTemp != null){
                arrayListOfBooks.add(bookTemp);
            }
        }
        return arrayListOfBooks;
    }//end method
}
