/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Phongthien
 */
public class SubjectInformation {
   
    public String ID;
    public String Name;
    public Integer NoCredit;
    public  String IDClass;
    public  Integer NoStudent;
    public  String Teacher;
    public  String Session;
    public  String DayOfTheWeek;
    public  String Lesson;
    public  String Location="";
    public  String Note="";

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setNoCredit(Integer NoCredit) {
        this.NoCredit = NoCredit;
    }

    public void setIDClass(String IDClass) {
        this.IDClass = IDClass;
    }

    public void setNoStudent(Integer NoStudent) {
        this.NoStudent = NoStudent;
    }

    public void setTeacher(String Teacher) {
        this.Teacher = Teacher;
    }

    public void setSession(String Session) {
        this.Session = Session;
    }

    public void setDayOfTheWeek(String DayOfTheWeek) {
        this.DayOfTheWeek = DayOfTheWeek;
    }

    public void setLesson(String Lesson) {
        this.Lesson = Lesson;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public Integer getNoCredit() {
        return NoCredit;
    }

    public String getIDClass() {
        return IDClass;
    }

    public Integer getNoStudent() {
        return NoStudent;
    }

    public String getTeacher() {
        return Teacher;
    }

    public String getSession() {
        return Session;
    }

    public String getDayOfTheWeek() {
        return DayOfTheWeek;
    }

    public String getLesson() {
        return Lesson;
    }

    public String getLocation() {
        return Location;
    }

    public String getNote() {
        return Note;
    }
    
    public SubjectInformation(){
        
    }
    public SubjectInformation(String info){
      // info=info.trim();
       info=info.replaceAll("@","   ");
        String a[] = info.split("   ");
        this.ID= a[0];
        this.Name= a[1];
        this.NoCredit=  (int) Double.parseDouble(a[2]);
        this.IDClass=a[3];
        this.NoStudent=(int) Double.parseDouble(a[4]) ;
        this.Teacher=a[5];
        this.Session =a[6];
        if(!a[7].equals("CN")){
        this.DayOfTheWeek=String.valueOf((int)Double.parseDouble(a[7]));
        }else{
        this.DayOfTheWeek=a[7];    
        }
        this.Lesson=a[8];
       
        try {
             this.Location=a[9];
        } catch (Exception e) {
         }
        try {
          this.Note=a[10];  
        } catch (Exception e) {
        }
        
        
    }
    
}
