package com.vm.rest;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {


	List<Student> students;

	public List<Student> createStudents() {

		students = new ArrayList<Student>();
		students.add(new Student(1, "aaa", 1, 11));
		students.add(new Student(2, "bbb", 2, 22));
		students.add(new Student(3, "ccc",3, 33));
		students.add(new Student(4, "ddd", 4, 44));
		return students;
	}
	
	/**
	 * get all the students from the list.
	 * @return
	 */
	public List<Student> getStudents()
	{
		if(students == null)
		{
			createStudents();
		}
		return students;
	}

	public Student getStudent(int id) 
	{

		Student student = students.stream().filter(s ->s.getId() == id).findFirst().get();

		return student;
	}

	public void addStudent(Student student) {

		students.add(student);

	}

	public void updateStudent(Student student, int id) {

		for(int i = 0; i< students.size(); i++) {
			Student s = students.get(i);
			if(s.getId() == id) {
				students.set(id, student);
				return;
			}
		}

	}

	public void deleteStudent(Student student, int id) {

		students.removeIf(s -> s.getId() == id);
	}

}