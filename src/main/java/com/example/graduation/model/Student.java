
package com.example.graduation.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_Student")
@SequenceGenerator(name = "StudentSequence", sequenceName = "SEQ_STUDENT", allocationSize = 1)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "StudentSequence")
    private Integer sId;
    private String sName;
    private String password;
    private String sSex;
    private String sClass;
    private String sTel;
    private String sMail;
    private String sQQ;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "majorId")
    private Major major;
    @OneToMany(mappedBy = "student" , fetch = FetchType.LAZY)
    private Set<TeacherStudent> teacherStudent;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private Set<StudentCourse> studentCourse;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public String getsTel() {
        return sTel;
    }

    public void setsTel(String sTel) {
        this.sTel = sTel;
    }

    public String getsMail() {
        return sMail;
    }

    public void setsMail(String sMail) {
        this.sMail = sMail;
    }

    public String getsQQ() {
        return sQQ;
    }

    public void setsQQ(String sQQ) {
        this.sQQ = sQQ;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Set<TeacherStudent> getTeacherStudent() {
        return teacherStudent;
    }

    public void setTeacherStudent(Set<TeacherStudent> teacherStudent) {
        this.teacherStudent = teacherStudent;
    }

    public Set<StudentCourse> getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(Set<StudentCourse> studentCourse) {
        this.studentCourse = studentCourse;
    }
}