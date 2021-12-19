package schoolapp;

import java.util.ArrayList;
import java.util.Scanner;

public class KeyboardDataManager implements iDataLoader {

	@Override
	public Student[] createStudentsData() {
		System.out.println("Keyboard Data Reader - STUDENTS");
		ArrayList<Student> stud_aux = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		String read_fn;
		String read_sn;
		System.out.println("Please enter the student: ");
		int ok = 1;
		int read_gr = 0;
		while(ok==1) {
			System.out.println("First Name:");
			read_fn = sc.next();
			System.out.println("Second Name:");
			read_sn = sc.next();
			System.out.println("Group:");
			read_gr = sc.nextInt();
			stud_aux.add(new Student(read_fn,read_sn,read_gr));
			System.out.println("Do you want to add a new student? (0.No  1.Yes)");
			ok = sc.nextInt();
		}
		sc.close();
		return (Student[]) stud_aux.toArray(new Student[stud_aux.size()]);
	}

	@Override
	public Teacher[] createTeacherData() {
		System.out.println("Keyboard Data Reader - TEACHERS");
		ArrayList<Teacher> teacher_aux = new ArrayList<Teacher>();
		Scanner sc = new Scanner(System.in);
		String read_fn;
		String read_sn;
		System.out.println("Please enter the teacher: ");
		int ok = 1;
		while(ok==1) {
			System.out.println("First Name:");
			read_fn = sc.next();
			System.out.println("Second Name:");
			read_sn = sc.next();
			teacher_aux.add(new Teacher(read_fn,read_sn));
			System.out.println("Do you want to add a new teacher? (0.No  1.Yes)");
			ok = sc.nextInt();
		}
		sc.close();
		return (Teacher[]) teacher_aux.toArray(new Teacher[teacher_aux.size()]);
	}

	@Override
	public Course[] createCoursesData() {
		System.out.println("Keyboard Data Reader - COURSES");
		ArrayList<Course> courses_aux = new ArrayList<Course>();
		Scanner sc = new Scanner(System.in);
		String read_name;
		String read_description;
		System.out.println("Please enter the course: ");
		int ok = 1;
		while(ok==1) {
			System.out.println("Name:");
			read_name = sc.next();
			System.out.println("Description:");
			read_description = sc.next();
			courses_aux.add(new Course(read_name,read_description));
			System.out.println("Do you want to add a new course? (0.No  1.Yes)");
			ok = sc.nextInt();
		}
		sc.close();
		return (Course[]) courses_aux.toArray(new Course[courses_aux.size()]);
	}

}
