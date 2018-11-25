/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.SubjectInformation;
import model.Excel;
import model.Http;
import model.RegistrationSubject;
import model.Schedule;
import model.WorkGroupByLesson;


/**
 *
 * @author Phongthien
 */
public class FXMLDocumentController implements Initializable {
     public  RegistrationSubject registrationSubject = RegistrationSubject.getInstansRegistrationSubject();
     private Http http; 
     private ObservableList<SubjectInformation> SubjectList;
     private ObservableList<SubjectInformation> tmp;
     private  Schedule scheduList;
    @FXML
    private Label label;
    @FXML
    private TextField txtSearch;
    @FXML
    private TableView<SubjectInformation> tbSubject;
    @FXML
    private TableColumn<SubjectInformation, String> tcId;
    @FXML
    private TableColumn<SubjectInformation, String>tcNam;
    @FXML
    private TableColumn<SubjectInformation,Integer> tcNocredit;
    @FXML
    private TableColumn<SubjectInformation, String> tcIdClass;
    @FXML
    private TableColumn<SubjectInformation,Integer>tcNoStudent;
    @FXML
    private TableColumn<SubjectInformation, String> tcTeacher;
    @FXML
    private TableColumn<SubjectInformation, String> tcSession;
    @FXML
    private TableColumn<SubjectInformation, String> tcDayOfWeek;
    @FXML
    private TableColumn<SubjectInformation, String> tcLesson;
    @FXML
    private TableColumn<SubjectInformation, String> tcLocation;
    @FXML
    private TableColumn<SubjectInformation, String> tcNote;
    @FXML
    private TableView<WorkGroupByLesson> tbSchedule;
    @FXML
    private TableColumn<WorkGroupByLesson, Integer> tcLessonSchedule;
    @FXML
    private TableColumn<WorkGroupByLesson, String> tcMonday;
    @FXML
    private TableColumn<WorkGroupByLesson, String> tcTuseDay;
    @FXML
    private TableColumn<WorkGroupByLesson, String> tcWednesDay;
    @FXML
    private TableColumn<WorkGroupByLesson, String> tcThusrDay;
    @FXML
    private TableColumn<WorkGroupByLesson, String> tcFriday;
    @FXML
    private TableColumn<WorkGroupByLesson, String> tcSaturday;
    @FXML
    private TableColumn<WorkGroupByLesson, String> tcSunday;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField txtDelete;
    @FXML
    private Button btnAccept;
    @FXML
    private TextField txtUseNam;
    @FXML
    private PasswordField txtPassWord;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnShowSubject;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    private  void searchSubject(String text){
       tmp.clear();
       for(int i=0;i<SubjectList.size();i++){
           if(SubjectList.get(i).ID.contains(text)){
               tmp.add(SubjectList.get(i));
           }
       }
       tmp.sort(new Comparator<SubjectInformation>(){
           @Override
           public int compare(SubjectInformation o1, SubjectInformation o2) {
               return  o1.ID.compareTo(o2.ID);
           }
           
       });
      tbSubject.setItems(tmp);
    }
    private void addScheldule(SubjectInformation a){
         
               System.out.println(a.Lesson);
     String b[] = a.Lesson.split("-");
        int i= Integer.parseInt(b[0]);
        int n = Integer.parseInt(b[1]);
        if(a.Note.contains("N")){
        if(searchTheory(a)){
             registrationSubject.ScheduleList.add(a);
        for(i=i-1;i<n;i++){
           switch(a.DayOfTheWeek){
               case "2":
                   scheduList.ScheduleList.get(i).setMonDay(a.Name);
                    break;
               case "3":
                    scheduList.ScheduleList.get(i).setTuseDay(a.Name);
                    break;
               case "4":
                    scheduList.ScheduleList.get(i).setWednesDay(a.Name);
                    break;
               case "5":
                    scheduList.ScheduleList.get(i).setThusrDay(a.Name);
                    break;
               case "6": 
                    scheduList.ScheduleList.get(i).setFriday(a.Name);
                    break;
               case "7":
                    scheduList.ScheduleList.get(i).setSaturday(a.Name);
                    break;
               case "CN":
                    scheduList.ScheduleList.get(i).setSunday(a.Name);
                   break;
           }
        }
} else{
    System.out.println("trùng lịch");
} 
        }else{
           if(isOnlyFullClass(a)){
                registrationSubject.ScheduleList.add(a);
               for(i=i-1;i<n;i++){
           switch(a.DayOfTheWeek){
               case "2":
                   scheduList.ScheduleList.get(i).setMonDay(a.Name);
                    break;
               case "3":
                    scheduList.ScheduleList.get(i).setTuseDay(a.Name);
                    break;
               case "4":
                    scheduList.ScheduleList.get(i).setWednesDay(a.Name);
                    break;
               case "5":
                    scheduList.ScheduleList.get(i).setThusrDay(a.Name);
                    break;
               case "6": 
                    scheduList.ScheduleList.get(i).setFriday(a.Name);
                    break;
               case "7":
                    scheduList.ScheduleList.get(i).setSaturday(a.Name);
                    break;
               case "CN":
                    scheduList.ScheduleList.get(i).setSunday(a.Name);
                   break;
           }
        }
               
           }
           else{
               System.out.println("Có lớp thực hành");  
           }
        }
           
         
       
     
     }
    private boolean isSameSchedule(SubjectInformation e){
        String b[] = e.Lesson.split("-");
        int i= Integer.parseInt(b[0]);
        int n = Integer.parseInt(b[1]);
        for(i=i-1;i<n;i++){
             switch(e.DayOfTheWeek){
               case "2":
                   if(!scheduList.ScheduleList.get(i).getMonDay().equals("")) 
                   return false;
                    break;
               case "3":
                    if(!scheduList.ScheduleList.get(i).getTuseDay().equals("")) 
                   return false;
                    break;
               case "4":
                    if(!scheduList.ScheduleList.get(i).getWednesDay().equals("")) 
                   return false;
                    break;
               case "5":
                   if(!scheduList.ScheduleList.get(i).getThusrDay().equals("")) 
                   return false;
                    break;
               case "6": 
                   if(!scheduList.ScheduleList.get(i).getFriday().equals("")) 
                   return false;
                    break;
               case "7":
                   if(!scheduList.ScheduleList.get(i).getSaturday().equals("")) 
                   return false;
                    break;
               case "CN":
                   if(!scheduList.ScheduleList.get(i).getSunday().equals("")) 
                   return false;
                   break;
           }
        }
        return true;
    }
    private boolean searchTheory(SubjectInformation e){
        System.out.println("views.FXMLDocumentController.searchTheory()");
        for(int i=0;i<SubjectList.size();i++){
            if(e.IDClass.equals(SubjectList.get(i).IDClass)&&SubjectList.get(i).Note.equals("CL")){
               
               if( isSameSchedule(e)&&isSameSchedule(SubjectList.get(i))){
                   registrationSubject.ScheduleList.add(SubjectList.get(i));
         String b[] = SubjectList.get(i).Lesson.split("-");
        int j= Integer.parseInt(b[0]);
        int n = Integer.parseInt(b[1]);
                   System.out.println(n);
                for(j=j-1;j<n;j++){
           switch(SubjectList.get(i).DayOfTheWeek){
               case "2":
                   scheduList.ScheduleList.get(j).setMonDay(SubjectList.get(i).Name);
                    break;
               case "3":
                    scheduList.ScheduleList.get(j).setTuseDay(SubjectList.get(i).Name);
                    break;
               case "4":
                    scheduList.ScheduleList.get(j).setWednesDay(SubjectList.get(i).Name);
                    break;
               case "5":
                    scheduList.ScheduleList.get(j).setThusrDay(SubjectList.get(i).Name);
                    break;
               case "6": 
                    scheduList.ScheduleList.get(j).setFriday(SubjectList.get(i).Name);
                    break;
               case "7":
                    scheduList.ScheduleList.get(j).setSaturday(SubjectList.get(i).Name);
                    break;
               case "CN":
                    scheduList.ScheduleList.get(j).setSunday(SubjectList.get(i).Name);
                   break;
           }
        }
                return true;
                
            }
            }
        }
        return false;
    }
    public boolean  isOnlyFullClass(SubjectInformation a){
        for(int i=0;i<SubjectList.size();i++){
            if(a.IDClass.equals(SubjectList.get(i).IDClass)&&SubjectList.get(i).Note.contains("N")){
                return false;
            }
        }
        return true;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Excel a= new Excel();
        scheduList = new Schedule();
        scheduList.createSchedule(13);
        SubjectList =  FXCollections.observableArrayList();
        tmp =  FXCollections.observableArrayList();
       try {
             a.readExcel();
             for (int i = 0; i <a.Subjects.size(); i++) {
               SubjectList.add(a.Subjects.get(i));
           }
         } catch (IOException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
      
       tcId.setCellValueFactory(new PropertyValueFactory<SubjectInformation, String>("ID"));
       tcNam.setCellValueFactory(new PropertyValueFactory<SubjectInformation, String>("Name"));
       tcNocredit.setCellValueFactory(new PropertyValueFactory<SubjectInformation, Integer>("NoCredit"));
       tcIdClass.setCellValueFactory(new PropertyValueFactory<SubjectInformation, String>("IDClass"));
       tcNoStudent.setCellValueFactory(new PropertyValueFactory<SubjectInformation, Integer>("NoStudent"));
       tcTeacher.setCellValueFactory(new PropertyValueFactory<SubjectInformation, String>("Teacher"));
       tcSession.setCellValueFactory(new PropertyValueFactory<SubjectInformation, String>("Session"));
       tcDayOfWeek.setCellValueFactory(new PropertyValueFactory<SubjectInformation, String>("DayOfTheWeek"));
       tcLesson.setCellValueFactory(new PropertyValueFactory<SubjectInformation, String>("Lesson"));
       tcLocation.setCellValueFactory(new PropertyValueFactory<SubjectInformation, String>("Location"));
       tcNote.setCellValueFactory(new PropertyValueFactory<SubjectInformation, String>("Note"));
       tbSubject.setItems(SubjectList);
       txtSearch.setOnKeyPressed(new EventHandler<Event>(){
            @Override
            public void handle(Event event) {
                tbSubject.refresh();
               if(txtSearch.getText()==""){
                  tbSubject.setItems(SubjectList);
               }else{
                  searchSubject(txtSearch.getText().toUpperCase());  
               }
              
                
             //To change body of generated methods, choose Tools | Templates.
            }
           
       });
       
        txtSearch.setOnKeyReleased(new EventHandler<Event>(){
            @Override
            public void handle(Event event) {
                tbSubject.refresh();
               if(txtSearch.getText()==""){
                  tbSubject.setItems(SubjectList);
               }else{
                  searchSubject(txtSearch.getText().toUpperCase());  
               }
              
                
             //To change body of generated methods, choose Tools | Templates.
            }
           
       });
       
      
       tcLessonSchedule.setCellValueFactory(new PropertyValueFactory<WorkGroupByLesson, Integer>("lesson"));
        tcMonday.setCellValueFactory(new PropertyValueFactory<WorkGroupByLesson, String>("monDay"));
        tcTuseDay.setCellValueFactory(new PropertyValueFactory<WorkGroupByLesson, String>("tuseDay"));
        tcThusrDay.setCellValueFactory(new PropertyValueFactory<WorkGroupByLesson, String>("thusrDay"));
        tcWednesDay.setCellValueFactory(new PropertyValueFactory<WorkGroupByLesson, String>("wednesDay"));
        tcSaturday.setCellValueFactory(new PropertyValueFactory<WorkGroupByLesson, String>("saturday"));
        tcSunday.setCellValueFactory(new PropertyValueFactory<WorkGroupByLesson, String>("sunday"));
        tcFriday.setCellValueFactory(new PropertyValueFactory<WorkGroupByLesson, String>("friday"));
        tbSchedule.setItems(scheduList.ScheduleList);
       ;
        btnAdd.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if(tbSubject.getSelectionModel().getSelectedItem()!=null);{
                
                addScheldule(tbSubject.getSelectionModel().getSelectedItem()); //To change body of generated methods, choose Tools | Templates.
            }
             tbSchedule.refresh();
            }
            
        });
        btnDelete.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                String a= txtDelete.getText();
                System.out.println(a);
                System.out.println(scheduList.ScheduleList.size());
              for(int i=0;i<scheduList.ScheduleList.size();i++){
                  
                  if(scheduList.ScheduleList.get(i).getMonDay().equals(a)){
                    scheduList.ScheduleList.get(i).setMonDay("");
                  }
                  if(scheduList.ScheduleList.get(i).getFriday().equals(a)){
                    scheduList.ScheduleList.get(i).setFriday("");
                  }
                  if(scheduList.ScheduleList.get(i).getThusrDay().equals(a)){
                    scheduList.ScheduleList.get(i).setThusrDay("");
                  }
                  if(scheduList.ScheduleList.get(i).getWednesDay().equals(a)){
                    scheduList.ScheduleList.get(i).setWednesDay("");
                  }
                  if(scheduList.ScheduleList.get(i).getSaturday().equals(a)){
                    scheduList.ScheduleList.get(i).setSaturday("");
                  }
                  if(scheduList.ScheduleList.get(i).getSunday().equals(a)){
                    scheduList.ScheduleList.get(i).setSunday("");
                  }
                  if(scheduList.ScheduleList.get(i).getTuseDay().equals(a)){
                    scheduList.ScheduleList.get(i).setTuseDay("");
                  }
              }
              tbSchedule.setItems(scheduList.ScheduleList);
              tbSchedule.refresh();
                
            }
            
        });
        btnAccept.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                try {
                    a.writeExcel(scheduList.ScheduleList,registrationSubject.ScheduleList); //To change body of generated methods, choose Tools | Templates.
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        http = new Http();
        btnLogin.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                try {
                    http.postLogin();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        btnShowSubject.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
             Parent root = null;
        
            try {
                root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
                
                
                System.out.println(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
            Scene scene = new Scene(root);
            Stage newWindow = new Stage();
            newWindow.setTitle("Update Stage");
            newWindow.setScene(scene);
            newWindow.show();
            
            
            
 
            } 
            
            
        });
    }    
    
}
