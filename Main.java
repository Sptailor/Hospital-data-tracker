package edu.ilstu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//by suhail Pradip Tailor
//UID 805254601



public class Main {
	

	public static void main(String[] args) {
		
	
		System.out.println("Welcome");
		ArrayList<Patient>patients=new ArrayList<Patient>();//creates the arraylist
		int selection=0;//initialize variables
		 int id;
	     String fName;
		 String lName;
		 int age=0;
		 boolean pcr=false;
		 double temp=0;
		 String symptoms="";
		 Patient p1=null;//creates Patient object p1
		Scanner scan=new Scanner(System.in);//creates scanner object
		
		while(selection!=6) {//loop runs while user selection is not 6
			System.out.println();
			System.out.println("Please enter a selection"+"\n"+"1. Admit Patient"+"\n"+"2. Print Patient information"+"\n"+"3. Submit PCR Test Result"+"\n"+"4. Do Rounds"+"\n"+"5. Discharge Patient"+"\n"+"6. Exit");//list is displayed to user
			selection=scan.nextInt();//reads input
			if(selection==1) {//runs is one is selected
				try {//user is prompted to enter details of patient
				System.out.println("Please Enter the following\nPCR Test Result(Positive/Negative): ");
				String choice =scan.next();//reads pcr result
				System.out.println("Patient ID: ");
				id=scan.nextInt();//reads patient id
				System.out.println("Patient First Name: ");
				fName=scan.next();//reads patient name
				System.out.println("Patient Last Name: ");
				lName=scan.next();//reads name
				System.out.println("Patient Age: ");
				age=scan.nextInt();//reads age input
				if(choice.equalsIgnoreCase("Positive")) {//checks pcr test input and decides whether patient is regular or Covid 19 patient
				
				System.out.println("Enter Temperature");//asks for temperature
				temp=scan.nextDouble();//reads input
					 p1=new Covid19Patient(id,fName, lName, age, temp );//creates covid 19 patient
					
					 patients.add(p1);//places object into the patients array
					 
					 
				}else if(choice.equalsIgnoreCase("Negative")) {
					System.out.println("Enter Symtoms(coughing, runnynose, or stuffynose)");
					symptoms=scan.next();//reads input

					 p1=new RegularPatient(id,fName, lName, age,symptoms );//creates regular patient object
					
                     patients.add(p1);//adds object into patients array
                     
				}
				else {
					System.out.println("input invalid");//if input doesnt match
				}
				}catch(InputMismatchException x) {//catches error and handles it
					System.out.println("input invalid");
					selection=6;
				}
					
				
				
			}else if(selection==2) {//calls method and executes it.
				System.out.println(patients);//prints out all objects with details
				
			}
			else if(selection==3) {//runs if 3 is selected
				System.out.println("Enter patient ID: ");//prompts user
				int num=(scan.nextInt()-1);//reads input to find patient
				System.out.println("Enter PCR Result: ");//asks for data
				String in=scan.next();//reads data
				if(in.equalsIgnoreCase("positive"))//checks the data to determine boolean
				{pcr=true;}//if positive
				else {
					pcr=false;//if negative
				}
				//code below copies previous data and combines with new data to update object in array
				id=num;
				fName=patients.get(num).getfName();
				lName=patients.get(num).getlName();
				age=patients.get(num).getAge();
				if(pcr==true) {//if patient has covid
					
					System.out.println("Enter Temperature");//asks for data
					temp=scan.nextDouble();//takes in data
						 p1=new Covid19Patient(id,fName, lName, age, temp );//creates new updated object
						
						 patients.set(num, p1);//places object into array
						 
					}else if(pcr==false) {//if patient doesn't have covid
						patients.remove(num);//removes object from array
						System.out.println("Patient Discharged");//alerts user
					}
				
			
			 
				
			}
		else if(selection==4) {//runs if 4 is selected
			for(Patient c:patients) {//loops through each patient
				 if(c instanceof Covid19Patient ) {//checks if patient is covid19patient
				System.out.println("Enter temperature for "+c.getfName()+" "+c.getlName()+": ");//prompts user
				double temperature=scan.nextDouble();//takes in data
				((Covid19Patient)c).setTemp(temperature);//passes data to set temperature
				((Covid19Patient)c).treat();//calls treat method 
				
				System.out.println(c.getfName()+" "+c.getlName()+"\n"+"Treatment: "+c.treat());//displays information to user
				
			}
				 }
			
			}
		else if(selection==5) {//runs if 5 is selected
			System.out.println("please enter Patient id: ");//prompts user
			int in=scan.nextInt();//reads data
		   System.out.println("Enter PCR result: ");//promts user
		   String line=scan.next();//reads data
		   if(line.equalsIgnoreCase("positive")) {//checks if pcr requirements are met
			   pcr=true;
		   }
		   else pcr=false;
			if(pcr==false) {//checks pcr boolean status
				patients.remove((in-1));//removes patient from the array 
				System.out.println("Patient Discharged");//alerts user
				patients.trimToSize();//reduces size of array
			}
			

		}
			
		else if(selection<0||selection>6) {//displays if user selection  is out of range
				System.out.println("invalid input\ninput has to be between 1 and 5");//displays if input is invalid

			}
			
		}
		
		System.out.println("___Program Ended___");//alerts user
		
		
		
	
	
	
	}

}
