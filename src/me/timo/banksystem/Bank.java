package me.timo.banksystem;

import java.util.ArrayList;
import java.util.UUID;

public class Bank {

    public class Konto {

        // Attribute
        private double kontostand = 0;
        private String IBAN = "";

        // Beziehung
        private Kunde kunde;

        // Controller Kunde
        public Kunde getKunde() {
            return kunde;
        }

        public void setKunde(Kunde kunde) {
            this.kunde = kunde;
        }

        // Getter/Setter
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

        // Konstruktor
        public Konto(Kunde kunde) {
            this.IBAN = UUID.randomUUID().toString();
            this.kunde = kunde;
            this.kunde.getKontoListe().add(this);
        }

    }

    // Beziehungen
    private Bankautomat bankautomat;
    private ArrayList<Konto> kontoListe = new ArrayList<>();
    private ArrayList<Kunde> kundenListe = new ArrayList<>();

    // Attribute
    private String name = "";
    private ArrayList<ÜberweisungsAuftrag> überweisungsAuftragsListe = new ArrayList<>();

    // Controller BankAutomat
    public Bankautomat getBankautomat() {
        return bankautomat;
    }

    public void setBankautomat(Bankautomat bankautomat) {
        this.bankautomat = bankautomat;
    }

    // Controller Konto
    public ArrayList<Konto> getKontoListe() {
        return kontoListe;
    }

    public void setKontoListe(ArrayList<Konto> kontoListe) {
        this.kontoListe = kontoListe;
    }

    public Konto kontoErstellen(Kunde kunde) {
        Konto konto = new Konto(kunde);
        kontoListe.add(konto);
        kunde.addBank(this);
        return konto;
    }

    public Konto getKontoByIBAN(String IBAN) {
        for (Konto konto : getKontoListe()) {
            if(konto.getIBAN().equals(IBAN))
                return konto;
        }
        return null;
    }

    // Controller Kunde
    public ArrayList<Kunde> getKundenListe() {
        return kundenListe;
    }

    public void setKundenListe(ArrayList<Kunde> kundeListe) {
        this.kundenListe = kundeListe;

    }

    public void addKunde(Kunde kunde) {
        kundenListe.add(kunde);
        kunde.getBankListe().add(this);
    }

    public void removeKunde(Kunde kunde) {
        kundenListe.remove(kunde);
        kunde.getBankListe().remove(this);
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

    // Konstruktor
    public Bank(String name) {
        this.name = name;
    }

    public Bank(Bankautomat bankautomat) {
        this.bankautomat = bankautomat;
        this.bankautomat.setBank(this);
    }

    // Methoden der Bank
    public void transferieren(Konto von_Konto, Konto auf_Konto, double betrag) {
        von_Konto.setKontostand(von_Konto.getKontostand() - betrag);
        auf_Konto.setKontostand(auf_Konto.getKontostand() + betrag);
    }

    public void überweisungsAuftragAnnehmen(ÜberweisungsAuftrag überweisungsAuftrag) {
        addÜberweisungsAuftrag(überweisungsAuftrag);
    }

    public void überweisungsAuftragAusführen() {
        for (ÜberweisungsAuftrag überweisungsAuftrag : überweisungsAuftragsListe) {
            Konto von_Konto = getKontoByIBAN(überweisungsAuftrag.getVon_IBAN());
            Konto auf_Konto = getKontoByIBAN(überweisungsAuftrag.getAuf_IBAN());
            if(von_Konto == null || auf_Konto == null) return;
            transferieren(von_Konto, auf_Konto, überweisungsAuftrag.getBetrag());
        }
    }
}
