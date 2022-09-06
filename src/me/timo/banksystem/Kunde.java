package me.timo.banksystem;

import java.util.ArrayList;

public class Kunde {

    private ArrayList<Bank.Konto> kontoListe = new ArrayList<>();
    private ArrayList<Bank> bankListe = new ArrayList<>();
    private ArrayList<ÜberweisungsAuftrag> überweisungsAuftragListe = new ArrayList<>();
    private String name = "";
    private int alter = 0;
    private double bargeld = 0;

    // Controller Konto
    public ArrayList<Bank.Konto> getKontoListe() {
        return kontoListe;
    }

    public void setKontoListe(ArrayList<Bank.Konto> kontoListe) {
        this.kontoListe = kontoListe;
        for (Bank.Konto konto : kontoListe) {
            konto.setKunde(this);
        }
    }

    public void addKonto(Bank.Konto konto) {
        kontoListe.add(konto);
        konto.setKunde(this);
    }

    public void removeKonto(Bank.Konto konto) {
        kontoListe.remove(konto);
        konto.setKunde(null);
    }

    // Controller Bank
    public ArrayList<Bank> getBankListe() {
        return bankListe;
    }

    public void setBankListe(ArrayList<Bank> bankListe) {
        this.bankListe = bankListe;
    }

    public void addBank(Bank bank) {
        bankListe.add(bank);
    }

    public void removeBank(Bank bank) {
        bankListe.remove(bank);
    }

    // Controller ÜberweisungsAufträge
    public ArrayList<ÜberweisungsAuftrag> getÜberweisungsAuftragListe() {
        return überweisungsAuftragListe;
    }

    public void setÜberweisungsAuftragListe(ArrayList<ÜberweisungsAuftrag> überweisungsAuftragListe) {
        this.überweisungsAuftragListe = überweisungsAuftragListe;
    }

    public void addÜberweisungsAuftrag(ÜberweisungsAuftrag überweisungsAuftrag) {
        überweisungsAuftragListe.add(überweisungsAuftrag);
    }

    public void removeÜberweisungsAuftrag(ÜberweisungsAuftrag überweisungsAuftrag) {
        überweisungsAuftragListe.remove(überweisungsAuftrag);
    }

    // Getter/Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public double getBargeld() {
        return bargeld;
    }

    public void setBargeld(double bargeld) {
        this.bargeld = bargeld;
    }

    public Kunde() {

    }

    public Kunde(Bank.Konto konto) {
        kontoListe.add(konto);
        konto.setKunde(this);
    }

    public void überweisungsAuftragAusfüllen(double betrag, String von_IBAN, String auf_IBAN) {

    }

    public void überweisungsAuftragEinreichen(ÜberweisungsAuftrag überweisungsAuftrag) {

    }
}
