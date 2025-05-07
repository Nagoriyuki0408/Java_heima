package itshiokou.Management_Module;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Classroom {
    private List<Student> students;
    public Classroom() {
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        this.students.add(student);
    }

    // 功能1：打印全班学生的信息（包含男女人数）
    public void printStudentInfoWithGenderCount() {
        int maleCount = 0;
        int femaleCount = 0;
        for (Student student : students) {
            System.out.println(student);
            if ("male".equalsIgnoreCase(student.getGender())) {
                maleCount++;
            } else if ("female".equalsIgnoreCase(student.getGender())) {
                femaleCount++;
            }
        }
        System.out.println("\nMale Count: " + maleCount);
        System.out.println("Female Count: " + femaleCount);
    }

    // 接口定义
    interface AverageGradeCalculator {
        double calculateAverage(List<Student> students);
    }

    // 实现接口的类
     class AverageGradeWithoutExtremes implements AverageGradeCalculator {
        @Override
        public double calculateAverage(List<Student> students) {
            if (students.size() <= 2) {
                // 如果学生数量少于等于2，则直接计算平均分
                double sum = 0;
                for (Student student : students) {
                    sum += student.getGrade();
                }
                return students.isEmpty() ? 0.0 : sum / students.size();
            }

            List<Double> grades = new ArrayList<>();
            for (Student student : students) {
                grades.add(student.getGrade());
            }
            Collections.sort(grades); // 排序

            double sum = 0;
            for (int i = 1; i < grades.size() - 1; i++) { // 去掉最高分和最低分
                sum += grades.get(i);
            }

            return sum / (grades.size() - 2);
        }
    }

    // 使用接口计算平均分
    public double getAverageGrade(AverageGradeCalculator calculator) {
        return calculator.calculateAverage(students);
    }
}