package schoolapp;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Collections;

public class TestClass {	
	public static void main(String[] args) {
		DataManager dataManager = new DataManager();
		
		dataManager.gradeStudents();
		dataManager.manager.reportAllCourses();
		dataManager.manager.reportAllStudentsGrades();
		dataManager.manager.reportAllCourses();
		try {
			dataManager.manager.RemoveCourse(new Course("PLCP 1"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Dupa stergere:");
		dataManager.manager.reportAllCourses();
		
		dataManager.manager.reportAllStudentsGrades();
		
		try {
			dataManager.manager.EditCourse(new Course("Limba engleza"), new Course("Limba engleza II", "descriere", new Teacher("ANA", "MARIA"), dataManager.createRandomSetOfStudents()));
			dataManager.manager.reportAllCourses();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
