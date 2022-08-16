package com.wd.spring.pojo;

import java.util.Arrays;
import java.util.Map;

public class Student {
    private Integer sId;
    private String sName;
    private Integer age;
    private String gender;
    private Double score;
    private Clazz clazz;//多对一，对应对象即类类型。
    private String[] hobby;
    private Map<String, Teacher> teacherMap;//一对多，对应集合。

    public Student() {
    }

    public Student(Integer sId, String sName, String gender, Integer age) {
        this.sId = sId;
        this.sName = sName;
        this.age = age;
        this.gender = gender;
    }

    public Student(Integer sId, String sName, String gender, Double score) {
        this.sId = sId;
        this.sName = sName;
        this.gender = gender;
        this.score = score;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                ", clazz=" + clazz +
                ", hobby=" + Arrays.toString(hobby) +
                ", teacherMap=" + teacherMap +
                '}';
    }
}
