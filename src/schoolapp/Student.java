package schoolapp;

import schoolapp.Student;

public class Student implements  java.lang.Comparable<Student>{
	String first_name;
	String second_name;
	int group;
	
	Student(String f_n, String s_n, int gr) {
		this.first_name = f_n;
		this.second_name = s_n;
		this.group = gr;
	}
	
	
	@Override
	public String toString() {
		return "\nStudent first name: " + first_name + ", second name:" + second_name + ", group:" + group;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + group;
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((second_name == null) ? 0 : second_name.hashCode());
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
		Student other = (Student) obj;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (second_name == null) {
			if (other.second_name != null)
				return false;
		} else if (!second_name.equals(other.second_name))
			return false;
		return true;
	}


	@Override
	public int compareTo(Student o) {
		//Student student = (Student) o;
		if(this.first_name.compareToIgnoreCase(o.first_name) < 0) {
			return -1;
		}else { 
			if(this.first_name.compareToIgnoreCase(o.first_name) == 0) {
				if(this.second_name.compareToIgnoreCase(o.second_name) < 0)	{
					return -1;
				}else {
					return 0;}
			}else
				if(this.second_name.compareToIgnoreCase(o.second_name) > 0) {
					return 1;
		}
		}
		return 0;
	}
}
