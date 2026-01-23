package service;

import entity.Student;

import java.util.List;

public interface IStudentService {
    // thiết kế các method CRUD
    List<Student> findAll();
    void add(Student student);

    boolean deleteById(int deleteId);
}
