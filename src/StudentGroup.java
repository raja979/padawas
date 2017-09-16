//package src;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	private LinkedList<Student> linkedList=new LinkedList<>();
	private LinkedList<Student> bdays=new LinkedList<>();
	//private Iterator<Student> iterator=linkedList.iterator();
	private Student[] temp;
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		//temp=new Student[linkedList.size()];
		System.out.println("size of LL is"+linkedList.size());
		linkedList.toArray(students);
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		linkedList.clear();
		for(Student s:students)
		{
			linkedList.add(s);
		}
		temp=new Student[students.length];
	}

	@Override
	public Student getStudent(int index) throws IllegalArgumentException {
		// Add your implementation here
		Student stud;
		try {
			stud=linkedList.get(index);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			throw new IllegalArgumentException();
		}
		
		return stud;
	}

	private int Check(Student student,int index)
	{
		if(student==null || index<0 || index>=linkedList.size())
			return 0;
		return 1;
	}
	
	private int Check(Student student) {
		if(student==null)
			return 0;
		else
			return 1;
	}
	private int Check(int index) {
		if(index<0 || index>=linkedList.size())
			return 0;
		else
			return 1;
	}
	@Override
	public void setStudent(Student student, int index) throws IllegalArgumentException {
		// Add your implementation here
		Student student2;
		try {
			linkedList.set(index, student);
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public void addFirst(Student student) throws IllegalArgumentException {
		// Add your implementation here

		if(student==null)
			throw new IllegalArgumentException();
		else
			linkedList.addFirst(student);
		//temp=new Student[linkedList.size()];
	}

	@Override
	public void addLast(Student student) throws IllegalArgumentException {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else
			linkedList.addLast(student);
	}

	@Override
	public void add(Student student, int index) throws IllegalArgumentException {
		// Add your implementation here
		if(Check(student, index)==1)
			linkedList.add(index, student);
		else
			throw new IllegalArgumentException();
	}

	@Override
	public void remove(int index) throws IllegalArgumentException {
		// Add your implementation here
		if(Check(index)==0)
			throw new IllegalArgumentException();
		else
			linkedList.remove(index);
	}

	@Override
	public void remove(Student student) throws IllegalArgumentException {
		// Add your implementation here
		if(Check(student)==0)
		{
			System.out.println("remove error entered");
			throw new IllegalArgumentException();
		}
			
		else
		{
			System.out.println("removed"+student.getFullName()+linkedList.remove(student));
		}
			
	}

	@Override
	public void removeFromIndex(int index) throws IllegalArgumentException {
		// Add your implementation here
		if(Check(index)==0)
			throw new IllegalArgumentException();
		else
		{
			for(int i=index;i<linkedList.size();i++)
				linkedList.remove(i);
		}
	}

	@Override
	public void removeFromElement(Student student) throws IllegalArgumentException {
		// Add your implementation here
		if(Check(student)==0)
			throw new IllegalArgumentException();
		else {
			int index=linkedList.indexOf(student);
			for(int i=index;i<linkedList.size();i++)
				linkedList.remove(i);
		}
	}

	@Override
	public void removeToIndex(int index) throws IllegalArgumentException {
		// Add your implementation here
		if(Check(index)==0)
			throw new IllegalArgumentException();
		else {
			//int index=linkedList.indexOf(student);
			for(int i=index;i>=0;i--)
				linkedList.remove(i);
		}
		
	}

	@Override
	public void removeToElement(Student student) throws IllegalArgumentException {
		// Add your implementation here
		if(Check(student)==0)
			throw new IllegalArgumentException();
		else {
			int index=linkedList.indexOf(student);
			for(int i=index;i>=0;i--)
				linkedList.remove(i);
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		Collections.sort(linkedList);
	}

	public LinkedList<Student> getbday(Date date)
	{
		bdays.clear();
		for (Student student : linkedList) {
			if(student.getBirthDate().compareTo(date)==0)
				bdays.add(student);
		}
		return bdays;
	}
	
	@Override
	public Student[] getByBirthDate(Date date) throws IllegalArgumentException {
		// Add your implementation here
		if(date==null)
			throw new IllegalArgumentException();
		LinkedList<Student> l=getbday(date);
	l.toArray(temp);
		return temp;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) throws IllegalArgumentException{
		// Add your implementation here
		LinkedList<Student> studs= new LinkedList<>();
		if(firstDate==null || lastDate==null)
			throw new IllegalArgumentException();
		else {
			studs.addAll(getbday(firstDate));
			
			for (Student student : linkedList) {
				if(student.getBirthDate().after(firstDate) && student.getBirthDate().before(lastDate))
					studs.add(student);
			}
			studs.addAll(getbday(lastDate));
		}
		studs.toArray(temp);
	return temp;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		//this was not clear, whether after days bdays are required or any bdays within timeframe of mentioned days is rrequired.
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		Calendar now=Calendar.getInstance();
		Calendar dob=Calendar.getInstance();
		dob.setTime(getStudent(indexOfStudent).getBirthDate());
		if (dob.after(now)) {
			  throw new IllegalArgumentException("Can't be born in the future");
			}
			int year1 = now.get(Calendar.YEAR);
			int year2 = dob.get(Calendar.YEAR);
			int age = year1 - year2;
			int month1 = now.get(Calendar.MONTH);
			int month2 = dob.get(Calendar.MONTH);
			if (month2 > month1) {
			  age--;
			} else if (month1 == month2) {
			  int day1 = now.get(Calendar.DAY_OF_MONTH);
			  int day2 = dob.get(Calendar.DAY_OF_MONTH);
			  if (day2 > day1) {
			    age--;
			  }
			}
				return age;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		bdays.clear();
		for (int i = 0; i < linkedList.size(); i++) {
			if(getCurrentAgeByDate(i)==age)
				bdays.add(getStudent(i));
		}
	bdays.toArray(temp);
		return temp;
		
	}
	
	public double findmaxavg()
	{
		double max=-1;
		for (Student student : linkedList) {
			if(max<student.getAvgMark())
				max=student.getAvgMark();
		}
		return max;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double max=findmaxavg();
		Iterator<Student> iterator=linkedList.iterator();
		for (Student student : linkedList) {
			if(max==student.getAvgMark())
				bdays.add(student);
		}
		bdays.toArray(temp);
		return temp;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		int index=0;
		if(Check(student)==0)
			throw new IllegalArgumentException();
		else
		index=linkedList.indexOf(student);
		return getStudent(++index);
	}
	
//	public class comparebyage implements Comparator<Student>
//	{
//		public int compare(Student arg0, Student arg1) {
//			// TODO Auto-generated method stub
//			if(arg0.getBirthDate().compareTo(arg1.getBirthDate())==0)
//				return -0;
//			else if(arg0.getBirthDate().compareTo(arg1.getBirthDate())<0)
//				return -1;
//			else
//			return 1;
//		}
//	}
}
