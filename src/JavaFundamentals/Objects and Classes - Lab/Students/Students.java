package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<StudentsInfo> student = new ArrayList<>();

        String com = scan.nextLine();

        while (!com.equals("end")) {

            String[] info = com.split(" ");

            int age = Integer.parseInt(info[2]);

            StudentsInfo students = new StudentsInfo(info[0], info[1], age, info[3]);

            student.add(students);

            com = scan.nextLine();
        }

        String printHome = scan.nextLine();

        removeIfStudentExist(student);

        for (int i = 0; i < student.size(); i++) {
            StudentsInfo students = student.get(i);
            if (students.getHome().equals(printHome)) {
                System.out.printf("%s %s is %d years old %n", students.getFirstName(), students.getLastName(), students.getAge());
            }
        }

    }

    public static void removeIfStudentExist(List<StudentsInfo> student) {
        for (int i = 0; i < student.size() - 1; i++) {
            StudentsInfo students = student.get(i);

            for (int j = i + 1; j < student.size(); j++) {
                StudentsInfo studentss = student.get(j);

                if (students.getFirstName().equals(studentss.getFirstName())) {
                    if (studentss.getLastName().equals(students.getLastName())) {
                        student.remove(i);
                        i = -1;
                    }
                }

            }
        }
    }

}
