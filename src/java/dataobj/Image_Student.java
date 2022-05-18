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
public class Image_Student {
    private int eid;
    private String url;
    private int sid;

    public Image_Student() {
        
    }

    public Image_Student(int eid, String url, int sid) {
        this.eid = eid;
        this.url = url;
        this.sid = sid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
    
}
