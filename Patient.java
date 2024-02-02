package edu.ilstu;
//by suhail Pradip Tailor
//UID 805254601

public abstract class Patient {//declaring variables
	private int id;
	private String fName;
	private String lName;
	private int age;
	private boolean pcr;
	
	
	public Patient(int id, String fName, String lName, int age) {//overloaded constructor
		this.id=id;
		this.fName=fName;
		this.lName=lName;
		this.age=age;
	}

	public int getId() {//gets patients id
		return id;
	}

	public void setId(int id) {//sets patients id
		this.id = id;
	}

	public String getfName() {//gets patients first name
		return fName;
	}

	public void setfName(String fName) {//sets patients first  name
		this.fName = fName;
	}

	public String getlName() {//gets patients second name
		return lName;
	}

	public void setlName(String lName) {//sets patients second name
		this.lName = lName;
	}

	public int getAge() {//gets patients age
		return age;
	}

	public void setAge(int age) {//sets patients age
		this.age = age;
	}

	public boolean getPcr() {//gets patients pcr 
		return pcr;
	}
	
	public void setPcr(boolean pcr) {//sets patients pcr 
		this.pcr = pcr;
	}
	public String treat() {
		return ("");
	}	
}
