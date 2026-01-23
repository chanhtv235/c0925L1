package repository;

import entity.Student;
import util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private final String STUDENT_FILE = "src/data/student.csv";
    @Override
    public List<Student> findAll() {
        List<String> stringList = ReadAndWriteFile.readFileCSVToStringList(STUDENT_FILE);
        List<Student> studentList = new ArrayList<>();
        String[] array = null;
        for (int i = 0; i <stringList.size() ; i++) {
            array = stringList.get(i).split(",");
            Student student = new Student(Integer.parseInt(array[0]),array[1],array[2]);
            studentList.add(student);
        }
        return studentList;
    }

    @Override
    public void add(Student student) {
        List<String> stringList = new ArrayList<>();
        stringList.add(student.getInfoToCSV());
        ReadAndWriteFile.writeStringListToCSV(STUDENT_FILE,stringList,true);
    }

    @Override
    public boolean updateListStudent(List<Student> studentList) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i <studentList.size() ; i++) {
            stringList.add(studentList.get(i).getInfoToCSV());
        }
        try {
            ReadAndWriteFile.writeStringListToCSV(STUDENT_FILE,stringList,false);
            return true;
        }catch (Exception e){
            System.out.println("Lỗi ghi file");
        }
        return false;
    }
}
