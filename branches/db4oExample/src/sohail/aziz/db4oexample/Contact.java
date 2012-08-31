package sohail.aziz.db4oexample;

public class Contact {
	private String name;
	private String number;
	int age;
	boolean member;

	public Contact() {
		// default constructor
		name = null;
		number = null;
		age = 0;
		member = false;

	}

	public Contact(String name, String number, int age, boolean member) {

		this.name = name;
		this.number = number;
		this.age = age;
		this.member = member;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {

		return name + "/" + number + "/" + Integer.toString(age) + "/"
				+ Boolean.toString(member);
	}

}