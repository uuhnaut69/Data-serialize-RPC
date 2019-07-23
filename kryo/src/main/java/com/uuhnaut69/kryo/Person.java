package com.uuhnaut69.kryo;

import java.sql.Date;

public class Person {

	private String name = "John Doe";
	private int age = 18;
	private Date birthDate = new Date(933191282821L);

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age, Date birthDate) {
		this.name = name;
		this.age = age;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", birthDate=" + birthDate + "]";
	}

}
