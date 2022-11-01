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
				.name("Franz")
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
				.name("Paul")
				.email("paul@gmail.com")
				.phone("32659874")
				.build();
		Student hank = Student.builder()
				.firstName("Hank")
				.lastName("Sutterson")
				.emailAddress("HanTerson@gmail.com")
				.guardian(paul)
				.build();

		studentRepository.save(carl);
		studentRepository.save(hank);
	}

	public void fetchStudents() {
		List<Student> students = studentRepository.findAll();
		System.out.println("\nSTUDENTS LIST");
		students.forEach(System.out::println);
	}

	@Override
	public void run(String... args) throws Exception {
		saveStudent();
		fetchStudents();
	}
}
