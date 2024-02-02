package edu.ilstu;
//by suhail Pradip Tailor
//UID 805254601
public class RegularPatient extends Patient {
	private String mainSymptoms;//declare variables
	String method="IV Fluids";
	public RegularPatient(int id, String fName,String lName, int age,String symptoms) {//overloaded constructor extending patient class
		super(id, fName, lName, age);//passes in variables to super class
		
		this.mainSymptoms=symptoms;
	}
	public String treat() {
        if(this.mainSymptoms.equalsIgnoreCase("hypertension")) {//sets the patients treatment method if symptom is hypertension
			method="ACE inhibitors";
		}
     else if(this.mainSymptoms.equalsIgnoreCase("coughing")||this.mainSymptoms.equalsIgnoreCase("runnynose")||this.mainSymptoms.equalsIgnoreCase("Stuffynose")) {//sets the patients treatment method if symptom is a respiratory tract infection
			method="Amoxicillin";
		}
		
		return method;
	}
	
	public String toString() {//Checks boolean and displays all data of patient to user
		this.setPcr(false);
		String out="Positive";
		if(this.getPcr()==false) {//checks the boolean 
		 out="Negative";}
		
		return	
	"ID ="+ getId() +"\n"+"Full Name=" + getfName() + " " + getlName() + "\n"+"Age= " + getAge()+"\n"+"Main Symptom= " + this.mainSymptoms +"\n"+ "Pcr Test Result=" + out+"\n"+"Treatment= " + treat()+"\n"+"\n" ;//displays data to user
	 
	}

}
