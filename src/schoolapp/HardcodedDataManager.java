package schoolapp;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HardcodedDataManager implements iDataLoader {
	public CoursesManager manager = new CoursesManager();
	public Random rand = new Random();
	public int minimumRequiredStudents = 5;
	public Student[] dataSetOfStudent = createStudentsData();
	public Teacher[] dataSetOfTeacher = createTeacherData();
	
	public HardcodedDataManager() {
		this.createCoursesData();
	}
	
	public Student[] createStudentsData() {
		String first_name[] = { "Jarcau", "Oprea", "Solomon", "Patrascu", "Damian", "Cristea", "Visoiu", "Andrei", "Petreanu", "Dragomir", "Gavrila",	"Suciu", "Rotaru", "Grigorescu", "Dudulescu", "Stanculescu"
				, "Vajaiac", "Istudor",	"Bruma", "Neagu", "Popa", "Gribincea", "Cucu", "Milea",	"Coca",	"Iorga", "Budau", "Maracineanu", "Pascociu", "Ionita",	"Paltanea"
				, "Spunei", "Stoian", "Raulea",	"Trifan", "Visan", "Rusu", "Silitra", "Puia" };
		String second_name[] = { "Stefan", "Ionut", "Andrei" ,"Nicolae","Maria","Florinela","Andrei","Mihai","Marius","Sergiu","Iulian","Mihai","Daria","Stefan","Stefan","Daniel","Marius"
				,"Cristian","Daniel","Elena","Ana-Maria","Valentina","Ioana","Daniel","Paul","Bianca","David","Constantin","Andreea","Cezar","Auras","Razvan","Emanuel","Andrei","Ioan","Marian","Victor","Florin","Madalina"};
		
		Student students[] = new Student[first_name.length];
		for (int i = 0; i < first_name.length;i++) {
			Student s = new Student(first_name[i], second_name[i], 1 + rand.nextInt(4));
			students[i] = s;
		}
		return students;
	}
	
	public Teacher[] createTeacherData() {
		String first_name[] = { "URSUTIU", "PANA", "ALEXANDRU","CRETU ", "KRISTALY", "DANILA", "DEMETER",	"DIACONU", "ILEA", "POP", "BOER" };
		String second_name[] = {"DORU","GHEORGHE", "MARIAN","NICOLAE CONSTANTIN", "DOMINIC", "ADRIAN", "ROBERT", "LAURENTIU", "GELU","MIHAIL", "ATTILA"};
		Teacher tch[] = new Teacher[first_name.length];
		for (int i = 0; i < first_name.length;i++) {
			tch[i] = new Teacher(first_name[i], second_name[i]);
		}
		return tch;
	}
	
	public Set<Student> createRandomSetOfStudents() {
		int studentsenrolled = minimumRequiredStudents + rand.nextInt(dataSetOfStudent.length - minimumRequiredStudents);
		Set<Student> setOfStudents = new HashSet<Student>();
		for (int i = 0; i < studentsenrolled; i++) {
			int randomStudentIndex = rand.nextInt(dataSetOfStudent.length);
			setOfStudents.add(dataSetOfStudent[randomStudentIndex]);
		}
		return setOfStudents;
	}
	
	public Course[] createCoursesData() {
		String course[] = { "Teoria sistemelor", "Masurari electronice", "Dispozitive electronice", "Structuri de date", "Procesarea semnalelor", "Limba engleza", "Limbaje formale", "PCLP 1", "PCLP 2" };
		String description = "course description";
		ArrayList<Course> courses = new ArrayList<>();
		for (String CourseName : course) {
			int yr = 1 + rand.nextInt(4);
			Set<Student> studentsData = createRandomSetOfStudents();
			Teacher tch = dataSetOfTeacher[rand.nextInt(dataSetOfTeacher.length)];
			Course c = new Course(CourseName, description, yr, tch, studentsData);
			courses.add(c);
		}
		return courses.toArray(new Course[courses.size()]);
	}
	
	public void gradeStudents() {
		for (Course c: manager.courses) {
			for( Student s: c.students) {
				try {
					c.GradeStudent(s, 1 + rand.nextInt(10));
				} catch (Exception e) {

				}
			}
		}
	}

}
