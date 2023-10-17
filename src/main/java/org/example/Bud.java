package org.example;

import java.time.LocalDateTime;

public class Bud {
    /** Attributter **/
    private Bolig bolig;
    private Budgiver budGiver;
    private double pris;
    private LocalDateTime akseptFrist;

    /** Konstruktor **/
    public Bud(Bolig bolig, Budgiver budgiver, double pris, int timer, int minutter) {

        if(pris < 0) {
            throw new IllegalArgumentException("Negativt beløp er ikke tillatt");
        }

        if(timer > 0 || (timer == 0 && minutter > 0)){
            this.bolig = bolig;
            this.budGiver = budgiver;
            this.pris = pris;
            this.akseptFrist = LocalDateTime.now().plusHours(timer).plusMinutes(minutter);
        } else {
            throw new IllegalArgumentException("Ditt bud er ugyldig ettersom det er utenfor akseptfrist");
        }
    }

    /** Getter og Setter **/
    public double getPris() {
        return pris;
    }

    public LocalDateTime getAkseptFrist() {
        return akseptFrist;
    }

    public Bolig getBolig() {
        return bolig;
    }

    public void setBolig(Bolig bolig) {
        this.bolig = bolig;
    }

    public Budgiver getBudGiver() {
        return budGiver;
    }

    public void setBudGiver(Budgiver budGiver) {
        this.budGiver = budGiver;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public void setAkseptFrist(LocalDateTime akseptFrist) {
        this.akseptFrist = akseptFrist;
    }
}
