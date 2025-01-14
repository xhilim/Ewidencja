package Schemat;

import java.io.Serializable;

abstract public class Pracownik implements Serializable
{
    protected String nazwisko;
    protected String imie;
    protected String pesel;
    protected String telefon;
    protected String pensja;
    protected String stanowisko;

    public Pracownik(String imie, String nazwisko, String pensja, String pesel, String stanowisko, String telefon)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pensja = pensja;
        this.pesel = pesel;
        this.stanowisko = stanowisko;
        this.telefon = telefon;
    }

    public String getNazwisko()
    {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko)
    {
        this.nazwisko = nazwisko;
    }

    public String getImie()
    {
        return imie;
    }

    public void setImie(String imie)
    {
        this.imie = imie;
    }

    public String getPesel()
    {
        return pesel;
    }

    public void setPesel(String pesel)
    {
        this.pesel = pesel;
    }

    public String getTelefon()
    {
        return telefon;
    }

    public void setTelefon(String telefon)
    {
        this.telefon = telefon;
    }

    public String getPensja()
    {
        return pensja;
    }

    public void setPensja(String pensja)
    {
        this.pensja = pensja;
    }

    public String getStanowisko()
    {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko)
    {
        this.stanowisko = stanowisko;
    }
}
