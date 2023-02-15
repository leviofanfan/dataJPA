package com.miki.dataBaseJPA;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.miki.dataBaseJPA.entity.Course;
import com.miki.dataBaseJPA.entity.Teacher;
import com.miki.dataBaseJPA.repository.TeacherRepository;

@SpringBootTest
public class TeacherRepositoryTest {
	
	@Autowired
	private TeacherRepository repository;
	
	@Test
	public void saveTeacher() {
		Course courseDBA = Course.builder()
				.title("DBA")
				.credit(5)
				.build();
		Course courseJava = Course.builder()
				.title("Java")
				.credit(3)
				.build();
		
		Teacher teacher = 
				Teacher.builder()
				.firstName("Qutub")
				.lastName("Khan")
				//.courses(List.of(courseDBA,courseJava))
				.build();
		
		repository.save(teacher);
	}
}
