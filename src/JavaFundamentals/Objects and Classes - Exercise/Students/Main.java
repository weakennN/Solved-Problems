package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<StudentsExerciseInfo> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] info = scan.nextLine().split(" ");

            Double grade = Double.parseDouble(info[2]);


            StudentsExerciseInfo student = new StudentsExerciseInfo(info[0], info[1], grade);

            students.add(student);
        }

        students.stream().sorted((p1,p2) -> Double.compare(p2.getGrade(),p1.getGrade()))
                .forEach(p -> System.out.println(p));
    }
}
