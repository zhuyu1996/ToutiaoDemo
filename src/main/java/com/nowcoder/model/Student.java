package com.nowcoder.model;

public class Student {
    private int studentId;
    private String studentName;
    private String studentClass;
    private  String studentTercher;
    private  String studentPasswrod;
    private  String salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentTercher() {
        return studentTercher;
    }

    public void setStudentTercher(String studentTercher) {
        this.studentTercher = studentTercher;
    }

    public String getStudentPasswrod() {
        return studentPasswrod;
    }

    public void setStudentPasswrod(String studentPasswrod) {
        this.studentPasswrod = studentPasswrod;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", studentTercher='" + studentTercher + '\'' +
                ", studentPasswrod='" + studentPasswrod + '\'' +
                '}';
    }
}
