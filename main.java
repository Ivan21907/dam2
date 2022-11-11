package dam2;

import java.sql.SQLException;
import java.util.Scanner;

public class main
{

    public static void menu1()
    {
        System.out.println("\n 1.Gestionar Professors");
        System.out.println("\n 2.Gestionar moduls professors");
        System.out.println("\n 3.Sortir del programa");
        System.out.println("");
        System.out.print("Ingressa l'opcio: ");
    }

    public static void menu2()
    {
        System.out.println("\n 1.Alta");
        System.out.println("\n 2.Llista");
        System.out.println("\n 3.Actualitzar");
        System.out.println("\n 4.Eliminar");
        System.out.println("\n 5.Tornar al menu principal");
        System.out.println("");
        System.out.print("Ingressa l'opció: ");
    }

    public static void afegirProfessor()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix el nom del professor: ");
        String nomProfe = sc.nextLine();

        System.out.println("Introdueix els cognoms del professor: ");
        String cognomsProfe = sc.nextLine();

        Professor profe = new Professor(nomProfe, cognomsProfe);

        try
        {
            profe.addDam2();
            System.out.println("Professor afegit correctament");

        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void eliminarProfessor()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix l'id del professor: ");
        int idProfe = sc.nextInt();

        Professor profe = new Professor(idProfe);

        try
        {
            profe.deleteDam2();
            System.out.println("Professor eliminat correctament");
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String [] arg)
    {

        Scanner read = new Scanner(System.in);

        read = new Scanner (System.in);
        int opcio= 0;

        do
        {
            menu1();
            opcio = read.nextInt();

            switch (opcio)
            {
                case 1:
                    int gestionarprofessors = 0;
                    System.out.println("Gesio de Professors");
                    do
                    {
                        menu2();
                        gestionarprofessors = read.nextInt();
                        switch (gestionarprofessors)
                        {
                            case 1:
                                afegirProfessor();
                                break;

                            case 2:
                                System.out.println("Selecciono Actualitzar");

                                break;

                            case 3: System.out.println("Selecciono Actualitzar");

                                break;

                            case 4:
                                eliminarProfessor();
                                break;

                                case 5:
                                    System.out.println("Tornem al menú principal.");
                                break;
                        }

                    }while (gestionarprofessors != 5);
                    break;

                case 2:
                    int gestionar_moduls_professors = 0;

                    System.out.println("Gesio de moduls professors");

                    do
                    {
                        menu2();
                        gestionar_moduls_professors = read.nextInt();

                        switch (gestionar_moduls_professors)
                        {
                            case 1: System.out.println("Selecciono Alta");

                            break;
                            case 2: System.out.println("Selecciono Llista");

                            break;
                            case 3: System.out.println("Selecciono Actualitzar");

                            break ;
                            case 4: System.out.println("Selecciono Eliminar.");

                            break;

                            case 5: System.out.println("Tornem al menu principal.");
                            break;

                            default: System.err.println("Opció incorrecta.");
                            break;
                        }
                    }while (gestionar_moduls_professors != 5);

                case 3:
                    System.out.println("Has sortit del programa. Adeu!");
                    break;

                default:
                    System.err.println("Opcio incorrecta");
                    break;
            }
        }while (opcio != 3);
    }
}

