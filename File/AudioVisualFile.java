
package File;

import cr.ac.ucr.IF3000.BiblioTech.domain.AudioVisual;
import cr.ac.ucr.IF3000.BiblioTech.domain.Books;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class AudioVisualFile {
       
    //Characteristic
    public RandomAccessFile randomAccessFile;
    private int regSize;
    private int regQuantity;
    private String myPath;
    
    //constructor
    public AudioVisualFile(){
        
    }
    
    public AudioVisualFile(File file) throws IOException{
        this.myPath = file.getPath();
        this.regSize = 170;
        if(file.exists() && !file.isFile()){
            throw  new IOException(file.getName() + "is a invalid file");
        }else{
            randomAccessFile = new RandomAccessFile(file, "rw");
            this.regQuantity = (int)Math.ceil((double)randomAccessFile.length() / (double)this.regSize);
        }
    }
    
    //insert the audiovisual
    public boolean insertAudioVisual(int position, AudioVisual insertAudio) throws IOException{
        if(position >= 0 && position <= this.regQuantity){
            if(insertAudio.sizeInBytesAudio()> this.regSize){
                System.err.println("102  record size is large");
                return false;
            }else{
                randomAccessFile.seek(position * this.regSize);
                randomAccessFile.writeUTF(insertAudio.getName());
                randomAccessFile.writeUTF(insertAudio.getBrand());
                randomAccessFile.writeUTF(insertAudio.getModel());
                randomAccessFile.writeInt(insertAudio.getCode());
                randomAccessFile.writeInt(insertAudio.getAmount());
                
                randomAccessFile.close();
                
                return true;
            }
        }else{
            System.err.println("101  position is out of bounds");
            return false;
        }
    }
    //method to insert in the end of the file
    public boolean insertToEnd(AudioVisual audioVisual) throws IOException{
        boolean success = insertAudioVisual(this.regQuantity, audioVisual);
        
        if(success){
            ++this.regQuantity;
        }
        return success;
    }//end method
    //method to generate the code of audiovisual
    public int convertNumber() throws IOException{
        AudioVisual audioTemp;
        int code=0;
        for(int i = 0; i<this.regQuantity;i++){
            audioTemp = this.getAudio(i);
            code = audioTemp.getCode();
        }
        return code;
    }//end method
    
    //method to get the equitment of the file
    public AudioVisual getAudio(int position) throws IOException{
        if(position >= 0 && position <= this.regQuantity){
            randomAccessFile.seek(position * this.regSize);
            AudioVisual audioTemp = new AudioVisual();
            audioTemp.setName(randomAccessFile.readUTF());
            audioTemp.setBrand(randomAccessFile.readUTF());
            audioTemp.setModel(randomAccessFile.readUTF());
            audioTemp.setCode(randomAccessFile.readInt());
            audioTemp.setAmount(randomAccessFile.readInt());
            return audioTemp;
        }else{
            System.err.println("103 - position is out of bounds");
            return null;
        }
    }//end method
    
    //method to charge the list of audiovisual
    public ArrayList<AudioVisual> getAudioList() throws IOException{
        ArrayList<AudioVisual> arrayListOfAudio = new ArrayList<>();
        for(int i = 0;i<this.regQuantity;i++){
            AudioVisual audioTemp = this.getAudio(i);
            if(audioTemp != null){
                arrayListOfAudio.add(audioTemp);
            }
        }
        return arrayListOfAudio;
    }//end method
    
}
