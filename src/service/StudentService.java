package service;

import entity.Student;
import repository.IStudentRepository;
import repository.StudentRepository;
import util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class StudentService  implements IStudentService{
   private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        // sau nay sẽ đọc file lấy dữ liệu.
        return studentRepository.findAll();
    }

    @Override
    public void add(Student student) {
      // kiểm id tồn tại chưa?
      studentRepository.add(student);
    }

    @Override
    public boolean deleteById(int deleteId) {
        // kiểm tra id có tồn tại khong
        List<Student>  studentList = studentRepository.findAll();
        boolean isIdExist = false;
        for (int i = 0; i <studentList.size() ; i++) {
            if (deleteId == studentList.get(i).getId()){
               studentList.remove(i);
               isIdExist = true;
               break;
            }
        }
        if (isIdExist){
          return studentRepository.updateListStudent(studentList);
        }
        return isIdExist;
    }
}
