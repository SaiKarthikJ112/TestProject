package StudentManagementSystem;
public class Student {
private String sname;
private int rollNo;
private char grade;

public Student(String sname,int rollNo,char grade) {
	this.sname=sname;
	this.rollNo=rollNo;
	this.grade=grade;
}

public String getSName() {
	return this.sname;
}
public void setSName(String sname) {
	this.sname=sname;
}
public int getRollNo() {
	return this.rollNo;
}
public void setRollNo(int rollNo) {
	this.rollNo=rollNo;
}
public char getGrade() {
	return this.grade;
}
public void setGrade(char grade) {
	this.grade=grade;
}
}
