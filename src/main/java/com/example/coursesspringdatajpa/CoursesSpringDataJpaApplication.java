package com.example.coursesspringdatajpa;

import com.example.coursesspringdatajpa.guardian.Guardian;
import com.example.coursesspringdatajpa.student.Student;
import com.example.coursesspringdatajpa.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CoursesSpringDataJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CoursesSpringDataJpaApplication.class, args);
	}

	private StudentRepository studentRepository;

	public CoursesSpringDataJpaApplication(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public void saveStudent() {
		Guardian franz = Guardian.builder()
				.name("Franz Henkins")
				.email("franzH@gmail.com")
				.phone("36594789")
				.build();
		Student carl = Student.builder()
				.firstName("Carl")
				.lastName("Henkins")
				.emailAddress("carlHen@gmail.com")
				.guardian(franz)
				.build();

		Guardian paul = Guardian.builder()
				.name("Paul Sutterson")
				.email("paul@gmail.com")
				.phone("32659874")
				.build();
		Student hank = Student.builder()
				.firstName("Hank")
				.lastName("Sutterson")
				.emailAddress("HanTerson@gmail.com")
				.guardian(paul)
				.build();

		Guardian stan = Guardian.builder()
				.name("Stan Woklowski")
				.email("stwoklow@gmail.com")
				.phone("32654895")
				.build();
		Student walter = Student.builder()
				.firstName("Walter")
				.lastName("Woklowski")
				.emailAddress("walterWoklowski@gmail.com")
				.guardian(stan)
				.build();

		studentRepository.save(carl);
		studentRepository.save(hank);
		studentRepository.save(walter);
	}

	public void fetchStudents() {
		List<Student> students = studentRepository.findAll();
		System.out.println("\nSTUDENTS LIST");
		students.forEach(System.out::println);
	}

	public void fetchStudentsByFirstName() {
		String firstName = "Hank";
		List<Student> students = studentRepository.findByFirstName(firstName);
		System.out.println("\nFIND STUDENTS BY FIRST NAME: " + firstName);
		students.forEach(System.out::println);
	}

	public void fetchStudentsByLastName() {
		String lastName = "Henkins";
		List<Student> students = studentRepository.findByLastName(lastName);
		System.out.println("\nFIND STUDENTS BY LAST NAME: " + lastName);
		students.forEach(System.out::println);
	}


	public void fetchStudentByFirstNameContaining() {
		String firstName = "lt";
		List<Student> studentsWithLt = studentRepository.findByFirstNameContaining(firstName);
		System.out.println("\nFIND STUDENTS BY FIRST NAME CONTAINING GIVEN SUBSTRING: " + firstName);
		studentsWithLt.forEach(System.out::println);
	}

	public void fetchStudentByGuardianName() {
		String name = "Paul Sutterson";
		List<Student> students = studentRepository.findStudentsByGuardianName(name);
		System.out.println("\nFIND STUDENTS BY GUARDIAN NAME: " + name);
		students.forEach(System.out::println);
	}

	public void fetchStudentByEmailAddress() {
		String email = "walterWoklowski@gmail.com";
		Student student = studentRepository.findStudentByEmailAddress(email);
		System.out.println("\nFIND STUDENT BY EMAIL ADDRESS: " + email);
		System.out.println(student);
	}

	public void fetchStudentFirstNameByEmailAddress() {
		String email = "walterWoklowski@gmail.com";
		String studentFirstName = studentRepository.findStudentFirstNameByEmailAddress(email);
		System.out.println("\nFIND STUDENT FIRST NAME BY EMAIL ADDRESS: " + email);
		System.out.println(studentFirstName);
	}

	public static void lineDivisor() {
		System.out.println("==============================================================================");
	}

	@Override
	public void run(String... args) throws Exception {
		saveStudent();
		lineDivisor();
		fetchStudents();
		lineDivisor();
		fetchStudentsByFirstName();
		lineDivisor();
		fetchStudentsByLastName();
		lineDivisor();
		fetchStudentByFirstNameContaining();
		lineDivisor();
		fetchStudentByGuardianName();
		lineDivisor();
		fetchStudentByEmailAddress();
		lineDivisor();
		fetchStudentFirstNameByEmailAddress();
		lineDivisor();
	}
}

