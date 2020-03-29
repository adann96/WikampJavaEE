package com.wikamp.users;

public class Admin{
    private String IMIE, DRUGIE_IMIE, NAZWISKO, NARODOWOSC, PESEL, MIASTO, KOD, WOJEWODZTWO, ULICA, PASSWORD_ACC;
    private int KIERUNEK_ID, WYDZIAL_ID, BLOK_NR, MIESZKANIE_NR, SPEC_ID, NUMER_ADMINISTRATORA;

    public Admin() {

    }

    public String getPASSWORD_ACC() {
        return PASSWORD_ACC;
    }

    public void setPASSWORD_ACC(String PASSWORD_ACC) {
        this.PASSWORD_ACC = PASSWORD_ACC;
    }

    public int getNUMER_ADMINISTRATORA() {
        return NUMER_ADMINISTRATORA;
    }

    public void setNUMER_ADMINISTRATORA(int NUMER_ADMINISTRATORA) {
        this.NUMER_ADMINISTRATORA = NUMER_ADMINISTRATORA;
    }
}