package com.miki.dataBaseJPA;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.miki.dataBaseJPA.entity.Course;
import com.miki.dataBaseJPA.entity.CourseMaterial;
import com.miki.dataBaseJPA.repository.CourseMaterialRepository;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository repository;
	
	@Test
	public void SaveCourseMaterial() {
		Course course =
				Course.builder()
				.title("DSA")
				.credit(6)
				.build();
		
		CourseMaterial courseMaterial = 
				CourseMaterial.builder()
				.url("www.google.com")
				.course(course)
				.build();
		
		repository.save(courseMaterial);
	}
	
	@Test
	public void printAllCoursesMaterials() {
		List<CourseMaterial> courseMaterials = 
				repository.findAll();
		
		System.out.println("courseMaterials = " + courseMaterials);
	}
	

}
