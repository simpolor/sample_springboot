package io.simpolor.h2database.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Student {

	@Id
	@GeneratedValue
	private long seq;

	private String name;
	private int grade;
	private int age;
}