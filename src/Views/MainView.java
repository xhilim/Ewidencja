package Views;

import Schemat.Handlowiec;
import Schemat.Dyrektor;
import Schemat.Pracownik;

public class MainView
{
    public void printMenu()
    {
        System.out.println("MENU\n" +
                "1. Lista pracowników\n" +
                "2. Dodaj pracownika\n" +
                "3. Usuń pracownika\n" +
                "4. Kopia zapasowa\n" +
                "Wybór>");
    }

    public void Wyswietl(Handlowiec p)
    {
        System.out.println("----------------------------");
        System.out.println("Identyfikator PESEL     :   " + p.getPesel()
                +"\nImię    :   " + p.getImie()
                +"\nNazwisko    :   " + p.getStanowisko()
                +"\nWynagrodzenie :    " + p.getPensja()
                +"\nTelefon służbowy numer  :   " + p.getTelefon()
                +"\nProwizja (%)   :  "  + p.getProwizja());
        System.out.println("----------------------------");

    }

    public void Wyswietl(Dyrektor p)
    {
        System.out.println("----------------------------");
        System.out.println("Identyfikator PESEL     :   " + p.getPesel()
                +"\nImię    :   " + p.getImie()
                +"\nNazwisko    :   " + p.getStanowisko()
                +"\nWynagrodzenie :    " + p.getPensja()
                +"\nTelefon służbowy numer  :   " + p.getTelefon()
                +"\nDodatek służbowy (zł)   :  "  + p.getDodatekSluzbowy()
                +"\nKarta służbowa numer    :    " + p.getNumerKarty()
                +"\nLimit kosztów/miesiąc (zł)    :    " + p.getLimitKosztow());
        System.out.println("----------------------------");

    }



}
