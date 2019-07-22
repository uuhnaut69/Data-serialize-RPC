package com.uuhnaut69.protobuf.Repository;

import java.util.Map;

import com.uuhnaut69.protobuf.Example.Course;

public class CourseRepository {

	private final Map<Integer, Course> courses;

	public CourseRepository(Map<Integer, Course> courses) {
		this.courses = courses;
	}

	public Course getCourse(int id) {
		return courses.get(id);
	}

}
