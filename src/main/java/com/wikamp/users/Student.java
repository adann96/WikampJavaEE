package com.wikamp.users;

public class Student {
    private String IMIE, DRUGIE_IMIE, NAZWISKO, NARODOWOSC, PESEL, MIASTO, KOD, WOJEWODZTWO, ULICA, PASSWORD_ACC;
    private int KIERUNEK_ID, WYDZIAL_ID, BLOK_NR, MIESZKANIE_NR, SPEC_ID, NUMER_INDEKSU;

    public Student() {

    }

    public String getPASSWORD_ACC() {
        return PASSWORD_ACC;
    }

    public void setPASSWORD_ACC(String PASSWORD_ACC) {
        this.PASSWORD_ACC = PASSWORD_ACC;
    }

    public int getNUMER_INDEKSU() {
        return NUMER_INDEKSU;
    }

    public void setNUMER_INDEKSU(int NUMER_INDEKSU) {
        this.NUMER_INDEKSU = NUMER_INDEKSU;
    }
}