/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.RegistrationSubject;
import model.SubjectInformation;
import model.WorkGroupByLesson;

/**
 * FXML Controller class
 *
 * @author Phongthien
 */
public class FXMLController implements Initializable {
   private RegistrationSubject registrationSubject = RegistrationSubject.getInstansRegistrationSubject();
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
       tbSubject.setItems(registrationSubject.ScheduleList);
    }    
    
}
