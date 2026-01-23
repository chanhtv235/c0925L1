package controller;

import entity.Student;
import service.IStudentService;
import service.StudentService;
import view.StudentView;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    public static IStudentService studentService = new StudentService();

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("========Quản lý sinh viên========" +
                    "\n1. Danh sách" +
                    "\n2. Thêm mới" +
                    "\n3. Xoá" +
                    "\n4. Thoát");

            System.out.println("Chọn chức năng:");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Hiển thị danh sách");
                    ///  gọi service để hiển thị.
                    List<Student> studentList = studentService.findAll();
                    StudentView.display(studentList);
                    break;
                case 2:
                    System.out.println(" Thêm mới");
                    Student student = StudentView.inputData();
                    studentService.add(student);
                    System.out.println("Thêm mới thành công");
                    ///  gọi service để hiển thị.
                    break;
                case 3:
                    System.out.println("Xoá");
                    ///  gọi service để hiển thị.
                    int deleteId= StudentView.inputId();
                    boolean isDelete =studentService.deleteById(deleteId);
                    if (isDelete){
                        System.out.println("xoá thành công");
                    }else {
                        System.out.println("xoa khong thanh cong");
                    }

                    break;
                default:
                    flag = false;

            }
        }


    }
}
