package me.timo.banksystem;

public class Bankautomat {

    private Bank bank;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Bankautomat() {

    }

    public Bankautomat(Bank bank) {
        this.bank = bank;
        this.bank.setBankautomat(this);
    }

    public void abheben(double betrag, String IBAN) {

    }

    public void einzahlen(double betrag, String IBAN) {

    }

}
