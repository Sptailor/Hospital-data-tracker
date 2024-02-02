package edu.ilstu;
//by suhail Pradip Tailor
//UID 805254601

public class Covid19Patient extends Patient {
private double temp;//declare variables
String method ="fluids and Tylenol";

	public Covid19Patient(int id, String fName, String lName, int age,double temp) {//overloaded constructor extending patient class
		super(id, fName, lName, age); //passes in variables to super class
		this.temp=temp;
		
	}
	public double getTemp() {//returns the patients temperature
		return temp;
	}
	public void setTemp(double temp) {//sets the patients temperature
		this.temp = temp;
	}
	public String treat() {
        if(this.getTemp()>41) {
			method="Dexamethasone";
		}
     else if(this.getAge()>67&&this.getTemp()>38.5) {//sets the patients treatment method if age is above 64 and has high temperature
			method="Remdesivir";
		}
     else if(this.getAge()>67&&this.getTemp()<41) {//sets the patients treatment method if age is above 64 and has low temperature
			method="fluids and Tylenol";
		}
		
		return method;
	}
	

	public String toString() { //Checks boolean and displays all data of patient to user
		this.setPcr(true);
		String out="Negative";
		if(this.getPcr()==true) {//checks the boolean 
		 out="Positive";}
		
		return 		
    "ID ="+ this.getId() +"\n"+
	"Full Name=" + getfName() + " " + this.getlName() + "\n"+
	"Age= " + this.getAge()+"\n"+
	"Temp= " + this.getTemp() +"\n"+
    "Pcr Test Result=" + out+"\n"+
	"Treatment= " + this.treat()
	+"\n"+"\n";//displays data to user
	 
	}
}
