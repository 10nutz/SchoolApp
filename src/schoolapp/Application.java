package schoolapp;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class Application {
	private static Application single_instance = null;
	private List<User> userList = new ArrayList<>();
	public CoursesManager courses_aux;
	public User currentUser = null;
	
	static Application getInstance() {
		if(single_instance == null) {
			single_instance = new Application();
		}
		
		return single_instance;
	}
	
	private Application() {
		/*HardcodedDataManager dataManager = new HardcodedDataManager();
		Random r = new Random();
		var students = dataManager.dataSetOfStudent;
		var teachers = dataManager.dataSetOfTeacher;
		Student s = students[r.nextInt(students.length)];
		Teacher t = teachers[r.nextInt(teachers.length)];
		this.userList.add(new User(s.first_name,s.second_name,new StudentStrategy(s)));
		t = teachers[r.nextInt(teachers.length)];
		this.userList.add(new User(t.first_name,t.second_name,new TeacherStrategy(t)));
		s = students[r.nextInt(students.length)];
		this.userList.add(new User(s.first_name,s.second_name,new StudentStrategy(s)));
		t = teachers[r.nextInt(teachers.length)];
		this.userList.add(new User(t.first_name,t.second_name,new TeacherStrategy(t)));
		s = students[r.nextInt(students.length)];
		this.userList.add(new User(s.first_name,s.second_name,new StudentStrategy(s)));
		
		try {
			FileOutputStream fos = new FileOutputStream("users.xml");
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.setExceptionListener(new ExceptionListener() {
			public void exceptionThrown(Exception e) {
				System.out.println(e);
			}
			});
			encoder.writeObject(userList);
			encoder.close();
			fos.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}*/
		this.initUsers();
	}
	
	private void initUsers() {
		try(FileInputStream fis = new FileInputStream("users.xml")){
			XMLDecoder decoder = new XMLDecoder(fis);
			this.userList = (ArrayList<User>) decoder.readObject();
			decoder.close();
			fis.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}

	private void updateUserList() {
		try {
			FileOutputStream fos = new FileOutputStream("users.xml");
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.setExceptionListener(new ExceptionListener() {
				public void exceptionThrown(Exception e) {
					System.out.println(e);
				}
			});
			encoder.writeObject(userList);
			encoder.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void login(User user) throws Exception {
		Settings.initApplication();
		iDataLoader idt = Settings.dataLoaderHashMap.get(Settings.loadType);
		courses_aux = new CoursesManager(idt.createCoursesData());
		int index = userList.indexOf(user);
		if (index != -1) {
			Application.getInstance().currentUser = userList.get(index);
		}else
			throw new Exception("Username or password incorrect!");
	}

	public void register(String fn, String sn, String usn, String pass) throws Exception{
		int ok = 0;
		for(User u : userList){
			if(u.menuStrategy.getAccountHolderInformation().containsKey(fn)){
				ok = 1;
				throw new Exception("An account with this information already exists");
			}
		}
		if(ok == 0){
			Settings.initApplication();
			iDataLoader idt = Settings.dataLoaderHashMap.get(Settings.loadType);
			courses_aux = new CoursesManager(idt.createCoursesData());

			for(Course c: courses_aux.courses){
				if(c.teacher.first_name.compareTo(fn)==0 && c.teacher.second_name.compareTo(sn)==0&&ok!=1){
					User aux = new User(usn,pass, new TeacherStrategy(c.teacher));
					userList.add(aux);
					this.updateUserList();
					ok = 1;
					break;
				}else{
					for(Student s: c.students){
						if(s.first_name.compareTo(fn)==0 && s.second_name.compareTo(sn)==0&&ok!=1){
							User aux = new User(usn,pass, new StudentStrategy(s));
							userList.add(aux);
							this.updateUserList();
							ok = 1;
							break;
						}
					}
				}
			}
		}
		if(ok == 0){
			throw new Exception("This person is not assigned to any course");
		}
		this.initUsers();
	}
}
