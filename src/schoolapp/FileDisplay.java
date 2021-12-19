package schoolapp;

import java.beans.ExceptionListener;
import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDisplay implements iDisplayManager{

	@Override
	public void displayStudents(Student[] students) {
		try {
			FileOutputStream fos = new FileOutputStream("students.xml");
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.setExceptionListener(new ExceptionListener() {
			public void exceptionThrown(Exception e) {
				System.out.println(e);
			}
			});
			encoder.writeObject(students);
			encoder.close();
			fos.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void displayTeachers(Teacher[] teachers) {
		try {
			FileOutputStream fos = new FileOutputStream("teachers.xml");
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.setExceptionListener(new ExceptionListener() {
			public void exceptionThrown(Exception e) {
				System.out.println(e);
			}
			});
			encoder.writeObject(teachers);
			encoder.close();
			fos.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void displayCourses(Course[] courses) {
		try {
			FileOutputStream fos = new FileOutputStream("courses.xml");
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.setExceptionListener(new ExceptionListener() {
			public void exceptionThrown(Exception e) {
				System.out.println(e);
			}
			});
			encoder.writeObject(courses);
			encoder.close();
			fos.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
