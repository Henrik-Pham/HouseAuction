package org.example;

public class Budgiver {

    /** Attributter **/
    private String navn;
    private String telefonNummer;

    /** Konstruktor **/
    public Budgiver(String navn, String telefonnummer) {
        this.navn = navn;
        this.telefonNummer = telefonnummer;
    }


    /** Metoder **/
    public void giBud(Bolig bolig, double pris, int timer, int minutter) {
        Bud nyttBud = new Bud(bolig, this, pris, timer, minutter);
        bolig.leggTilBud(nyttBud);
    }


    /** Getter og Setter**/
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getTelefonNummer() {
        return telefonNummer;
    }

    public void setTelefonNummer(String telefonNummer) {
        this.telefonNummer = telefonNummer;
    }
}