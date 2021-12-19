package schoolapp;

import java.util.Objects;

enum UserAccountType{
	STUDENT, TEACHER
}

public class User {
	public String userName;
	public String password;
	public MenuStrategy menuStrategy;
	
	public User() {}
	public User(String userName, String password, MenuStrategy accountType) {
		this.userName = userName;
		this.password = password;
		this.menuStrategy = accountType;
	}
	public User(String username, String password) {
		this.userName = username;
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if (!(o instanceof User)) return false;
		User user = (User) o;
		return Objects.equals(userName, user.userName) && Objects.equals(password, user.password);
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
}
