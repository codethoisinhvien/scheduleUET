/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Phongthien
 */
public class RegistrationSubject {
    private static  RegistrationSubject instance;
    public   ObservableList<SubjectInformation> ScheduleList;
    private RegistrationSubject(){
        ScheduleList = FXCollections.observableArrayList(
                
        );
    }
    public  static synchronized RegistrationSubject getInstansRegistrationSubject(){
      if(instance==null){
          instance = new RegistrationSubject();
      }
      return instance;
    }
      
}
