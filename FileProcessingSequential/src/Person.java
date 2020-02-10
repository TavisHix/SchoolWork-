public class Person {
	// attributes
	private int ID;
	private int age;
	private String name;
	private String occupation;

	// get and set methods
	public int getID() {
		return ID;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setID(int id) {
		ID = id;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
}
