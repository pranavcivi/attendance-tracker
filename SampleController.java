//Pranav Civi
//UIN: 431005071
package application;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

public class SampleController {
	
//	@FXML private ListView<String> lv;
	
	@FXML private Text rosterFileText;
	@FXML private Text swipeFileText;
	@FXML private Button go;
	
	@FXML private Button loadRosterFile;
	@FXML private Button loadSwipeFile;
	
	@FXML private Button load_log_AL;
	@FXML private Button print_collection_AL;
	@FXML private Button print_count_AL;
	@FXML private Button load_log_SR;
	@FXML private Button print_collection_SR;
	@FXML private Button print_count_SR;
	@FXML private Button list_students_not_in_class;
	@FXML private Button list_all_times_checking_in_and_out;
	@FXML private Button list_all_times_checked_in;
	@FXML private Button list_students_late_to_class;
	@FXML private Button get_first_student_to_enter;
	@FXML private Button print_attendance_data_for_student;
	@FXML private Button is_present;
	@FXML private Button list_all_students_checked_in;
	@FXML private Button list_all_students_checked_in_before;
	@FXML private Button list_students_attendance_count;
	@FXML private Button print_query_list;
	@FXML private Button print_count;
	@FXML private Button exit;
	
	
	@FXML private ScrollPane scroll_pane;
	@FXML private TextArea textArea;
	
	@FXML private Text name;
	@FXML private Text uin;
	@FXML private Text email;
	
	@FXML private TextField Hbox;
	@FXML private TextField Ibox;
	@FXML private TextField latebox;
	@FXML private TextField Kbox;
	@FXML private TextField Lbox;
	@FXML private TextField Mbox1;
	@FXML private TextField Mbox2;
	@FXML private TextField NBox;
	@FXML private TextField Obox1;
	@FXML private TextField Obox2;
	@FXML private TextField Pbox;
	@FXML private Text instructions;
	
	String rosterFile;
	String swipeFile;
	
	AttendanceLog log = new AttendanceLog();
	StudentRoster sr = new StudentRoster();
	AttendanceApp aa = new AttendanceApp();
	
	
	public void initialize() {
		textArea.setText("");
		rosterFile = "";
		swipeFile = "";
	}
	
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	public void rosterFile_listener(ActionEvent e) {
		FileChooser fc = new FileChooser();
		File selectedFile = fc.showOpenDialog(null);
		
		if(selectedFile != null) {
			rosterFileText.setText(selectedFile.getAbsolutePath());
		}
		
		
	}
	
	public void swipeFile_listener(ActionEvent e) {
		FileChooser fc = new FileChooser();
		File selectedFile = fc.showOpenDialog(null);
		if(selectedFile != null) {
			swipeFileText.setText(selectedFile.getAbsolutePath());
		}
		
	}
	
	public void go_listener(ActionEvent e) {
		rosterFile = rosterFileText.getText();
		swipeFile = swipeFileText.getText();
		
		aa = new AttendanceApp(rosterFile, swipeFile);
		log = new AttendanceLog(swipeFile);
		sr = new StudentRoster(rosterFile);
//		System.out.println(rosterFile + " " + swipeFile);
	}
	
	
	
	
	public void load_log_AL_listener(ActionEvent e) {
		if(rosterFile != "" && swipeFile != "") {
			log.load_all_logs();
			textArea.setText("loaded all logs from swipe file");
		}
		else
			textArea.setText("load a roster and swipe file first");
		
	}
	
	public void print_collection_AL_listener(ActionEvent e) {
		if(rosterFile != "" && swipeFile != "") {
			textArea.setText(log.print_collection());
		}
		else
			textArea.setText("load a roster and swipe file first");
		
	}
	
	public void print_count_AL_listener(ActionEvent e) {
		if(rosterFile != "" && swipeFile != "") {
			textArea.setText(Integer.toString(log.getCount()));
		}
		else
			textArea.setText("load a roster and swipe file first");
		
	}
	
	public void load_log_SR_listener(ActionEvent e) {
		if(rosterFile != "" && swipeFile != "") {
			sr.load_roster();
			textArea.setText("loaded all logs from roster file");
		}
		else
			textArea.setText("load a roster and swipe file first");
		
	}
	
	public void print_collection_SR_listener(ActionEvent e) {
		
		if(rosterFile != "" && swipeFile != "") {
			textArea.setText(sr.print_collection());
		}
		else
			textArea.setText("load a roster and swipe file first");
	}
	
	public void print_count_SR(ActionEvent e) {
		if(rosterFile != "" && swipeFile != "") {
			textArea.setText(Integer.toString(sr.getCount()));
		}
		else
			textArea.setText("load a roster and swipe file first");
		
	}
	
	public void list_students_not_in_class_listener(ActionEvent e) {
		if(rosterFile != "" && swipeFile != "") {
			textArea.setText("****** Students missing in class *************\n");
			aa.list_students_not_in_class();
			textArea.setText(textArea.getText() + aa.print_query_list());
		}
		else
			textArea.setText("load a roster and swipe file first");
		
	}
	
	public void list_all_times_checking_in_and_out_listener(ActionEvent e) {
		if(rosterFile != "" && swipeFile != "") {
			textArea.setText("****** List all swipe in and out for a student *******\n");
			String userInput = Hbox.getText();
			int space = userInput.indexOf(' ');
			aa.list_all_times_checking_in_and_out(new Student(userInput.substring(0, space), userInput.substring(space+1)));
			textArea.setText(textArea.getText() + aa.print_query_list());
		}
		else
			textArea.setText("load a roster and swipe file first");
		
	}
	
	public void list_all_times_checked_in_listener(ActionEvent e) {
		if(rosterFile != "" && swipeFile != "") {
			textArea.setText("****** Check in times for all students who attended***\n");
			aa.list_all_times_checked_in();
			textArea.setText(textArea.getText() + aa.print_query_list());
		}
		else
			textArea.setText("load a roster and swipe file first");
		
	}
	
	public void list_students_late_to_class_listener(ActionEvent e) {
		if(rosterFile != "" && swipeFile != "") {
			textArea.setText("****** Students that arrived late ********************\n");
			aa.list_students_late_to_class(Ibox.getText(), latebox.getText());
			textArea.setText(textArea.getText() + aa.print_query_list());
		}
		else
			textArea.setText("load a roster and swipe file first");
		
	}
	
	public void get_first_student_to_enter_listener(ActionEvent e) {
		if(rosterFile != "" && swipeFile != "") {
			textArea.setText("**** First student to enter on " + Kbox.getText() + " ****\n");
			textArea.setText(textArea.getText() + aa.get_first_student_to_enter(Kbox.getText()).toString());
		}
		else
			textArea.setText("load a roster and swipe file first");
		
	}
	
	public void print_attendance_date_for_student_listener(ActionEvent e) {
		if(rosterFile != "" && swipeFile != "") {
			textArea.setText("********* Looking up Student Attendance Data ***********\n");
			String userInput = Lbox.getText();
			int space = userInput.indexOf(' ');
			textArea.setText(textArea.getText() + aa.print_attendance_date_for_student(new Student(userInput.substring(0, space), userInput.substring(space+1))));
		}
		else
			textArea.setText("load a roster and swipe file first");
		
	}
	
	public void is_present_listener(ActionEvent e) {
		if(rosterFile != "" && swipeFile != "") {
			textArea.setText("**** Looking to see if Student was present on date ****\n");
			String lastName = Mbox1.getText().substring(0, Mbox1.getText().indexOf(' '));
			String firstName = Mbox1.getText().substring(Mbox1.getText().indexOf(' ')+1);
			String date = Mbox2.getText();
			textArea.setText(textArea.getText() + aa.is_present(new Student(lastName, firstName), date));
		}
		else
			textArea.setText("load a roster and swipe file first");
		
		
	}
	
	public void list_all_students_checked_in_listener(ActionEvent e) {
		if(rosterFile != "" && swipeFile != "") {
			textArea.setText("**** Students present on this date ****\n");
			String date = NBox.getText();
			aa.list_all_students_checked_in(date);
			textArea.setText(textArea.getText() + aa.print_query_list());
//			textArea.setText("list_all_students_checked_in works");
		}
		else
			textArea.setText("load a roster and swipe file first");
		
	}
	
	public void list_all_students_checked_in_before_listener(ActionEvent e) {
		if(rosterFile != "" && swipeFile != "") {
			textArea.setText("**** Those present on date & before a time assigned ****\n");
			String date = Obox1.getText();
			String time = Obox2.getText();
			aa.list_all_students_checked_in_before(date, time);
			textArea.setText(textArea.getText() + aa.print_query_list());
		}
		else
			textArea.setText("load a roster and swipe file first");
		
	}
	
	public void list_students_attendance_count_listener(ActionEvent e) {
		if(rosterFile != "" && swipeFile != "") {
			textArea.setText("**** Those who attended BOTH classes ****\n");
			int num = Integer.parseInt(Pbox.getText());
			aa.list_students_attendance_count(num);
			textArea.setText(textArea.getText() + aa.print_query_list());
		}
		else
			textArea.setText("load a roster and swipe file first");
		
	}
	
	public void print_query_list_listener(ActionEvent e) {
		if(rosterFile != "" && swipeFile != "") {
			textArea.setText(aa.print_query_list());
		}
		else
			textArea.setText("load a roster and swipe file first");
		
	}
	
	public void print_count_listener(ActionEvent e) {
		if(rosterFile != "" && swipeFile != "") {
			textArea.setText(aa.print_count());
		}
		else
			textArea.setText("load a roster and swipe file first");
		
	}
	
	public void exit_listener(ActionEvent e) {
		System.exit(0);
	}
	
	
	
	
	
}
