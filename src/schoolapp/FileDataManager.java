package schoolapp;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDataManager  implements iDataLoader {

	@Override
	public Student[] createStudentsData() {
		try(FileInputStream fis = new FileInputStream("students.xml")){
			XMLDecoder decoder = new XMLDecoder(fis);
			Student[] students = (Student[]) decoder.readObject();
			decoder.close();
			fis.close();
			return students;
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
			
		return new Student[0];
	}

	@Override
	public Teacher[] createTeacherData() {
		try(FileInputStream fis = new FileInputStream("teachers.xml")){
			XMLDecoder decoder = new XMLDecoder(fis);
			Teacher[] teachers = (Teacher[]) decoder.readObject();
			decoder.close();
			fis.close();
			return teachers;
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
			
		return new Teacher[0];
	}

	@Override
	public Course[] createCoursesData() {
		try(FileInputStream fis = new FileInputStream("courses.xml")){
			XMLDecoder decoder = new XMLDecoder(fis);
			Course[] courses = (Course[]) decoder.readObject();
			decoder.close();
			fis.close();
			return courses;
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
			
		return new Course[0];
	}

}
