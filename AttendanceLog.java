//Pranav Civi
//UIN: 431005071
package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class AttendanceLog {
	
	//getters, setters, constructors, compareTo, toString
	
	
	private int count;
	private ArrayList<Log> logList;
	private String fileName;
	
	AttendanceLog(){
		count = 0;
		logList = new ArrayList<Log>();
		fileName = "";
	}
	
	AttendanceLog(String s){
		count = 0;
		logList = new ArrayList<Log>();
		fileName = s;
	}
	
	public int getCount() {
		return count;
	}
	public ArrayList<Log> getLogList(){
		return logList;
	}
	public String getFileName() {
		return fileName;
	}
	
	public void setCount(int n) {
		this.count = n;
	}
	public void incCount() {
		this.count += 1;
	}
	public void setLogList(ArrayList<Log> list) {
		logList = list;
	}
	public void setFileName(String s) {
		fileName = s;
	}
	
	public int compareTo(AttendanceLog other) {
		//return -1 if this < other
		//return 0 if this == other
		//return 1 if this > other
		if(this.count < other.count)
			return -1;
		else if(this.count > other.count)
			return 1;
		return 0;
	}
	
	public String toString() {
		String out = "";
		for(int i = 0; i < this.count; i++) {
			out += this.logList.get(i).toString();
			out += "\n";
		}
		return out;
	}
	
	
	public void load_log() {
		Scanner sc = null;
		File file = new File(fileName);
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < count; i++) {
			sc.nextLine();
		}
		Log testLog = new Log(sc.next(), sc.next(), sc.next(), sc.next());
		logList.add(testLog);
		this.count++;
		sc.close();
	}
	
	public void load_all_logs() {
		this.count = 0;
		Scanner sc = null;
		File file = new File(fileName);
		try {sc = new Scanner(file);}
		catch(FileNotFoundException e) { e.printStackTrace();}
		
		while(sc.hasNext()) {
			Log testLog = new Log(sc.next(), sc.next(), sc.next(), sc.next());
			logList.add(testLog);
			this.count++;
		}
		sc.close();
	}
	
//	public void print_collection() {
//		System.out.println("** This is the entire Collection Data currently stored **");
//		for(int i = 0; i < logList.size(); i++) {
//			System.out.println(logList.get(i).toString());
//		}
//	}
	public String print_collection() {
		String output = "";
		output += ("** This is the entire Collection Data currently stored **") + "\n";
		for(int i = 0; i < logList.size(); i++) {
			output += (logList.get(i).toString()) + "\n";
		}
		
		return output;
	}
	
	public void print_count() {
		System.out.println(count);
	}
	
	public boolean equals(AttendanceLog other) {
		return this.count == other.getCount() && this.logList.equals(other.logList) && this.getFileName().equals(other.getFileName());
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	

	
	
//	Scanner sc = null;
//	File file = new File("dataAllShow1stClass.txt");
//	try {
//		sc = new Scanner(file);
//	} catch (FileNotFoundException e) {
//		e.printStackTrace();
//	}
//	
//	//make this into a while loop that goes through the entire file
//	Log testLog = new Log(sc.next(), sc.next(), sc.next(), sc.next());

}
