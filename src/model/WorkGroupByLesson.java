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
public class WorkGroupByLesson {
    Integer lesson=0;
   
 
    private String monDay="";
  
    private String  tuseDay="";

    private String wednesDay="";

    private String thusrDay="";
 
    private String friday="";

    private String saturday="";
    
    private String sunday="";
public  void setSunday(String sunday){
    this.sunday=sunday;
}
public String getSunday(){
    return this.sunday;
}
    public void setLesson(Integer lesson) {
        this.lesson = lesson;
    }

    public void setMonDay(String monDay) {
        this.monDay = monDay;
    }

    public void setTuseDay(String tuseDay) {
        this.tuseDay = tuseDay;
    }

    public void setWednesDay(String wednesDay) {
        this.wednesDay = wednesDay;
    }

    public void setThusrDay(String thusrDay) {
        this.thusrDay = thusrDay;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

   

    public Integer getLesson() {
        return lesson;
    }

    public String getMonDay() {
        return monDay;
    }

    public String getTuseDay() {
        return tuseDay;
    }

    public String getWednesDay() {
        return wednesDay;
    }

    public String getThusrDay() {
        return thusrDay;
    }

    public String getFriday() {
        return friday;
    }

    public String getSaturday() {
        return saturday;
    }

    
  
   
}
