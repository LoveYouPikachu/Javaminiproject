package studemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StuMain {
    public StuMain() {
    }

    public static void main(String[] args) {
        System.out.println("---Welcome student management system");
        Student student = new Student();
        Scanner s = new Scanner(System.in);
        System.out.println("input id");
        int id = s.nextInt();
        student.id = id;
        System.out.println("input name");
        String name = s.next();
        student.username = name;
        System.out.println("input sex");
        String sex = s.next();
        student.sex = sex;
        System.out.println("input math grade");
        int math = s.nextInt();
        student.math = math;
        System.out.println("input english grade");
        int english = s.nextInt();
        student.english = english;
        writeStudent(student);
    }

    public static void writeStudent(Student student) {
        File file = new File("stu.txt");
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(file));
            bw.write("id\tname\tsex\t\tmath\tenglish");
            bw.newLine();
            bw.write(student.id + "\t");
            bw.write(student.username + "\t");
            bw.write(student.sex + "\t");
            bw.write(student.math + "\t");
            bw.write(student.english + "\t");
            bw.flush();
        } catch (IOException var12) {
            var12.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException var11) {
                    var11.printStackTrace();
                }
            }

        }

    }
}