package schoolapp;

public class ConsoleDisplay implements iDisplayManager {

	@Override
	public void displayStudents(Student[] students) {
		for (Student s :
            students) {
        System.out.println(s);
    }
	}

	@Override
	public void displayTeachers(Teacher[] teachers) {
		 System.out.println(teachers);
		
	}

	@Override
	public void displayCourses(Course[] courses) {
		 System.out.println(courses);
		
	}

}
