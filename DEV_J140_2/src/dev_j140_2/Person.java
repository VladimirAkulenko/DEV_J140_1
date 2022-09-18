/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev_j140_2;

/**
 *
 * @author USER
 */
public class Person {
    private Integer id;
    private String jobtitle;
    private String firstnamelastname;
    private String phone;
    private String email;

    public Person(Integer id, String jobtitle, String firstnamelastname, String phone, String email) {
        this.id = id;
        this.jobtitle = jobtitle;
        this.firstnamelastname = firstnamelastname;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }


    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getFirstnamelastname() {
        return firstnamelastname;
    }

    public void setFirstnamelastname(String firstnamelastname) {
        this.firstnamelastname = firstnamelastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", jobtitle=" + jobtitle + ", firstnameastname=" + firstnamelastname + ", phone=" + phone + ", email=" + email + '}';
    }
}
