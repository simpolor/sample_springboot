package io.simpolor.redis.controller;

import io.simpolor.redis.domain.Student;
import io.simpolor.redis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value="/totalcount", method=RequestMethod.GET)
	public long studentTotalCount() {
		return studentService.getStudentTotalCount();
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Student> studentList() {
		return studentService.getStudentList();
	}

	@RequestMapping(value="/{key}", method=RequestMethod.GET)
	public Student studentView(@PathVariable String key) {
		return studentService.getStudent(key);
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public Student studentRegister(@RequestBody Student student) {
		return studentService.registerStudent(student);
	}

	@RequestMapping(value="/{key}", method=RequestMethod.PUT)
	public Student studentModify(@PathVariable String key,
							 @RequestBody Student student) {
		student.setKey(key);
		return studentService.modifyStudent(student);
	}

	@RequestMapping(value="/{key}", method=RequestMethod.DELETE)
	public String studentDelete(@PathVariable String key) {
		return studentService.deleteStudent(key);
	}


}
