
package File;

import cr.ac.ucr.IF3000.BiblioTech.domain.RequestAudioVisual;
import cr.ac.ucr.IF3000.BiblioTech.domain.RequestBook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class RequestAudioVisualFile {
    
    //method to insert loan of books with serializable files
    public void insertLoanAudio(RequestAudioVisual insertLoan){
        FileOutputStream fos = null;
        ObjectOutputStream write = null;
        try {
            fos = new FileOutputStream("./LoanAudioVisual.dat",true);
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
    public ArrayList<RequestAudioVisual> getLoanList() throws IOException{
        ArrayList<RequestAudioVisual> arrayListOfLoan = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("./LoanAudioVisual.dat");
            ObjectInputStream read = new ObjectInputStream(fis);
            RequestAudioVisual loanTemp;
            loanTemp = (RequestAudioVisual) read.readObject();
            while(loanTemp != null){
                arrayListOfLoan.add(loanTemp);
                read= new ObjectInputStream(fis);
                loanTemp = (RequestAudioVisual)read.readObject();  
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
