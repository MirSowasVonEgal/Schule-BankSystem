package me.timo.banksystem;

public class ÜberweisungsAuftrag {

    private double betrag = 0;
    private String von_IBAN = "";
    private String auf_IBAN = "";

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public String getVon_IBAN() {
        return von_IBAN;
    }

    public void setVon_IBAN(String von_IBAN) {
        this.von_IBAN = von_IBAN;
    }

    public String getAuf_IBAN() {
        return auf_IBAN;
    }

    public void setAuf_IBAN(String auf_IBAN) {
        this.auf_IBAN = auf_IBAN;
    }

    public ÜberweisungsAuftrag(double betrag, String von_IBAN, String auf_IBAN) {
        this.betrag = betrag;
        this.von_IBAN = von_IBAN;
        this.auf_IBAN = auf_IBAN;
    }
}
