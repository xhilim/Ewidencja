package Schemat;

import java.io.Serializable;

public class Handlowiec extends Pracownik implements Serializable
{

    private String prowizja;
    private String limitProwizji;

    public Handlowiec(String imie, String nazwisko, String pensja, String pesel, String stanowisko, String telefon, String limitProwizji, String prowizja)
    {
        super(imie, nazwisko, pensja, pesel, stanowisko, telefon);
        this.limitProwizji = limitProwizji;
        this.prowizja = prowizja;
    }


    public String getProwizja()
    {
        return prowizja;
    }

    public void setProwizja(String prowizja)
    {
        this.prowizja = prowizja;
    }

    public String getLimitProwizji()
    {
        return limitProwizji;
    }

    public void setLimitProwizji(String limitProwizji)
    {
        this.limitProwizji = limitProwizji;
    }


}
