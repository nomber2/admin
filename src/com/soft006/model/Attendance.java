package com.soft006.model;

/**
 * Created by Admin on 2017/12/21.
 */
public class Attendance {
    private String id;
    private String account;
    private Integer departmentID;
    private String mouth;
    private String day;
    private String attendance;

    public Attendance(String id, String account, Integer departmentID, String mouth, String day, String attendance) {
        this.id = id;
        this.account = account;
        this.departmentID = departmentID;
        this.mouth = mouth;
        this.day = day;
        this.attendance = attendance;
    }

    public Attendance() {
    }

    public String  getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String month) {
        this.mouth = mouth;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", departmentID=" + departmentID +
                ", mouth='" + mouth + '\'' +
                ", day='" + day + '\'' +
                ", attendance=" + attendance +
                '}';
    }
}
