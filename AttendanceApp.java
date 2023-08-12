//Pranav Civi
//UIN: 431005071
package application;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class AttendanceApp {
	
	private String rosterFile;
	private String swipeFile;
	private ArrayList<String> mainList;
	
	AttendanceApp(){
		rosterFile = "";
		swipeFile = "";
		mainList = new ArrayList<String>();
	}
	
	AttendanceApp(String r, String s){
		rosterFile = r;
		swipeFile = s;
		mainList = new ArrayList<String>();
	}
	
	public String getRosterFile() {
		return rosterFile;
	}
	public String getSwipeFile() {
		return swipeFile;
	}
	public void setRosterFile(String s) {
		rosterFile = s;
	}
	public void setSwipeFile(String s) {
		swipeFile = s;
	}
	
	public int compareTo(AttendanceApp other) {
		if(this.swipeFile.compareTo(other.swipeFile) < 0)
			return -1;
		else if(this.swipeFile.compareTo(other.swipeFile) > 0)
			return 1;
		return 0;
	}
	public boolean equals(AttendanceApp other) {
		return this.swipeFile.equals(other.swipeFile);
	}
	public String toString() {
		return "Roster file: " + this.rosterFile + "\n" + "Swipe file: " + this.swipeFile;
	}
	
	public ArrayList<String> list_students_not_in_class() {
		
		//get the student list ready
		StudentRoster roster = new StudentRoster();
		roster.load_roster(rosterFile);
		
		
		//get the attendance log ready
		AttendanceLog log = new AttendanceLog(swipeFile);
		
		//list to store students that are missing
		ArrayList<String> missingList = new ArrayList<String>();
		ArrayList<Student> presentList = new ArrayList<Student>();
		
		//loop through the swipe file. For each line, load into the log list
		//each time, check if the student is in the students list. if not, add to the missingList
		Scanner sc = null;
		File file = new File(swipeFile);
		try {sc = new Scanner(file);}
		catch (FileNotFoundException e) {e.printStackTrace();}
		

		
		while(sc.hasNext()) {
			log.load_log();
			
			String tempLast = log.getLogList().get(log.getCount()-1).getLastName();
			String tempFirst = log.getLogList().get(log.getCount()-1).getFirstName();
			Student tempStu = new Student(tempLast, tempFirst);
			presentList.add(tempStu);
			
			sc.nextLine();
				
		}
		sc.close();
		
		//find who is missing
		//roster contains all the students
		//presentlist contains the students that are here
		
		for(int i = 0; i < roster.getCount(); i++) {
			boolean found = false;
			String tempLast = roster.getRoster().get(i).getLastName();
			String tempFirst = roster.getRoster().get(i).getFirstName();
			Student temp = new Student(tempLast, tempFirst);
			for(int k = 0; k < presentList.size(); k++) {
				if(presentList.get(k).equals(temp))
					found = true;
			}
			
			if(!found)
				missingList.add(temp.toString());
		}
		
		mainList = missingList;
		return missingList;
		
		//print the missingList
//		System.out.println("****** Students missing in class *************");
//		for(int i = 0; i < missingList.size(); i++) {
//			System.out.println(missingList.get(i).getLastName() + ", " + missingList.get(i).getFirstName());
//		}
	}
	
	public ArrayList<String> list_all_times_checking_in_and_out(Student stu) {
		AttendanceLog log = new AttendanceLog(swipeFile);
		log.load_all_logs();
		ArrayList<String> myList = new ArrayList<String>();
		
//		System.out.println("****** List all swipe in and out for a student *******");
		for(int i = 0; i < log.getCount(); i++) {
			String tempLast = log.getLogList().get(i).getLastName();
			String tempFirst = log.getLogList().get(i).getFirstName();
			Student temp = new Student(tempLast, tempFirst);
			if(temp.equals(stu)) {
				myList.add(log.getLogList().get(i).toString());
//				System.out.println(log.getLogList().get(i).toString());
			}
		}
		mainList = myList;
		return myList;
	}
	
	public ArrayList<String> list_all_times_checked_in() {
//		System.out.println("****** Check in times for all students who attended***");
		AttendanceLog log = new AttendanceLog(swipeFile);
		log.load_all_logs();
		ArrayList<String> myList = new ArrayList<String>();
		
		StudentRoster roster = new StudentRoster();
		roster.load_roster(rosterFile);
		
		for(int i = 0; i < roster.getCount(); i++) {
			boolean found = false;
			Student search = roster.getRoster().get(i);
			for(int k = 0; k < log.getCount(); k++) {
				String tempLast = log.getLogList().get(k).getLastName();
				String tempFirst = log.getLogList().get(k).getFirstName();
				Student temp = new Student(tempLast, tempFirst);
				if(!found && search.equals(temp)) {
					found = true;
					myList.add(log.getLogList().get(k).toString());
//					System.out.println(log.getLogList().get(k));
				}
			}
		}
		mainList = myList;
		return myList;
		
		
	}
	
	public ArrayList<String> list_students_late_to_class(String time, String date) {
//		System.out.println("****** Students that arrived late ********************");
		
		
		int hours = Integer.parseInt(time.substring(0, 2));
		int min = Integer.parseInt(time.substring(3, 5));
		int sec = Integer.parseInt(time.substring(6));
		int deadlineSeconds = (hours*60*60) + (min*60) + sec;
		
		AttendanceLog log = new AttendanceLog(swipeFile);
		log.load_all_logs();
		
		StudentRoster roster = new StudentRoster();
		roster.load_roster(rosterFile);
		
		ArrayList<Student> visitedStudents = new ArrayList<Student>();
		ArrayList<String> myList = new ArrayList<String>();
		
		//loop through the log list. For every time that is higher than the given time
		//create a student for that log and add it to a visitedStudents list.
		for(int i = 0; i < log.getCount(); i++) {
			
			String tempDate = log.getLogList().get(i).getDate();
			
			int currHours = Integer.parseInt(log.getLogList().get(i).getTime().substring(0, 2));
			int currMin = Integer.parseInt(log.getLogList().get(i).getTime().substring(3, 5));
			int currSec = Integer.parseInt(log.getLogList().get(i).getTime().substring(6));
			int currSeconds = (currHours*60*60) + (currMin*60) + currSec;
			
			if( currSeconds > deadlineSeconds && currSeconds <= deadlineSeconds + 75) {
				String tempLast = log.getLogList().get(i).getLastName();
				String tempFirst = log.getLogList().get(i).getFirstName();
				Student temp = new Student(tempLast, tempFirst);
				boolean visited = false;
				
				for(int k = 0; k < visitedStudents.size(); k++) {
					if(visitedStudents.get(k).equals(temp)) {
						visited = true;
					}
				}
				if(tempDate == date) {
					visitedStudents.add(temp);
					myList.add(log.getLogList().get(i).toString());
//					System.out.println(log.getLogList().get(i).toString());
				}
			}
			
		}
		mainList = myList;
		return myList;
		
	}
	
	public String print_attendance_date_for_student(Student s) {
//		System.out.println("********* Looking up Student Attendance Data ***********");
		String output = "";
		AttendanceLog log = new AttendanceLog(swipeFile);
		log.load_all_logs();
		
//		boolean logIn = true;
		boolean found = false;
		
		for(int i = 0; i < log.getCount(); i++) {
			Student temp = new Student(log.getLogList().get(i).getLastName(), log.getLogList().get(i).getFirstName());
			if(temp.equals(s)) {
				found = true;
//				if(logIn) {
//					System.out.println(log.getLogList().get(i).toString());
//				}
//				logIn = !logIn;
				output += log.getLogList().get(i).toString() + "\n";
//				System.out.println(log.getLogList().get(i).toString());

			}
		}
		if(!found)
			return("No student of this name in the attendance log");
		return output;
	}
	
	public boolean is_present(Student s, String date) {
//		System.out.println("**** Looking to see if Student was present on date ****");
		AttendanceLog log = new AttendanceLog(swipeFile);
		log.load_all_logs();
		
		for(int i = 0; i < log.getCount(); i++) {
			Student temp = new Student(log.getLogList().get(i).getLastName(), log.getLogList().get(i).getFirstName());
			String tempDate = log.getLogList().get(i).getDate();
			if(temp.equals(s) && tempDate.equals(date)) {
//				System.out.println("True");
				return true;
			}
		}
//		System.out.println("False");
		return false;
	}
	
	public ArrayList<String> list_all_students_checked_in(String date) {
//		System.out.println("**** Students present on this date ****");
		//have a arraylist of students that have already been checked in
		
		AttendanceLog log = new AttendanceLog(swipeFile);
		log.load_all_logs();
		
		ArrayList<Student> checkedIn = new ArrayList<Student>();
		ArrayList<String> myList = new ArrayList<String>();
		
		//loop through loglist
		for(int i = 0; i < log.getCount(); i++) {
			if(log.getLogList().get(i).getDate().equals(date)) {
				Student temp = new Student(log.getLogList().get(i).getLastName(), log.getLogList().get(i).getFirstName());
				//check if temp is in checkedIn
				boolean found = false;
				for(int k = 0; k < checkedIn.size(); k++) {
					if(checkedIn.get(k).equals(temp)) {
						found = true;
					}
				}
				if(!found) {
					checkedIn.add(temp);
//					System.out.println(temp.toString());
					myList.add(temp.toString());
				}
			}
		}
		mainList = myList;
		return myList;
		
	}
	
	public ArrayList<String> list_all_students_checked_in_before(String date, String time) {
//		System.out.println("**** Those present on date & before a time assigned ****");
		
		int num = 0;
		AttendanceLog log = new AttendanceLog(swipeFile);
		log.load_all_logs();
		ArrayList<String> myList = new ArrayList<String>();
		
		for(int i = 0; i < log.getCount(); i++) {
			if(log.getLogList().get(i).getDate().equals(date)) {
				int tempHour = Integer.parseInt(log.getLogList().get(i).getTime().substring(0,2))*60*60;
				int tempMin = Integer.parseInt(log.getLogList().get(i).getTime().substring(3, 5))*60;
				int tempSec = Integer.parseInt(log.getLogList().get(i).getTime().substring(6));
				int tempTime = tempHour + tempMin + tempSec;
				int inputTime = Integer.parseInt(time.substring(0,2))*60*60 + Integer.parseInt(time.substring(3, 5))*60 + Integer.parseInt(time.substring(6));
				if(tempTime >= inputTime - 75 && tempTime < inputTime) {
					num++;
					myList.add(new Student(log.getLogList().get(i).getLastName(), log.getLogList().get(i).getFirstName()).toString());
//					System.out.println(new Student(log.getLogList().get(i).getLastName().toString(), log.getLogList().get(i).getFirstName()));
				}
			}
		}
		this.print_count();
//		System.out.println("There were " + num + " records for this query");
		mainList = myList;
		return myList;
		
		
	}
	
	public ArrayList<String> list_students_attendance_count(int days) {
		//print the students that have attended all the days.
		//only 2 days for this project but it should work with n days.
		ArrayList<String> myList = new ArrayList<String>();
//		System.out.println("**** Those who attended BOTH classes ****");
		int count = 0;
		AttendanceLog log = new AttendanceLog(swipeFile);
		log.load_all_logs();
		
		StudentRoster roster = new StudentRoster();
		roster.load_roster(rosterFile);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//initialize the map
		for(int i = 0; i < roster.getCount(); i++) {
			map.put(roster.getRoster().get(i).toString(), 0);
		}
		
		//go through the loglist and for every student, update that student in the map
		
		for(int i = 0; i < log.getCount(); i++) {
			String temp = new Student(log.getLogList().get(i).getLastName(), log.getLogList().get(i).getFirstName()).toString();
			map.put(temp, map.get(temp)+1);
		}
		
		//go through the map and print those that have a value equal to days
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue().equals(days)) {
				count++;
				myList.add(entry.getKey().toString());
//				System.out.println(entry.getKey().toString());
			}
		}
		
		//testing - delete this later
//		for(Map.Entry<String, Integer> entry : map.entrySet()) {
//			if(entry.getValue().equals(0)) {
//				System.out.println("Missing both days: " + entry.getKey());
//			}
//		}
		this.print_count();
		mainList = myList;
		return myList;
//		System.out.println("There were " + count + " records for this query");
		
	}
	
	public Student get_first_student_to_enter(String date) {
		
		AttendanceLog log = new AttendanceLog(swipeFile);
		log.load_all_logs();
		
		for(int i = 0; i < log.getCount(); i++) {
			if(log.getLogList().get(i).getDate().equals(date)) {
//				System.out.println("**** First student to enter on " + date + " ****");
				return new Student(log.getLogList().get(i).getLastName(), log.getLogList().get(i).getFirstName());
			}
		}
		
		return null;
	}
	
	public String print_query_list() {
		String output = "";
		for(int i = 0; i < mainList.size(); i++) {
			output += mainList.get(i).toString() + "\n";
//			System.out.println(mainList.get(i).toString());
		}
		return output;
	}
	
	public String print_count() {
		return("There were " + mainList.size() + " records for this query");
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	public ArrayList<String> getMainList() {
		return mainList;
	}
	public void setMainList(ArrayList<String> mainList) {
		this.mainList = mainList;
	}

}
