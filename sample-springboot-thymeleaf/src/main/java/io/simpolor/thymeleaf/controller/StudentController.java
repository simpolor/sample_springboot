package io.simpolor.thymeleaf.controller;

import io.simpolor.thymeleaf.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/student")
@RestController
public class StudentController {

	@RequestMapping(value="/totalcount", method=RequestMethod.GET)
	public int studentTotalCount() {
		return 84;
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Student> studentList() {

		List<Student> students = new ArrayList<>();
		students.add(new Student(1L, "단순색", 1, 17, Arrays.asList("축구")));
		students.add(new Student(2L, "김영희", 2, 18, Arrays.asList("영화", "프로그래밍")));

		return students;
	}

	@RequestMapping(value="/{seq}", method=RequestMethod.GET)
	public Student studentView(@PathVariable long seq) {
		return  new Student(seq, "단순색", 1, 17, Arrays.asList("축구"));
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public Student studentRegister(@RequestBody Student student) {
		student.setSeq(1);
		return student;
	}

	@RequestMapping(value="/{seq}", method=RequestMethod.PUT)
	public Student studentModify(@PathVariable int seq, @RequestBody Student student) {
		student.setSeq(seq);
		return student;
	}

	@RequestMapping(value="/{seq}", method=RequestMethod.DELETE)
	public long studentDelete(@PathVariable long seq) {
		return seq;

	}


}
