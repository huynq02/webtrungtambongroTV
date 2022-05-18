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
public class Teacher {
    private int id;
    private String name;
    private boolean gender;
    private int cardNo;
    private int phone;
    private String addr;
    private String email;

    public Teacher() {
        
    }

    public Teacher(int id, String name, boolean gender, int cardNo, int phone, String addr, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.cardNo = cardNo;
        this.phone = phone;
        this.addr = addr;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", cardNo=" + cardNo + ", phone=" + phone + ", addr=" + addr + ", email=" + email + '}';
    }
    
    
}
