package schoolapp;

import java.util.HashMap;

public class StudentStrategy implements MenuStrategy {
	public Student student;
	public StudentStrategy() {}
	StudentStrategy(Student student) {this.student = student;}
	@Override
	public UserAccountType getAccountType() {
		return UserAccountType.STUDENT;
	}

	@Override
	public HashMap<String, String> getAccountHolderInformation() {
		return new HashMap<>() {{put(student.first_name,student.second_name);}};
	}

	@Override
	public String[] getAccountMenuOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void nextMenuOption() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void previousMenuOption() {
		// TODO Auto-generated method stub
		
	}

}
