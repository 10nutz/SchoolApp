package schoolapp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Course {
	public String name;
	public String description;
	public int year;
	public Teacher teacher;
	public Set<Student> students;
	public HashMap<Student, Integer> grades;

	public Course() {}
	public Course(String name, String descr, Teacher tch, Set<Student> stud) {
		this.name = name;
		this.description = descr;
		this.teacher = tch;
		this.students = stud;
		this.grades = new HashMap<Student, Integer>();
	}

	public Course(String name, String descr, int year, Teacher tch, Set<Student> stud) {
		this.name = name;
		this.description = descr;
		this.year = year;
		this.teacher = tch;
		this.students = stud;
		this.grades = new HashMap<Student, Integer>();
	}

	public Course(String nume) {
		this.name = nume;
		this.students = new HashSet<Student>();
	}
	
	public Course(String name, String description) {
		this.name = name;
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public void TeacherUpdate(Teacher tch) {
		this.teacher = tch;
	}

	public void AddStudent(Student student) {
		this.students.add(student);
	}

	public void DeleteStudent(Student student) throws Exception {
		// Verifying if a student is enrolled at a course
		if (!this.students.remove(student)) {
			throw new Exception("The " + student + " is not enrolled at this course.");
		}
		this.grades.remove(student);
	}

	public void EditStudent(Student student, Student newstudent) {
		// Deleting the old student
		if( this.students.remove(student)) {
			// Adding the new student
			this.students.add(newstudent);
		} 
		// Deleting the grade for the old student and adding the same one for the new student
		if ( this.grades.get(student) != null) {
			Integer StudentGrade = this.grades.get(student);
			this.grades.remove(student);
			this.grades.put(newstudent, StudentGrade);
		}
	}

	@Override
	public String toString() {
		String str = "\nCourse: " + "name:" + name + ", description:" + description + ",\n" + teacher + ",\n\tStudents:";
		for (Student s : students) {
			Integer StudentGrade = grades.get(s) != null ? grades.get(s) : 0; 
			str += s + " " +  StudentGrade ;
		}
		return str;
	}

	public void reportStudents() {
		String str = "";
		for (Student s : students) {
			str += s + " " +  grades.get(s);
		}
		System.out.println(str);
	}

	public void GradeStudent(Student s, int StudentGrade) throws Exception {
		if ( this.students.contains(s)) {
			this.grades.put(s, StudentGrade);
		} else {
			throw new Exception("The student " + s + " cannot be graded.");
		}
	}

	public void SeeCourseName() {
		System.out.println(this.name + ":");
	}

	public float AverageGrades() {
		return (float) grades.values().stream().mapToInt(a -> a).average().orElse(0);
	}

}