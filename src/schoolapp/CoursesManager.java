package schoolapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoursesManager {
	List<Course> courses;

    public CoursesManager(Course[] courses_aux) {
		this.courses = Arrays.asList(courses_aux);
    }

    private Course search(Course aCourse) throws Exception {
		int i = courses.indexOf(aCourse);
		if ( i != -1 ) {
			return courses.get(i);
		}
		else {
			throw new Exception("The course " + aCourse + " cannot be found in the school curriculum.");
		}
	}
	
	public CoursesManager() {
		this.courses = new ArrayList<Course>();
	}
	
	public void AddCourse(Course c) {
		this.courses.add(c);
	}
	
	public void RemoveCourse(Course c) throws Exception {
		if (!this.courses.remove(c)) {
			throw new Exception("The course " + c + " cannot be deleted because it was not found in the school curriculum.");
		}
	}
	
	public void EditCourse(Course c, Course newCourse) throws Exception {
		// Searching the course
		int i = courses.indexOf(c);
		// verifying
		if ( i != -1) {
			courses.set(i, newCourse);
		} else {
			throw new Exception("The course " + c + " cannot be found in the school curriculum.");
		}
	}
	
	public void reportStudentsOf(Course aCourse) throws Exception {
		Course c = this.search(aCourse);
		c.reportStudents();
	}
	
	public void reportAllCourses() {
		for( Course c: courses) {
			System.out.println( c.name + " " + c.description);
			try {
				//this.reportStudentsOf(c);
			} catch (Exception e) {

			}
		}
	}
	
	public void reportAllStudentsGrades() {
		for( Course c: courses) {
			c.SeeCourseName();
			for ( Student s: c.students) {
				String gradeAsString = c.grades.get(s) != null ? c.grades.get(s).toString() : " no grade";
				System.out.println( s.first_name + " " + s.second_name + " are nota: " + gradeAsString);
			}
		}
	}
	
	public void reportGradesOf(Course aCourse) throws Exception {
		Course c = this.search(aCourse);
		System.out.println("The students averade grade at the course " + c.name + " is:" + c.AverageGrades());	
	}
	
	public void reportAverageGradesOf(Teacher tch) {
		float sum = 0;
		int count = 0;
		for( Course c : courses) {
			if ( c.teacher == tch ) {
				sum += c.AverageGrades();
				count += 1;
			}
		}
		float average = count == 0 ? 0 : sum / (float)count; 
		System.out.println("The average grade given by the teacher: " + tch.formatForDisplay() + " is: " + average );
	}

	public void reportAllTeacherCourses(Teacher tch){
		for( Course c : courses) {
			if (c.teacher == tch){
				c.SeeCourseName();
			}
		}
	}
	
}
