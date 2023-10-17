package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bolig {

    /** Attributter **/
    private String gateAdresse;
    private String postNummer;
    private double takstPris;
    private List<Bud> budListe = new ArrayList<>();
    private Bud vinnerbud;


    /** Konstruktor **/
    public Bolig(String gateadresse, String postnummer, double takstpris) {
        this.gateAdresse = gateadresse;
        this.postNummer = postnummer;
        this.takstPris = takstpris;
    }


    /** Metoder **/
    public List<Bud> hentAktiveBud() {
        return budListe.stream()
                .filter(bud -> bud.getAkseptFrist().isAfter(LocalDateTime.now()))
                .sorted(Comparator.comparing(Bud::getAkseptFrist))
                .collect(Collectors.toList());
    }

    public Bud hentHoyesteAktivtBud() {
        return hentAktiveBud().stream()
                .max(Comparator.comparing(Bud::getPris))
                .orElse(null);
    }

    public void aksepterBud(Bud bud) {
        if (budListe.contains(bud) && bud.getAkseptFrist().isAfter(LocalDateTime.now())) {
            vinnerbud = bud;
        } else {
            throw new IllegalArgumentException("Dette budet kan ikke aksepteres");
        }
    }
    public void leggTilBud(Bud bud) {
        budListe.add(bud);
    }


    /** Getter og Setter **/
    public String getGateAdresse() {
        return gateAdresse;
    }

    public void setGateAdresse(String gateAdresse) {
        this.gateAdresse = gateAdresse;
    }

    public String getPostNummer() {
        return postNummer;
    }

    public void setPostNummer(String postNummer) {
        this.postNummer = postNummer;
    }

    public double getTakstPris() {
        return takstPris;
    }

    public void setTakstPris(double takstPris) {
        this.takstPris = takstPris;
    }

    public List<Bud> getBudListe() {
        return budListe;
    }

    public void setBudListe(List<Bud> budListe) {
        this.budListe = budListe;
    }

    public Bud getVinnerbud() {
        return vinnerbud;
    }

    public void setVinnerbud(Bud vinnerbud) {
        this.vinnerbud = vinnerbud;
    }
}