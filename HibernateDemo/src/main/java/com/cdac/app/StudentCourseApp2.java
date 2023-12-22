package com.cdac.app;

import java.time.LocalDate;

import com.cdac.dao.GenericDao;
import com.cdac.entity.manytomany.copy.Course;
import com.cdac.entity.manytomany.copy.Enrolment;
import com.cdac.entity.manytomany.copy.Student;

public class StudentCourseApp2 {

	public static void main(String[] args) {
		GenericDao dao = new GenericDao();
		
		//adding a course
		/*Course course = new Course();
		course.setName("Java");
		course.setDuration(90);
		course.setFees(9000);
		dao.save(course);*/
		
		//adding a student
		/*Student student = new Student();
		student.setName("Neha");
		student.setEmail("neha@gmail.com");
		student.setMobileNumber(98765);
		dao.save(student);*/
		
		//linking student with course
		Student student = (Student) dao.fetchById(Student.class, 1);
		Course course = (Course) dao.fetchById(Course.class, 2);
		Enrolment enrolment = new Enrolment();
		enrolment.setCourse(course);
		enrolment.setStudent(student);
		enrolment.setEnrolmentDate(LocalDate.now());
		dao.save(enrolment);
	}
}
