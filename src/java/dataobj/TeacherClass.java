/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataobj;

/**
 *
 * @author Admin
 */
public class TeacherClass {
    private int teacherid;
    private int classid;

    public TeacherClass() {
        
    }

    public TeacherClass(int teacherid, int classid) {
        this.teacherid = teacherid;
        this.classid = classid;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    @Override
    public String toString() {
        return "TeacherClass{" + "teacherid=" + teacherid + ", classid=" + classid + '}';
    }
    
}
