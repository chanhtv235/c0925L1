package view;

import entity.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    private static Scanner scanner = new Scanner(System.in);
    public static void display(List<Student> studentList){
        for (int i = 0; i <studentList.size() ; i++) {
            System.out.println((i+1)+ "."+ studentList.get(i));
        }
    }
    public static Student inputData(){
        System.out.println("Nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        return new Student(id,name,address);
    }

    public static int inputId() {
        System.out.println("Nhập id cần xoá");
        return Integer.parseInt(scanner.nextLine());
    }
}
