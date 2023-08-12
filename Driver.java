//Pranav Civi
//UIN: 431005071
package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Driver extends Application {


	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub		
//		AttendanceLog al = new AttendanceLog();
//		al.print_count();
//		al.load_log();
//		al.load_log();
//		al.load_log();
//		al.print_collection();
//		al.print_count();
		
//		StudentRoster sr = new StudentRoster();
//		sr.load_roster("rosters.txt");
//		sr.print_collection();
//		sr.print_count();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the roster file: ");
		String rosterFile = sc.nextLine();
		System.out.print("Enter the swipe file: ");
		String swipeFile = sc.nextLine();
		System.out.println();
//		sc.close();
		
		
//		Scanner scan = new Scanner(System.in);
		String input = "X";
		AttendanceLog log = new AttendanceLog();
		StudentRoster sr = new StudentRoster();
		AttendanceApp aa = new AttendanceApp(rosterFile, swipeFile);
		
		while(input != "0") {
			input = sc.next();
			switch(input) {
			case "A":
				log = new AttendanceLog(swipeFile);
				log.load_all_logs();
				System.out.println("loaded all logs");
				input = "X";
				break;
			case "B":
				System.out.println( log.print_collection());
				input = "X";
				break;
			case "C":
				log.print_count();
				input = "X";
				break;
			case "D":
				sr.load_roster(rosterFile);
				System.out.println("loaded roster file");
				input = "X";
				break;
			case "E":
				System.out.println( sr.print_collection());
				input = "X";
				break;
			case "F":
				sr.print_count();
				input = "X";
				break;
			case "G":
				aa.list_students_not_in_class();
				System.out.println(aa.print_query_list());
				input = "X";
				break;
			case "H":
				aa.list_all_times_checking_in_and_out(new Student("Ince", "Ryan"));
				System.out.println(aa.print_query_list());
				input = "X";
				break;
			case "I":
				aa.list_all_times_checked_in();
				System.out.println(aa.print_query_list());
				input = "X";
				break;
			case "J":
				aa.list_students_late_to_class("18:44:37", "11/3/2022");
				System.out.println(aa.print_query_list());
				input = "X";
				break;
			case "K":
				;
				System.out.println(aa.get_first_student_to_enter("11/3/2022").toString());
				input = "X";
				break;
			case "L":
				aa.print_attendance_date_for_student(new Student("Ince", "Sally"));
				System.out.println(aa.print_attendance_date_for_student(new Student("Ince", "Sally")));
				input = "X";
				break;
			case "M":
				aa.is_present(new Student("Ince", "Sally"), "11/2/2022");
				System.out.println(aa.is_present(new Student("Ince", "Sally"), "11/2/2022"));
				input = "X";
				break;
			case "N":
				aa.list_all_students_checked_in("11/2/2022");
				System.out.println(aa.print_query_list());
				input = "X";
				break;
			case "O":
				aa.list_all_students_checked_in_before("11/2/2022", "09:45:02");
				input = "X";
				System.out.println(aa.print_query_list());
				break;
			case "P":
				aa.list_students_attendance_count(2);
				input = "X";
				System.out.println(aa.print_query_list());
				break;
			case "Q":
				aa.get_first_student_to_enter("11/3/2022");
				input = "X";
				System.out.println(aa.print_query_list());
				break;
			case "R":
				System.out.println(aa.print_query_list());
//				aa.print_query_list();
				input = "X";
				break;
			case "S":
				System.out.println( aa.print_count());
				input = "X";
				break;
			case "0":
				input = "0";
				break;
			}
		}
		sc.close();
		
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter the roster file: ");
//		String rosterFile = sc.nextLine();
//		System.out.print("Enter the swipe file: ");
//		String swipeFile = sc.nextLine();
//		System.out.println();
//		sc.close();
//		
//		AttendanceApp aa = new AttendanceApp(rosterFile, swipeFile);
		
		//	TESTING LIST_STUDENTS_NOT_IN_CLASS
//		ArrayList<String> notInClass = aa.list_students_not_in_class();
//		aa.print_query_list(notInClass);
		//	TESTING LIST_STUDENTS_NOT_IN_CLASS
		
		// 	TESTING LIST_ALL_TIMES_CHECKING_IN_AND_OUT
//		Student s = new Student("Ince", "Sally");
//		ArrayList<String> checkIn = aa.list_all_times_checking_in_and_out(s);
//		aa.print_query_list(checkIn);
		//	TESTING LIST-ALL-TIMES-CHECKING-IN-AND-OUT
		
		// TESTING ALL-TIMES-CHECKED-IN
//		ArrayList<String> checkedIn = aa.list_all_times_checked_in();
//		aa.print_query_list(checkedIn);
		// TESTING ALL-TIMES-CHECKED-IN
		
		// TESTING LIST-STUDENTS-LATE-TO-CLASS
//		ArrayList<String> late = aa.list_students_late_to_class("18:44:37");
//		aa.print_query_list(late);
		// TESTING LIST-STUDENTS-LATE-TO-CLASS
		
		// TESTING PRINT-ATTENDANCE-DATE-FOR-STUDENT
//		aa.print_attendance_date_for_student(new Student("Ince", "Sally"));
//		aa.print_attendance_date_for_student(new Student("Dummy", "Dummy"));
		// TESTING PRINT-ATTENDANCE-DATE-FOR-STUDENT
		
		// TESTING IS-PRESENT
//		System.out.println(aa.is_present(new Student("Ince", "Sally"), "11/2/2022"));
//		System.out.println(aa.is_present(new Student("Ince", "Sally"), "11/32/2022"));
		// TESTING IS-PRESENT
		
		// TESTING LIST-ALL-STUDENTS-CHECKED-IN
//		ArrayList<String> l = aa.list_all_students_checked_in("11/2/2022");
//		aa.print_query_list(l);
		// TESTING LIST-ALL-STUDENTS-CHECKED-IN
		
		// TESTING LIST-ALL-STUDENTS-CHECKED-IN-BEFORE
//		ArrayList<String> b = aa.list_all_students_checked_in_before("11/2/2022", "09:45:02");
//		aa.print_query_list(b);
//		aa.print_count(b);
		// TESTING LIST-ALL-STUDENTS-CHECKED-IN-BEFORE
		
		//TESTING LIST-STUDENTS-ATTENDANCE-COUNT
//		ArrayList<String> c = aa.list_students_attendance_count(2);
//		aa.print_query_list(c);
//		aa.print_count(c);
		//TESTING LIST-STUDENTS-ATTENDANCE-COUNT
		
		//TESTING GET-FIRST-STUDENT-TO-ENTER
//		System.out.println(aa.get_first_student_to_enter("11/3/2022"));
		//TESTING GET-FIRST-STUDENT-TO-ENTER


		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
