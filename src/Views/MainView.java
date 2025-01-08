package Views;

import Schemat.Pracownik;
import Schemat.Handlowiec;
import Schemat.Dyrektor;
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

    public void HandlowiecWyswietl(Handlowiec p)
    {
        System.out.println("Identyfikator PESEL     :   " + p.getPesel()
                +"\nImię    :   " + p.getImie()
                +"\nNazwisko    :   " + p.getStanowisko()
                +"\nWynagrodzenie :    " + p.getPensja()
                +"\nTelefon służbowy numer  :   " + p.getTelefon()
                +"\nProwizja (%)   :  "  + p.getProwizja());

    }

    public void DyrektorWyswietl(Dyrektor p)
    {
        System.out.println("Identyfikator PESEL     :   " + p.getPesel()
                +"\nImię    :   " + p.getImie()
                +"\nNazwisko    :   " + p.getStanowisko()
                +"\nWynagrodzenie :    " + p.getPensja()
                +"\nTelefon służbowy numer  :   " + p.getTelefon()
                +"\nDodatek służbowy (zł)   :  "  + p.getDodatekSluzbowy()
                +"\nKarta służbowa numer    :    " + p.getNumerKarty()
                +"\nLimit kosztów/miesiąc (zł)    :    " + p.getLimitKosztow());

    }
}
