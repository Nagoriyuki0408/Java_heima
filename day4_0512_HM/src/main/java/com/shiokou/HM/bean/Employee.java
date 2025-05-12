package com.shiokou.HM.bean;

public class Employee {
    private String id;
    private String gender;
    private String age;
    private String phone;
    private String position;
    private String hireDate;
    private String salary;
    private String department;

    public Employee(String id, String gender, String age, String phone, String position, String hireDate, String salary, String department) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.position = position;
        this.hireDate = hireDate;
        this.salary = salary;
        this.department = department;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}