package schoolapp;


public class Teacher {
	public String first_name;
	public String second_name;
	
	public Teacher() {}
	
	public Teacher(String first_name, String second_name) {
		this.first_name = first_name;
		this.second_name = second_name;
	}
	
	public String formatForDisplay() {
		return this.first_name + " " + this.second_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Teacher other = (Teacher) obj;
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
	public String toString() {
		return "Teacher first_name:" + first_name + ", second_name:" + second_name;
	}
}
