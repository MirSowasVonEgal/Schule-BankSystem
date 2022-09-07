package me.timo.banksystem;

public class Bankautomat {

    // Beziehung
    private Bank bank;

    // Controller Bank
    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    // Konstruktoren
    public Bankautomat() {

    }

    public Bankautomat(Bank bank) {
        this.bank = bank;
        this.bank.setBankautomat(this);
    }

    // Methoden des Bankautomats
    public void abheben(double betrag, String IBAN) {
        Bank.Konto konto = bank.getKontoByIBAN(IBAN);
        if(konto == null) return;
        konto.setKontostand(konto.getKontostand() - betrag);
        Kunde kunde = konto.getKunde();
        kunde.setBargeld(kunde.getBargeld() + betrag);
    }

    public void einzahlen(double betrag, String IBAN) {
        Bank.Konto konto = bank.getKontoByIBAN(IBAN);
        if(konto == null) return;
        Kunde kunde = konto.getKunde();
        if(kunde.getBargeld() < betrag) return;
        kunde.setBargeld(kunde.getBargeld() - betrag);
        konto.setKontostand(konto.getKontostand() + betrag);
    }

    public double kontostandAnzeigen(String IBAN) {
        Bank.Konto konto = bank.getKontoByIBAN(IBAN);
        if(konto == null) return 0;
        return konto.getKontostand();
    }

}
