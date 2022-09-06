package me.timo.banksystem;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bank {

    public class Konto {

        private Kunde kunde;
        private double kontostand = 0;
        private String IBAN = "";

        public Kunde getKunde() {
            return kunde;
        }

        public void setKunde(Kunde kunde) {
            this.kunde = kunde;
            this.kunde.addKonto(this);
        }

        public double getKontostand() {
            return kontostand;
        }

        public void setKontostand(double kontostand) {
            this.kontostand = kontostand;
        }

        public String getIBAN() {
            return IBAN;
        }

        public void setIBAN(String IBAN) {
            this.IBAN = IBAN;
        }

        public Konto(Kunde kunde) {
            this.kunde = kunde;
            kunde.addKonto(this);
        }

    }

    // Assotiationen
    private Bankautomat bankautomat;
    private ArrayList<Konto> kontoListe = new ArrayList<>();
    private ArrayList<Kunde> kundeListe = new ArrayList<>();


    private String name = "";
    private ArrayList<ÜberweisungsAuftrag> überweisungsAuftragsListe = new ArrayList<>();

    // Controller BankAutomat
    public Bankautomat getBankautomat() {
        return bankautomat;
    }

    public void setBankautomat(Bankautomat bankautomat) {
        this.bankautomat = bankautomat;
        this.bankautomat.setBank(this);
    }

    // Controller Konto
    public ArrayList<Konto> getKontoListe() {
        return kontoListe;
    }

    public void setKontoListe(ArrayList<Konto> kontoListe) {
        this.kontoListe = kontoListe;
    }

    public void kontoErstellen(Kunde kunde) {
        Konto konto = new Konto(kunde);
        kontoListe.add(konto);
    }

    public void kontoKontostand() {

    }

    // Controller Kunde
    public ArrayList<Kunde> getKundeListe() {
        return kundeListe;
    }

    public void setKundeListe(ArrayList<Kunde> kundeListe) {
        this.kundeListe = kundeListe;

    }

    public void addKunde(Kunde kunde) {
        kundeListe.add(kunde);
        kunde.addBank(this);
    }

    public void removeKunde(Kunde kunde) {
        kundeListe.remove(kunde);
        kunde.removeBank(this);
    }

    // Getter/Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ÜberweisungsAuftrag> getÜberweisungsAuftragsListe() {
        return überweisungsAuftragsListe;
    }

    public void setÜberweisungsAuftragsListe(ArrayList<ÜberweisungsAuftrag> überweisungsAuftragsListe) {
        this.überweisungsAuftragsListe = überweisungsAuftragsListe;
    }

    public void addÜberweisungsAuftrag(ÜberweisungsAuftrag überweisungsAuftrag) {
        überweisungsAuftragsListe.add(überweisungsAuftrag);
    }

    public Bank() {

    }

    public Bank(Bankautomat bankautomat) {
        this.bankautomat = bankautomat;
        this.bankautomat.setBank(this);
    }

    // Methoden der Bank
    public void transferieren(Konto von_Konto, Konto auf_Konto, double betrag) {
        von_Konto.setKontostand(von_Konto.getKontostand() - betrag);
        auf_Konto.setKontostand(von_Konto.getKontostand() + betrag);
    }

    public void überweisungsAuftragAnnehmen(ÜberweisungsAuftrag überweisungsAuftrag) {
        addÜberweisungsAuftrag(überweisungsAuftrag);
    }

    public void überweisungsAuftragAusführen() {
        for (ÜberweisungsAuftrag überweisungsAuftrag : überweisungsAuftragsListe) {

        }
    }
}
