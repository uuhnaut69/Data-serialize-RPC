package com.uuhnaut69.protobuf.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uuhnaut69.protobuf.Example.Course;
import com.uuhnaut69.protobuf.Repository.CourseRepository;

@RestController
public class CourseController {

	@Autowired
	private CourseRepository courseRepo;

	@RequestMapping("/courses/{id}")
	public Course customer(@PathVariable Integer id) {
		return courseRepo.getCourse(id);
	}

}
