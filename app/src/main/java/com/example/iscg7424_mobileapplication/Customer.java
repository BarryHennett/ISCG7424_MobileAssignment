package com.example.iscg7424_mobileapplication;

public class Customer {
    private int id;
    private String fname;
    private String lname;
    private String email;
    private String pword;

    public Customer(int id, String FNameCt, String LNameCt, String email, String pword) {
        this.id = id;
        this.FNameCt = FNameCt;
        this.LNameCT = LNameCT;
        this.email = email;
        this.pword = pword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }
}
