package Models;

import Schemat.Dyrektor;
import Schemat.Handlowiec;
import Schemat.Pracownik;

import java.util.ArrayList;

public class MainModel
{
    private ArrayList<Pracownik> Pracownicy = new ArrayList<>();

    public ArrayList<Pracownik> getPracownicy()
    {
        return Pracownicy;
    }

    public void setPracownicy(ArrayList<Pracownik> pracownicy)
    {
        Pracownicy = pracownicy;
    }

    public void CreateHandlowiec(String imie, String nazwisko, String pensja, String pesel, String stanowisko, String telefon, String limitProwizji, String prowizja)
    {
        Handlowiec newHandlowiec = new Handlowiec( imie,  nazwisko,  pensja,  pesel,  stanowisko,  telefon,  limitProwizji,  prowizja);
        Pracownicy.add(newHandlowiec);
    }

    public void CreateDyrektor(String imie, String nazwisko, String pensja, String pesel, String stanowisko, String telefon, String dodatekSluzbowy, String limitKosztow, String numerKarty)
    {
        Dyrektor newDyrektor = new Dyrektor( imie,  nazwisko,  pensja,  pesel,  stanowisko,  telefon,  dodatekSluzbowy,  limitKosztow,  numerKarty);
        Pracownicy.add(newDyrektor);
    }

    public Pracownik FindPracownik(String x)
    {

        for (Pracownik p : Pracownicy)
        {
            if (x == p.getPesel())
            {
                return p;
            }
        }

        return null;

    }

    public boolean Walidacja(String pesel)
    {

        try
        {
            if(pesel != null && pesel.length() ==11)
            {

                int[] p = new int[pesel.length()];

                for(int i = 0; i < pesel.length(); i++)
                {
                    p[i] = pesel.charAt(i);
                }

                if(( p[ 0 ] + 3*p[ 1 ] + 7*p[ 2 ] + 9*p[ 3 ] + p[ 4 ] + 3*p[ 5 ] +7*p[ 6 ] + 9*p[ 7 ] + p[ 8 ] + 3*p[ 9 ] + p[ 10 ] ) % 10 == 0)
                {
                    System.out.println("aass");
                    return true;
                }
                else
                    return false;
            }
            else
            {
                throw new NullPointerException();
            }
        } catch (NullPointerException e)
        {
            System.err.println(e.getClass().getName() + "Nie podano numeru PESEL lub nieodpowiednia liczba znaków");
            return false;
        }


    }

    public void Usunpracownika(Pracownik p)
    {
        Pracownicy.remove(p);
    }
}
