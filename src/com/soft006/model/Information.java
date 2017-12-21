package com.soft006.model;

import java.sql.Date;
import java.util.Arrays;

/**
 * Created by Admin on 2017/12/19.
 */
public class Information {
    private String account;
    private String name;
    private Integer departmentID;
    private String education;
    private String gender;
    private Date birthday;
    private byte[] avatar;
    private String telephone;
    private String address;
    private Date enter_time;

    public Information(String account, String name, Integer departmentID,
                       String education, String gender, Date birthday, byte[] avatar,
                       String telephone, String address, Date enter_time) {
        this.account = account;
        this.name = name;
        this.departmentID = departmentID;
        this.education = education;
        this.gender = gender;
        this.birthday = birthday;
        this.avatar = avatar;
        this.telephone = telephone;
        this.address = address;
        this.enter_time = enter_time;
    }

    public Information() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEnter_time() {
        return enter_time;
    }

    public void setEnter_time(Date enter_time) {
        this.enter_time = enter_time;
    }

    @Override
    public String toString() {
        return "Information{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", departmentID=" + departmentID +
                ", education='" + education + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", avatar=" + Arrays.toString(avatar) +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", enter_time=" + enter_time +
                '}';
    }
}
