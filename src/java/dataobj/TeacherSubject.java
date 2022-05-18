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
public class TeacherSubject {
    private int teacherid;
    private int subjectid;

    public TeacherSubject() {
        
    }

    public TeacherSubject(int teacherid, int subjectid) {
        this.teacherid = teacherid;
        this.subjectid = subjectid;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    @Override
    public String toString() {
        return "TeacherSubject{" + "teacherid=" + teacherid + ", subjectid=" + subjectid + '}';
    }
    
    
}
