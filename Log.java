//Pranav Civi
//UIN: 431005071
package application;

public class Log {
	
	private String lastName;
	private String firstName;
	private String time;
	private String date;
	
	Log(){
		lastName = "";
		firstName = "";
		time = "";
		date = "";
	}
	
	Log(String lN, String fN, String t, String d){
		if(lN.charAt(lN.length()-1) == ',') {
			lastName = lN.substring(0, lN.length()-1);
		}
		else lastName = lN;
		
		if(fN.charAt(fN.length()-1) == ',') {
			firstName = fN.substring(0, fN.length()-1);
		}
		else firstName = lN;
		
		if(t.charAt(t.length()-1) == ',') {
			time = t.substring(0, t.length()-1);
		}
		else time = t;
		
		if(d.charAt(d.length()-1) == ',') {
			date = d.substring(0, d.length()-1);
		}
		else date = d;
	}
	
	//access methods
	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getDate() {
		return date;
	}
	
	//mutators
	public void setLastName(String ln) {
		lastName = ln;
	}
	
	public void setFirstName(String fn) {
		firstName = fn;
	}
	
	public void setTime(String t) {
		time = t;
	}
	
	public void setDate(String d) {
		date = d;
	}
	
	//operators - compareTo, equals
	public boolean equals(Log otherLog) {
		return (this.firstName == otherLog.firstName && this.lastName == otherLog.lastName && this.time == otherLog.time && this.date == otherLog.date);
	}
	
	//compareTo
	public int compareTo(Log o) {
		if(this.getLastName().compareTo(o.getLastName()) != 0)
			return this.getLastName().compareTo(o.getLastName());
		if(this.getFirstName().compareTo(o.getFirstName()) != 0)
			return this.getFirstName().compareTo(o.getFirstName());
		if(this.getTime().compareTo(o.getTime()) != 0)
			return this.getTime().compareTo(o.getTime());
		if(this.getDate().compareTo(o.getDate()) != 0)
			return this.getDate().compareTo(o.getDate());
		
		return 0;
	}
	
	//toString
	public String toString() {
		return this.getLastName() + ", " + this.getFirstName() + ", " + this.getTime() + ", " + this.getDate();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	
	

}
