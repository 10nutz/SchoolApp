package schoolapp;

public class ConsoleDisplay implements iDisplayManager {

	@Override
	public void displayStudents(Student[] students) {
		for (Student s : students) {
			System.out.print(s);
		}
	}

	@Override
	public void displayTeachers(Teacher[] teachers) {
		for (Teacher t : teachers) {
			System.out.println(t);
		}

	}

	@Override
	public void displayCourses(Course[] courses) {
		for (Course c : courses) {
			System.out.println(c);
		}

	}

}
