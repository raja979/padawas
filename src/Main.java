//package src;

import java.util.Date;

public class Main {

	static void print(Student []temp1) {
		for (int i=0;i<temp1.length;i++) {
			if(temp1[i]!=null)
			System.out.println(temp1[i].getFullName());
			else
				break;
		}
	}
	
	public static void main(String[] args) {
		
//		//You may test that your code works find here
//		//Please check that your code works and has no 
//		//compilation problems before to submit
		String string="hello";
		@SuppressWarnings("deprecation")
		Date d1=new Date(2017, 11, 11);
		Student s1=new Student(1, "hello", d1, 43.0);
		Student s2=new Student(2, "anoop", d1, 94.0);
		Student s3=new Student(3, "amar", d1, 48.0);
		Student s4=new Student(4, "show", d1, 94.0);
		Student s5=new Student(5, "ritesh", d1, 42.0);
		Student s6=new Student(6, "suppu", d1, 42.0);
		Student s7=new Student(1, "chikant", d1, 2.0);
		StudentGroup studentGroup=new StudentGroup(5);
		Student col[]= {s1,s2,s3,s4,s5};
		Student temp=null;Student temp1[];
		try {
			studentGroup.setStudents(col);
		System.out.println("before removing");
		temp1=studentGroup.getStudents();
		System.out.println("temp1 size="+temp1.length);
		for (Student student : temp1) {
			System.out.println(student.getFullName());
		}
//		
//		
//		
		studentGroup.bubbleSort();
		System.out.println("removing"+s3.getFullName());
		studentGroup.remove(s3);
		temp1=studentGroup.getStudents();
		for (int i=0;i<temp1.length;i++) {
			if(temp1[i]!=null)
			System.out.println(temp1[i].getFullName());
			else
				break;
		}
		System.out.println("removing"+s2.getFullName());
		studentGroup.remove(s2);
		temp1=studentGroup.getStudents();
		for (int i=0;i<temp1.length;i++) {
			if(temp1[i]!=null)
			System.out.println(temp1[i].getFullName());
			else
				break;
		}
		studentGroup.remove(s1);
		System.out.println("temp1 size="+temp1.length);
		System.out.println(studentGroup.getStudent(0).getFullName());
		temp1=studentGroup.getStudentsWithMaxAvgMark();
//		
		System.out.println("this is complete shit 2 after removing");
		temp1=studentGroup.getStudents();
//		
//		
			temp1=studentGroup.getStudents();
			for (Student student : temp1) {
				System.out.println(student.getFullName());
			}
			studentGroup.addLast(s7);
//		
//		
//		//DATE CHECKING BEGINS FROM HERE
		temp1=studentGroup.getByBirthDate(new Date(2017,11,11));
		System.out.println("getting b BDAY");
		print(temp1);
//		//GETTING BY AGE LOL
		temp1=studentGroup.getBetweenBirthDates(new Date(2016,1,1), new Date(2018,1,1));
		System.out.println("getting bw BDAY");	
			print(temp1);
//		//GETTING NEXT STUDENT
			temp=studentGroup.getNextStudent(s1);
			System.out.println("next student"+temp.getFullName());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("chill out theres some exception thrown");
		}

		
		
	}

}
