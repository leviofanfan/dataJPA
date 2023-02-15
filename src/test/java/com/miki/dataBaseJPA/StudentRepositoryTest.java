package com.miki.dataBaseJPA;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.miki.dataBaseJPA.entity.Guardian;
import com.miki.dataBaseJPA.entity.Student;
import com.miki.dataBaseJPA.repository.StudentRepository;

@SpringBootTest
public class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		Student student = Student.builder()
				.emailId("mykyta.nalchadzhy@edu.rtu.lv")
				.firstName("Mykyta")
				.lastName("Nalchadzhy")
				.build();
		
		studentRepository.save(student);
	}
	
	@Test
	public void saveStudentWithGuardian() {
		Guardian guardian = Guardian.builder()
				.email("nikhil@gmail.com")
				.name("Nikhil")
				.mobile("99999999999")
				.build();
				
		Student student = Student.builder()
				.firstName("Shivam")
				.emailId("shivam@gmail.com")
				.lastName("Kumar")
				.guardian(guardian)
				.build();
		
		studentRepository.save(student);
	}
	
	@Test
	public void printAllStudent() {
		List<Student> studentList =
				studentRepository.findAll();
		
		System.out.println("studentList = " + studentList);
	}
	
	@Test
	public void printStudentByFirstName() {
		
		List<Student> students =
				studentRepository.findByFirstNameContaining("Sh");
		
		System.out.println("students = " + students);
	}
	
	@Test
	public void printStudentBasedOnGuardianName() {
		List<Student> students = 
				studentRepository.findByGuardianName("Nikhil");
		System.out.println("students = " + students);
	}
	
	@Test
	public void printgetStudentByEmailAdress() {
		
		Student student =
				studentRepository.getStudentByEmailAdress(
						"shivam@gmail.com"
						);
		System.out.println("students= " + student);
	}
	
	@Test
	public void printgetStudentFirstNameByEmailAdress() {
		
		String student =
				studentRepository.getStudentFirstNameByEmailAdress(
						"shivam@gmail.com"
						);
		System.out.println("firstName= " + student);
	}
	
	@Test
	public void printgetStudentByEmailAdressNative() {
		
		Student student =
				studentRepository.getStudentByEmailAdressNative(
						"shivam@gmail.com"
						);
		System.out.println("students_by_email= " + student);
	}
	
	@Test
	public void printgetStudentByEmailAdressNativeNamedParam() {
		
		Student student =
				studentRepository.getStudentByEmailAdressNativeNamedParam(
						"shivam@gmail.com"
						);
		System.out.println("students_by_email= " + student);
	}
	
	@Test
	public void updateStudentNameByEmailIdTest() {
		studentRepository.updateStudentNameByEmailId(
				"Shiva",
				"shivam@gmail.com"
				);
	}
}
