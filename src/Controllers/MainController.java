package Controllers;

import Models.MainModel;
import Schemat.Dyrektor;
import Schemat.Handlowiec;
import Schemat.Pracownik;
import Views.MainView;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.*;

public class MainController
{
    static MainView view = new MainView();
    static MainModel model = new MainModel();
    public static void main(String[] args)
    {
        Scanner myScan = new Scanner(System.in);
        int choice;
        do
        {
            view.printMenu();
            choice = myScan.nextInt();

            switch (choice)
            {
                case 1:
                    try
                    {
                        ArrayList<Pracownik> Pracownicy = model.getPracownicy();
                        if(Pracownicy.isEmpty())
                        {
                            throw new NullPointerException();
                        }
                        for(Pracownik p : Pracownicy)
                        {
                            if(p instanceof Dyrektor)
                                view.Wyswietl((Dyrektor) p);
                            else
                                view.Wyswietl((Handlowiec) p);
                            System.out.println("[Enter] - następny");
                            System.out.println("[Q] - Powrót");

                            String input = myScan.nextLine();
                            input = myScan.nextLine();
                            if (!input.isEmpty())
                            {
                                break;
                            }

                        }
                    } catch (NullPointerException e)
                    {
                        System.err.println(e.getMessage() + " Nie ma pracowników");
                    }

                    break;
                case 2:

                    try
                    {
                        System.out.println("[D]yrektor/[H]andlowiec:    ");
                        String znak = myScan.next();
                        String stanowisko = (znak.toLowerCase().equals("d")) ? "dyrektor" : "handlowiec";

                        System.out.println("Identyfikator PESEL    :    ");

                        String pesel = myScan.next();

                        System.out.println("Imie    : ");
                        String imie = myScan.next();
                        System.out.println("Nazwisko    :   ");
                        String nazwisko = myScan.next();
                        System.out.println("Wynagrodzenie (zł)    :    ");
                        String pensja = myScan.next();
                        System.out.println("Telefon służbowy numer   :    ");
                        String telefon = myScan.next();


                        if (stanowisko.equals("dyrektor"))
                        {
                            System.out.println("Dodatek służbowy (zł)    :    ");
                            String Dodatek = myScan.next();
                            System.out.println("Karta  służbowa numer     :    ");
                            String karta = myScan.next();
                            System.out.println("Limit kosztów/miesiąc (zł)     :    ");
                            String limit = myScan.next();
                            if(model.FindPracownik(pesel) != null || (model.Walidacja(pesel) != true))
                            {
                                throw new IllegalArgumentException();
                            }
                            else
                            {
                                model.CreateDyrektor(imie, nazwisko, pensja, pesel, stanowisko, telefon,Dodatek,limit,karta);
                            }
                        }
                        else
                        {
                            System.out.println("Prowizja (%)    :    ");
                            String Prowizja = myScan.next();
                            System.out.println("Limit prowizji/miesiąc (zł)    :   ");
                            String limit = myScan.next();
                            if(model.FindPracownik(pesel) != null || (model.Walidacja(pesel) != true))
                            {
                                throw new IllegalArgumentException();
                            }
                            else
                            {
                                model.CreateHandlowiec(imie,nazwisko,pensja,pesel,stanowisko,telefon,limit,Prowizja);
                            }
                        }


                    }
                    catch (NullPointerException e)
                    {
                        System.err.println(e.getMessage() + " Nie ma pracowników");
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.err.println(e.getMessage() + " Nie ma podanego pracownika");
                    }

                    break;
                case 3:
                    try
                    {
                        System.out.println("Identyfikator PESEL    :    ");

                        String pesel = myScan.next();
                        Pracownik p = model.FindPracownik(pesel);
                        if(p == null)
                            throw new NullPointerException();
                        if(p instanceof Dyrektor)
                            view.Wyswietl((Dyrektor) p);
                        else
                            view.Wyswietl((Handlowiec) p);
                        System.out.println("[Enter] - Potwierdź");
                        System.out.println("[Q] - Powrót");
                        String input = myScan.nextLine();
                        input = myScan.nextLine();
                        if (input.isEmpty())
                        {
                            model.Usunpracownika(p);
                        }
                    } catch (NullPointerException e)
                    {
                        throw new RuntimeException(e);
                    }

                    break;
                case 4:

                    System.out.println("[Z]achowaj/[O]dtwórz    :    ");

                    String znak = myScan.next();
                    System.out.println("------------------------------");

                    if(znak.toLowerCase().equals("z"))
                    {
                        FileOutputStream doZapisu = null;
                        ZipOutputStream doZipu = null;
                        ObjectOutputStream doSerializacji = null;
                        GZIPOutputStream doGzipu = null;

                        try {

                            ArrayList<Pracownik> pracownicy = model.getPracownicy();

                            if(pracownicy.isEmpty())
                            {
                                throw new NullPointerException();
                            }

                            System.out.println("Nazwa pliku    :    ");
                            String nazwaPliku = myScan.nextLine();
                            nazwaPliku = myScan.nextLine();


                            System.out.println("[Enter] - Potwierdź");
                            System.out.println("[Q] - Powrót");
                            String input = myScan.nextLine();
                            input = myScan.nextLine();
                            if (!input.isEmpty())
                            {
                                break;
                            }





                            if(nazwaPliku.endsWith("gzip"))
                            {
                                doZapisu = new FileOutputStream(nazwaPliku);
                                doGzipu = new GZIPOutputStream(doZapisu);
                               nazwaPliku = nazwaPliku.replace("gzip","ser");

                                doSerializacji = new ObjectOutputStream(doGzipu);
                                doSerializacji.writeObject(pracownicy);
                            }
                            else
                            {
                                doZapisu = new FileOutputStream(nazwaPliku);
                                doZipu = new ZipOutputStream(doZapisu);

                                nazwaPliku =  nazwaPliku.replace("zip","ser");

                                doZipu.putNextEntry(new ZipEntry( nazwaPliku));
                                doSerializacji = new ObjectOutputStream(doZipu);
                                doSerializacji.writeObject(pracownicy);
                                doZipu.closeEntry();

                            }




                        } catch (IOException e) {
                            System.err.println("Wystąpił błąd podczas zapisu: " + e.getMessage());
                            e.printStackTrace();
                        }
                        catch (NullPointerException e)
                        {
                            System.err.println(e.getMessage() + "Nie ma  pracowników");
                        }
                        finally {
                            try {
                                if (doSerializacji != null) doSerializacji.close();
                                if (doZipu != null) doZipu.close();
                                if (doZapisu != null) doZapisu.close();
                            } catch (IOException e) {
                                System.err.println("Wystąpił błąd podczas zamykania strumieni: " + e.getMessage());
                            }
                        }

                    }
                    else
                    {
                        FileInputStream doOdczytu = null;
                        ZipInputStream zZipu = null;
                        GZIPInputStream zGzipu = null;
                        ObjectInputStream poDeserializacji = null;
                        ArrayList<Pracownik> pracownicy = null;

                        try {

                            System.out.println("Nazwa pliku    :    ");

                            String nazwaPliku = myScan.nextLine();
                            nazwaPliku = myScan.nextLine();


                            System.out.println("[Enter] - Potwierdź");
                            System.out.println("[Q] - Powrót");
                            String input = myScan.nextLine();
                            input = myScan.nextLine();
                            if (!input.isEmpty())
                            {
                                break;
                            }



                            // Obsługa pliku ZIP
                            if (nazwaPliku.endsWith("zip")) {
                                doOdczytu = new FileInputStream(nazwaPliku);
                                zZipu = new ZipInputStream(doOdczytu);
                                ZipEntry entry = zZipu.getNextEntry();
                                if (entry != null) {
                                    nazwaPliku = entry.getName().replace("ser", "");

                                    // Deserializacja obiektów z ZIP
                                    poDeserializacji = new ObjectInputStream(zZipu);
                                    pracownicy = (ArrayList<Pracownik>) poDeserializacji.readObject();
                                    zZipu.closeEntry();
                                }
                            }
                            // Obsługa pliku GZIP
                            else if (nazwaPliku.endsWith("gzip")) {
                                doOdczytu = new FileInputStream(nazwaPliku);
                                zGzipu = new GZIPInputStream(doOdczytu);

                                // Deserializacja obiektów z GZIP
                                poDeserializacji = new ObjectInputStream(zGzipu);
                                pracownicy = (ArrayList<Pracownik>) poDeserializacji.readObject();
                            }

                           model.setPracownicy(pracownicy);


                        } catch (IOException  e) {
                            System.err.println(e.getMessage() + "Nie ma odczytu");
                        }
                        catch ( ClassNotFoundException e)
                        {
                            System.err.println(e.getMessage());
                        }

                        finally {
                            try {
                                // Zamknięcie strumieni
                                if (poDeserializacji != null) poDeserializacji.close();
                                if (zZipu != null) zZipu.close();
                                if (zGzipu != null) zGzipu.close();
                                if (doOdczytu != null) doOdczytu.close();
                            } catch (IOException e) {
                                System.err.println(e.getMessage());
                            }
                        }
                    }


                }





        }while (choice !=0);
    }
}
