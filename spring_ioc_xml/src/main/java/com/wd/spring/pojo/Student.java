package com.wd.spring.pojo;

public class Student {
    private Integer sId;
    private String sName;
    private Integer age;
    private String gender;

    public Student() {
    }

    public Student(Integer sId, String sName, Integer age, String gender) {
        this.sId = sId;
        this.sName = sName;
        this.age = age;
        this.gender = gender;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
