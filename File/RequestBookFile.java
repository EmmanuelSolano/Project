
package File;
import cr.ac.ucr.IF3000.BiblioTech.domain.RequestBook;
import cr.ac.ucr.IF3000.BiblioTech.domain.Books;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RequestBookFile {

    //method to insert loan of books with serializable files
    public void insertLoanBook(RequestBook insertLoan){
        FileOutputStream fos = null;
        ObjectOutputStream write = null;
        try {
            fos = new FileOutputStream("./LoanBooks.dat", true);
            write = new ObjectOutputStream(fos);
            write.writeObject(insertLoan);
            
        } catch (FileNotFoundException fnte) {
        }catch(IOException ioe){
        }finally {
            try {
                if(fos!=null) fos.close();
                if(write!=null) write.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }//end method
    
    //save the object in arrayList
    public ArrayList<RequestBook> getLoanList() throws IOException{
        ArrayList<RequestBook> arrayListOfLoan = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("./LoanBooks.dat");
            ObjectInputStream read = new ObjectInputStream(fis);
            RequestBook loanTemp;
            loanTemp = (RequestBook) read.readObject();
            while(loanTemp != null){
                arrayListOfLoan.add(loanTemp);
                read= new ObjectInputStream(fis);
                loanTemp = (RequestBook)read.readObject();  
            }
//            loanTemp = (RequestBook) read.readObject();
//            arrayListOfLoan.add(loanTemp);
        } catch (ClassNotFoundException e) {
        } catch(IOException ioe){
            return arrayListOfLoan;
        }
        
        return null;
    }//end method
}
