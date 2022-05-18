/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataobj;

/**
 *
 * @author TuanAnh
 */
public class Parent {
    private int pid;
    private String pname;
    private int phone;
    private String add;
    private String email;
    private String job;
    private String placeWork;

    public Parent() {
        
    }

    public Parent(int pid, String pname, int phone, String add, String email, String job, String placeWork) {
        this.pid = pid;
        this.pname = pname;
        this.phone = phone;
        this.add = add;
        this.email = email;
        this.job = job;
        this.placeWork = placeWork;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPlaceWork() {
        return placeWork;
    }

    public void setPlaceWork(String placeWork) {
        this.placeWork = placeWork;
    }

    @Override
    public String toString() {
        return "Parent{" + "pid=" + pid + ", pname=" + pname + ", phone=" + phone + ", add=" + add + ", email=" + email + ", job=" + job + ", placeWork=" + placeWork + '}';
    }
    
    
}
