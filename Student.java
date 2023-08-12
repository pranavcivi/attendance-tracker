//Pranav Civi
//UIN: 431005071
package application;

public class Student {
	
	private String lastName;
	private String firstName;
	
	Student(){
		lastName = "";
		firstName = "";
	}
	
	Student(String l, String f){
		if(l.charAt(l.length()-1) == ',')
			lastName = l.substring(0, l.length()-1);
		else
			lastName = l;
		
		if(f.charAt(f.length()-1) == ',')
			firstName = f.substring(0, f.length()-1);
		else
			firstName = f;
	}
	
	//access methods
	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	
	//mutators
	public void setLastName(String s) {
		lastName = s;
	}
	
	public void setFirstName(String s) {
		firstName = s;
	}
	
	//operators
	public boolean equals(Student other) {
//		return (this.lastName == other.lastName && this.firstName == other.firstName);
		return this.lastName.equals(other.lastName) && this.firstName.equals(other.firstName);
	}
	public int compareTo(Student o) {
		if(this.lastName.compareTo(o.lastName) != 0) {
			return this.lastName.compareTo(o.lastName);
		}
		else if(this.firstName.compareTo(o.firstName) != 0) {
			return this.firstName.compareTo(o.firstName);
		}
		return 0;
	}
	
	//toString
	public String toString() {
		return lastName + ", " + firstName;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	

}
