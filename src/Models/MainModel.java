package Models;

import Schemat.Pracownik;

import java.util.ArrayList;

public class MainModel
{
    private ArrayList<Pracownik> Pracownicy = new ArrayList<>();

    public ArrayList<Pracownik> getPracownicy()
    {
        return Pracownicy;
    }

    public void addPracownik(Pracownik pracownik)
    {
        Pracownicy.add(pracownik);
    }


    public void FindPracownik(String x)
    {
        int i =0;
        Pracownik tmp = Pracownicy.get(i);
       for(Pracownik p : Pracownicy)
       {
           if(x == p.getPesel())
           {
               break;
           }
       }
    }
}
