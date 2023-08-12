//Pranav Civi
//UIN: 431005071
package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentRoster {
	
	private int count;
	private String rosterFile;
	private ArrayList<Student> roster;
	
	
	StudentRoster(){
		count = 0;
		roster = new ArrayList<Student>();
	}
	StudentRoster(String s){
		count = 0;
		rosterFile = s;
		roster = new ArrayList<Student>();
	}
	public ArrayList<Student> getRoster(){
		return roster;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int n) {
		count = n;
	}
	public void setRoster(ArrayList<Student> list) {
		roster = list;
	}
	public void load_roster() {
		Scanner sc = null;
		File file = new File(rosterFile);
		try {sc = new Scanner(file);}
		catch (FileNotFoundException e) {e.printStackTrace();}
		
		for(int i = 0; i < count; i++) {
			sc.nextLine();
		}
		
		while(sc.hasNext()) {
			Student student = new Student(sc.next(), sc.next());
			roster.add(student);
			this.count++;
		}
		sc.close();
		
	}
	
	public void load_roster(String f) {
		this.count = 0;
		Scanner sc = null;
		File file = new File(f);
		try {sc = new Scanner(file);}
		catch (FileNotFoundException e) {e.printStackTrace();}
		
		for(int i = 0; i < count; i++) {
			sc.nextLine();
		}
		
		while(sc.hasNext()) {
			Student student = new Student(sc.next(), sc.next());
			roster.add(student);
			this.count++;
		}
		sc.close();
		
	}
	
//	public void print_collection() {
//		System.out.println("**** Those students on roster ****");
//		for(int i = 0; i < roster.size(); i++) {
//			System.out.println(roster.get(i).toString());
//		}
//	}
	public String print_collection() {
		String output = "";
		output += ("**** Those students on roster ****\n");
		for(int i = 0; i < roster.size(); i++) {
			output += roster.get(i).toString() + "\n";
//			System.out.println(roster.get(i).toString());
		}
		return output;
	}
	
	public void print_count() {
		System.out.println(count);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public String getRosterFile() {
		return rosterFile;
	}
	public void setRosterFile(String rosterFile) {
		this.rosterFile = rosterFile;
	}
	
	

}
