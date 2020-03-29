package com.wikamp.users;

public class Lecturer {
    private int WYKLADOWCA_ID;
    private String IMIE, DRUGIE_IMIE, NAZWISKO, STOPIEN, PASSWORD_ACC, ISADMIN;

    public Lecturer() {

    }

    public int getWYKLADOWCA_ID() {
        return WYKLADOWCA_ID;
    }

    public void setWYKLADOWCA_ID(int WYKLADOWCA_ID) {
        this.WYKLADOWCA_ID = WYKLADOWCA_ID;
    }

    public String getPASSWORD_ACC() {
        return PASSWORD_ACC;
    }

    public void setPASSWORD_ACC(String PASSWORD_ACC) {
        this.PASSWORD_ACC = PASSWORD_ACC;
    }
}
