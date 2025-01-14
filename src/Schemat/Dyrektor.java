package Schemat;

import java.io.Serializable;

public class Dyrektor extends Pracownik implements Serializable
{
    private String numerKarty;
    private String dodatekSluzbowy;
    private String limitKosztow;

    public Dyrektor(String imie, String nazwisko, String pensja, String pesel, String stanowisko, String telefon, String dodatekSluzbowy, String numerKarty, String limitKosztow)
    {
        super(imie, nazwisko, pensja, pesel, stanowisko, telefon);
        this.dodatekSluzbowy = dodatekSluzbowy;
        this.limitKosztow = limitKosztow;
        this.numerKarty = numerKarty;
    }

    public String getNumerKarty()
    {
        return numerKarty;
    }

    public void setNumerKarty(String numerKarty)
    {
        this.numerKarty = numerKarty;
    }

    public String getDodatekSluzbowy()
    {
        return dodatekSluzbowy;
    }

    public void setDodatekSluzbowy(String dodatekSluzbowy)
    {
        this.dodatekSluzbowy = dodatekSluzbowy;
    }

    public String getLimitKosztow()
    {
        return limitKosztow;
    }

    public void setLimitKosztow(String limitKosztow)
    {
        this.limitKosztow = limitKosztow;
    }
}
