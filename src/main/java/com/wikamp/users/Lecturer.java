package com.wikamp.users;

public class Lecturer {
    private String IMIE, DRUGIE_IMIE, NAZWISKO, NARODOWOSC, PESEL, MIASTO, KOD, WOJEWODZTWO, ULICA, PASSWORD_ACC;
    private int KIERUNEK_ID, WYDZIAL_ID, BLOK_NR, MIESZKANIE_NR, SPEC_ID, NUMER_WYKLADOWCY;

    public Lecturer() {

    }

    public String getPASSWORD_ACC() {
        return PASSWORD_ACC;
    }

    public void setPASSWORD_ACC(String PASSWORD_ACC) {
        this.PASSWORD_ACC = PASSWORD_ACC;
    }

    public int getNUMER_WYKLADOWCY() {
        return NUMER_WYKLADOWCY;
    }

    public void setNUMER_WYKLADOWCY(int NUMER_WYKLADOWCY) {
        this.NUMER_WYKLADOWCY = NUMER_WYKLADOWCY;
    }
}