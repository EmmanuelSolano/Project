/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import cr.ac.ucr.IF3000.BiblioTech.domain.Student;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Max
 */
public class StudentFile {
    private static RandomAccessFile fileStudents;
    private static int regsQuantity;
    private static int regSize=130;
    
    //Method wich creates randomAccesFile
    public StudentFile(File file)throws IOException{
        if (file.exists()&&!file.isFile()){
            throw new IOException(file.getName()+ "It's not a file");
        }
        fileStudents = new RandomAccessFile(file, "rw");
        regsQuantity = (int)Math.ceil((double)fileStudents.length()/(double)regSize);
    }
    public static void cerrar()throws IOException{
        fileStudents.close();
    }
    //method to add students in the file on the specific position
    public boolean addStudent(int position, Student studentAddToFile) throws IOException{
        //validation of position
        
        if(position >= 0 && position <= this.regsQuantity){
            //check with the size is correct
            if(studentAddToFile.sizeInBytes() > this.regSize || searchExist(studentAddToFile)==true ){
                if(searchExist(studentAddToFile)==false){
                    System.err.println("1004 - car was save before");
                }else{
                    System.err.println("1002 - record size is too large");
                }
                return false;
            }else{
                //write file
                fileStudents.seek(position * this.regSize);
                fileStudents.writeUTF(studentAddToFile.getName());
                fileStudents.writeUTF(studentAddToFile.getMayor());
                fileStudents.writeUTF(studentAddToFile.getYearIncome());
                fileStudents.writeUTF(studentAddToFile.getId());
                
                cerrar();
                return true;
            }
        }else{
            System.err.println("1001 - position is out of bounds");
            return false;
        }
        
    }//end method addVehicle
    //method to search if exist one student before this
    public boolean searchExist(Student studentToSearch) throws IOException{
        Student studentTemp;
        
        if(!studentToSearch.getName().equalsIgnoreCase("delete")){
            for(int i = 0; i<this.regsQuantity;i++){
                studentTemp = this.getStudent(i);
                if(studentTemp.getId()==studentToSearch.getId()){
                    
                        return true;
                }
            }
        }
        return false;
        
    }//end method
    //method to search if exist one student before this it compare de ID
    public boolean searchExistStudent(String IDstudentToSearch) throws IOException{
        Student studentTemp;
       
        
            for(int i = 0; i<this.regsQuantity;i++){
                studentTemp = this.getStudent(i);
                if(studentTemp.getId().equals(IDstudentToSearch)){
                    
                        return true;
                }
            }
       
        return false; 
        
    }//end method
    //get a vehicle in specific position
    public Student getStudent(int position) throws IOException{
        //validation position
        if(position >= 0 && position <= this.regsQuantity){
            fileStudents.seek(position * this.regSize);
            //read
            
            Student studentTemp = new Student();
            studentTemp.setName(fileStudents.readUTF());
            studentTemp.setMayor(fileStudents.readUTF());
            studentTemp.setYearIncome(fileStudents.readUTF());
            studentTemp.setId(fileStudents.readUTF());
            
                return studentTemp;
            
        }else{
            System.err.println("1003 - position is out of bounds");
            return null;
        }
    }//end method
    public boolean addEndRecord(Student student) throws IOException{
        boolean success = addStudent(this.regsQuantity, student);
        
        if(success){
            ++this.regsQuantity;
        }
        return success;
    }//end method
    
    
    //method to return the student within of the file
    public ArrayList<Student> getStudentList() throws IOException{
        //make one instance of array list
        ArrayList<Student> arrayListOfStudents = new ArrayList<>();
        
        //browse the array to insert in the list
        for(int i = 0;i<this.regsQuantity;i++){
            Student studentTemp = this.getStudent(i);
            
            //insert student in the list
            if(studentTemp != null){
                
                arrayListOfStudents.add(studentTemp);
            }
        }
        return arrayListOfStudents;
    }//end method
    //me trae todos los registros menos el delete
    public ArrayList getRegWithoutDetele() throws IOException{
        ArrayList<Student> arrayListOfStudents = new ArrayList<>();
        
        //browse the array to insert in the list
        for(int i = 0;i<this.regsQuantity;i++){
            Student studentTemp = this.getStudent(i);
            
            //insert car in the list
            if((studentTemp != null)){
                if((studentTemp.getName()!="delete")){
                    arrayListOfStudents.add(studentTemp);
                }
                
            }
        }
        
        return arrayListOfStudents;
    }
    //This method brings me the int part of the ID
    public int returnIntID()throws IOException{
        ArrayList<Student> myArray = getRegWithoutDetele();
         int num=0;
        
        if(myArray==null){
            num=1;
        }else{
            
            num= myArray.size()+1;
            
        }
        return num;
    }//End Method
    //Tis method returns all the names wich has the same first letter of ID
    public ArrayList getNames(String L) throws IOException{
        ArrayList<String>array=new ArrayList<>();
        ArrayList<Student>myarray=getRegWithoutDetele();
        for(int i = 0; i<myarray.size();i++){
            Student studentTemp = myarray.get(i);
            String letter = ""+studentTemp.getId().charAt(0);
            if(letter.equals(L)){
                array.add(studentTemp.getName());
            }
        }
        return array;
    }
}
