/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.WorkGroupByLesson;

/**
 *
 * @author Phongthien
 */
public class Schedule {
   public  ObservableList<WorkGroupByLesson> ScheduleList;

    public Schedule() {
        this.ScheduleList = FXCollections.observableArrayList(
                
        );
    }
   public  void createSchedule(int n ){
       for(int i=0;i<n;i++){
           this.ScheduleList.add( new WorkGroupByLesson());
            this.ScheduleList.get(i).setLesson(i+1);
       }
   } 
}
