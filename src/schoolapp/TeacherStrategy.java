package schoolapp;

import java.util.HashMap;

public class TeacherStrategy implements MenuStrategy{
	public Teacher tch;
	public TeacherStrategy() {}
	
	TeacherStrategy(Teacher t){
		this.tch = t;
	}
	@Override
	public UserAccountType getAccountType() {
		return UserAccountType.TEACHER;
	}

	@Override
	public HashMap<String, String> getAccountHolderInformation() {
		return new HashMap<>() {{put(tch.first_name,tch.second_name);}};
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
