package itshiokou.Management_Module;

public class Main {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();
        classroom.addStudent(new Student("Alice", "female", 85.0));
        classroom.addStudent(new Student("Bob", "male", 90.0));
        classroom.addStudent(new Student("Charlie", "male", 78.0));
        classroom.addStudent(new Student("Diana", "female", 92.0));
        classroom.addStudent(new Student("Eve", "female", 95.0));
        classroom.addStudent(new Student("Frank", "male", 70.0));

        System.out.println("--- Student Information with Gender Count ---");
        classroom.printStudentInfoWithGenderCount();

        System.out.println("\n--- Average Grade (Without Extremes) ---");
        Classroom.AverageGradeCalculator calculator = classroom.new AverageGradeWithoutExtremes();
        System.out.println("Average Grade: " + classroom.getAverageGrade(calculator));
    }
}
