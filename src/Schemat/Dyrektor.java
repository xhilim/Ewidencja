package Schemat;

public class Dyrektor extends Pracownik
{
    private int numerKarty;
    private int dodatekSluzbowy;
    private int limitKosztow;

    public int getNumerKarty()
    {
        return numerKarty;
    }

    public void setNumerKarty(int numerKarty)
    {
        this.numerKarty = numerKarty;
    }

    public int getDodatekSluzbowy()
    {
        return dodatekSluzbowy;
    }

    public void setDodatekSluzbowy(int dodatekSluzbowy)
    {
        this.dodatekSluzbowy = dodatekSluzbowy;
    }

    public int getLimitKosztow()
    {
        return limitKosztow;
    }

    public void setLimitKosztow(int limitKosztow)
    {
        this.limitKosztow = limitKosztow;
    }
}
