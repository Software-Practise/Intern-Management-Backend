package com.example.demo.FacultyPack;

import java.util.List;

import com.example.demo.StudentPack.Student;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Faculty")
public class Faculty {
    @Id
    private String id;
    private String fname;
    private String lname;
    private String department;
    private String email;
    private List<String> comments;
    //private List<Student> list;


    public Faculty(String id, String fname, String lname, String department, String email, List<String> comments) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.department = department;
        this.email = email;
        this.comments = comments;
        //this.list = list;
    }


    public List<String> getComments() {
        return comments;
    }


    public void setComments(List<String> comments) {
        this.comments = comments;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getFname() {
        return fname;
    }


    public void setFname(String fname) {
        this.fname = fname;
    }


    public String getLname() {
        return lname;
    }


    public void setLname(String lname) {
        this.lname = lname;
    }


    public String getDepartment() {
        return department;
    }


    public void setDepartment(String department) {
        this.department = department;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    


    //public List<Student> getList() {
        //return list;
    //}


    //public void setList(List<Student> list) {
        //this.list = list;
    //}
    ////DO WE NEED TO HAVE THE FOLLOWING METHODS
    /*
    public void addStudent(Student stu){
        list.add(stu);
    }

    public void removeStu(Student stu){
        list.remove(stu);
    }

    public Student getStudent(Student stu){
        int index = list.indexOf(stu);
        return list.get(index);
    }

    public void setStudent(Student stu, int index){
        list.set(index, stu);
    }
    */

    

    
    


}
