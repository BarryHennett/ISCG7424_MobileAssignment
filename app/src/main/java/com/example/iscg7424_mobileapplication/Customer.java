package com.example.iscg7424_mobileapplication;
public class Customer {
    private int id;
    private String FNameCt;
    private String LNameCt;
    private String email;
    private String pword;

    public Customer() {
        this.id = id;
        this.FNameCt = FNameCt;
        this.LNameCt = LNameCt;
        this.email = email;
        this.pword = pword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFNameCt() {
        return FNameCt;
    }

    public void setFNameCt(String FNameCt) {
        this.FNameCt = FNameCt;
    }

    public String getLNameCt() {
        return LNameCt;
    }

    public void setLNameCt(String LNameCt) {
        this.LNameCt = LNameCt;
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
