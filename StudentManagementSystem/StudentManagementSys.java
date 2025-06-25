package StudentManagementSystem;
import java.util.ArrayList;
class StudentManagementSys {
	 ArrayList<Student> students=new ArrayList<>();
	 public void addStudent(String name,int rollNo,char grade) {
		students.add(new Student(name,rollNo,grade));
	 }
	 public void studDetails() {
		 for(Student s:students) {
			 System.out.println("STUDENT{rollNumber="+s.getRollNo()+", name='"+s.getSName()+"', grade='"+s.getGrade()+"'}");
		 }
	 }
	 public void searchStudent(int rollNo) {
		 boolean found=false;
		 for(Student s:students) {
			 if(s.getRollNo()==rollNo) {
				 found=true;
		     System.out.println("STUDENT{rollNumber="+s.getRollNo()+", name='"+s.getSName()+"', grade='"+s.getGrade()+"'}");
			 break;
			 }
		 }
		 if (!found) {
		        System.out.println("[ERROR] Student with roll number " + rollNo + " not found.");
		    }
	 }
	 
	 public void removeStudent(int rollNo) {
		    boolean removed = false;
		    for (int i = 0; i < students.size(); i++) {
		        if (students.get(i).getRollNo() == rollNo) {
		            students.remove(i);
		            removed = true;
		            System.out.println("[SUCCESS] Student removed successfully.");
		            break;
		        }
		    }
		    if (!removed) {
		        System.out.println("[ERROR] Student with roll number " + rollNo + " not found.");
		    }
		}
}
