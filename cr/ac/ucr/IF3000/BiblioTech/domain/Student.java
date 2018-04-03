/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.IF3000.BiblioTech.domain;

/**
 *
 * @author Max
 */
public class Student {
    private String name;
    private String mayor;
    private String yearIncome;
    private static int contador=000;
    private String id;

    public Student(String name, String mayor, String yearIncome, String id) {
        this.name = name;
        this.mayor = mayor;
        this.yearIncome = yearIncome;
        this.id =id;
    }
    
    public Student(){
        
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mayor
     */
    public String getMayor() {
        return mayor;
    }

    /**
     * @param mayor the mayor to set
     */
    public void setMayor(String mayor) {
        this.mayor = mayor;
    }

    /**
     * @return the yearIncome
     */
    public String getYearIncome() {
        return yearIncome;
    }

    /**
     * @param yearIncome the yearIncome to set
     */
    public void setYearIncome(String yearIncome) {
        this.yearIncome = yearIncome;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    public int sizeInBytes(){
        return this.id.length()+this.mayor.length()+this.name.length()+this.yearIncome.length()*2;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", mayor=" + mayor + ", yearIncome=" + yearIncome + ", id=" + id + "}";
    }
    
    
}
