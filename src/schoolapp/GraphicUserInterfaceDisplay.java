package schoolapp;

import javax.swing.*;
import java.awt.*;

public class GraphicUserInterfaceDisplay implements iDisplayManager{

	@Override
	public void displayStudents(Student[] students) {
		JTextArea studentsTextArea = new JTextArea();
		for(Student s: students) {
			studentsTextArea.add(new Label());
		}
	}

	@Override
	public void displayTeachers(Teacher[] teachers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayCourses(Course[] courses) {
		// TODO Auto-generated method stub
		
	}

}
