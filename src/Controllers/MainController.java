package Controllers;

import Views.MainView;
import java.util.Scanner;

public class MainController
{
    static MainView view = new MainView();
    public static void main(String[] args)
    {
        Scanner myscan = new Scanner(System.in);
        int choice = 0;
        do
        {
            view.printMenu();
            choice = myscan.nextInt();

            switch (choice)
            {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;

            }
        }while (choice !=0);
    }
}
