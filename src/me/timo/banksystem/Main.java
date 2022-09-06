package me.timo.banksystem;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("Sparkasse");
        Bankautomat bankautomat = new Bankautomat(bank);

        Kunde kunde1 = new Kunde(bank, "Kunde1", 27);
        Bank.Konto konto1 = bank.kontoErstellen(kunde1);

        Kunde kunde2 = new Kunde(bank, "Kunde2", 18);
        Bank.Konto konto2 = bank.kontoErstellen(kunde2);

        //Bank.Konto konto1 = kunde1.getKontoListe().get(0);
        //Bank.Konto konto2 = kunde2.getKontoListe().get(0);
        konto1.setKontostand(100);
        System.out.println("Konto 1: " + konto1.getKontostand());
        System.out.println("Konto 2: " + konto2.getKontostand());

        System.out.println("Überweisung wird ausgefüllt");
        kunde1.überweisungsAuftragAusfüllen(10, konto1.getIBAN(), konto2.getIBAN());
        System.out.println("Überweisung wird eingereicht");
        kunde1.alleÜberweisungsAufträgEinreichen(bank);
        System.out.println("Überweisungen werden ausgeführt");
        bank.überweisungsAuftragAusführen();

        System.out.println("Konto 1: " + konto1.getKontostand());
        System.out.println("Konto 2: " + konto2.getKontostand());

        System.out.println("Kunde 1 Bargeld: " + kunde1.getBargeld());
        System.out.println("Am Bankautomaten Geld abheben");
        bankautomat.abheben(50, konto1.getIBAN());

        System.out.println("Konto 1: " + konto1.getKontostand());
        System.out.println("Kunde 1 Bargeld: " + kunde1.getBargeld());

        System.out.println("Am Bankautomaten Geld einzahlen");
        bankautomat.einzahlen(30, konto1.getIBAN());
        System.out.println("Konto 1: " + konto1.getKontostand());
        System.out.println("Kunde 1 Bargeld: " + kunde1.getBargeld());
    }
}
