package com.wikamp.charts;

public class Faculty {
    private String facultyName;
    private int studentsNo;

    public Faculty(String facultyName, int studentsNo) {
        this.facultyName = facultyName;
        this.studentsNo = studentsNo;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public int getStudentsNo() {
        return studentsNo;
    }

    public void setStudentsNo(int studentsNo) {
        this.studentsNo = studentsNo;
    }
}
