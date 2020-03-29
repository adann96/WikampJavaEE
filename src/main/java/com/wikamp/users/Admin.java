package com.wikamp.users;

public class Admin {
    private int ADMIN_ID;
    private String IMIE, DRUGIE_IMIE, NAZWISKO, STOPIEN, PASSWORD_ACC, ISADMIN;

    public Admin() {
    }

    public int getADMIN_ID() {
        return ADMIN_ID;
    }

    public void setADMIN_ID(int ADMIN_ID) {
        this.ADMIN_ID = ADMIN_ID;
    }

    public String getPASSWORD_ACC() {
        return PASSWORD_ACC;
    }

    public void setPASSWORD_ACC(String PASSWORD_ACC) {
        this.PASSWORD_ACC = PASSWORD_ACC;
    }
}
