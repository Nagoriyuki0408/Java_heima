package itshiokou.Management_Module;
class Student {
    private String name;
    private String gender;
    private double grade;
    public Student(String name, String gender, double grade) {
        this.name = name;
        this.gender = gender;
        this.grade = grade;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public double getGrade() {
        return grade;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Gender: " + gender + ", Grade: " + grade;
    }
}