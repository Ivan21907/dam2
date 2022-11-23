package dam2;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Scanner;

public class main
{

    /**
     * Funcio que mostra el menu principal
     */
    public static void menu1()
    {
        System.out.println("\n 1.Gestionar Professors");
        System.out.println("\n 2.Gestionar moduls professors");
        System.out.println("\n 3.Gestionar Alumnes (Base de dades en PostreSQL)");
        System.out.println("\n 4.Sortir del programa");
        System.out.println("");
        System.out.print("Ingressa l'opcio: ");
    }

    /**
     * Funcio que mostra el menu de professors i moduls
     */
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

    /**
     * Funcio que afegeix un professor a la base de dades creant un objecte de la classe Professor
     */
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

    /**
     * Funcio que mostra tots els professors de la base de dades
     */
    public static void llistarProfessors()
    {
        Professor profe = new Professor("", "");

        profe.readDam2();
    }

    /**
     * Funcio que modifica un professor de la base de dades a partir de l'id del professor
     */
    public static void actualitzarProfessor()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix l'id del professor a actualitzar: ");
        int idProfe = sc.nextInt();

        sc.nextLine();

        System.out.println("Introdueix el nom del professor: ");
        String nomProfe = sc.nextLine();

        System.out.println("Introdueix els cognoms del professor: ");
        String cognomsProfe = sc.nextLine();

        Professor profe = new Professor(idProfe, nomProfe, cognomsProfe);

        try
        {
            profe.updateDam2();
            System.out.println("Professor actualitzat correctament");

        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Funcio que elimina un professor de la base de dades a partir de l'id del professor
     */
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

    /**
     * Funcio que afegeix un modul a la base de dades creant un objecte de la classe Modul
     */
    public static void afegirModul()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix el nom del modul professional: ");
        String nomModul = sc.nextLine();

        System.out.println("Introdueix l'id del professor: ");
        int idProfe = sc.nextInt();

        ModulProfessional modul = new ModulProfessional(nomModul, idProfe);

        try
        {
            modul.addDam2();
            System.out.println("Modul afegit correctament");

        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Funcio que mostra tots els moduls de la base de dades
     */
    public static void llistarModuls()
    {
        ModulProfessional modul = new ModulProfessional("");

        modul.readDam2();
    }

    /**
     * Funcio que modifica un modul de la base de dades a partir de l'id del modul
     */
    public static void actualitzarModul()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix l'id del modul a actualitzar: ");
        int idModul = sc.nextInt();

        sc.nextLine();
        System.out.println("Introdueix el nom del modul: ");
        String nomModul = sc.nextLine();

        System.out.println("Introdueix l'id del professor: ");
        int idProfe = sc.nextInt();

        ModulProfessional modul = new ModulProfessional(idModul, nomModul, idProfe);

        try
        {
            modul.updateDam2();
            System.out.println("Modul actualitzat correctament");

        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Funcio que elimina un modul de la base de dades a partir de l'id del modul
     */
    public static void eliminarModul()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix l'id del modul a eliminar: ");
        int idModul = sc.nextInt();

        ModulProfessional modul = new ModulProfessional(idModul);

        try
        {
            modul.deleteDam2();
            System.out.println("Modul eliminat correctament");
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Funcio que afegeix un alumne a la base de dades creant un objecte de la classe Alumne
     */
    public static void afegirAlumne()
    {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix el nom de l'alumne: ");
        String nomAlumne = sc.nextLine();

        System.out.println("Introdueix els cognoms de l'alumne: ");
        String cognomsAlumne = sc.nextLine();

        System.out.println("Introdueix la data de naixement l'alumne (YYYY-MM-DD): ");
        String data_text = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        Date dataNaixement = Date.valueOf(data_text);

        System.out.println("Introdueix el curs de l'alumne: ");
        String curs = sc.nextLine();

        System.out.println("Introdueix el projenitor de l'alumne: ");
        String projenitor = sc.nextLine();

        System.out.println("Vols afegir un nou projenitor? (S/N)");
        String lletra = sc.nextLine();

        /*Donem l'opcio a l'usuari de dir si te un altre projenitor o no
        Si te un altre projenitor, li demanem que introdueixi el nom del 2n projenitor
         */
        if(lletra.equalsIgnoreCase("S"))
        {
            System.out.println("Introdueix el nou projenitor: ");
            String nouProjenitor = sc.nextLine();

            String [] projenitors = {projenitor, nouProjenitor};
            Alumne alumne = new Alumne(nomAlumne, cognomsAlumne, dataNaixement, curs, projenitors);

            try
            {
                alumne.addDam2();
                System.out.println("Alumne afegit correctament");
            }
            catch (Exception e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
        else
        {
            String [] projenitors = {projenitor};
            Alumne alumne = new Alumne(nomAlumne, cognomsAlumne, dataNaixement, curs, projenitors);
            try
            {
                alumne.addDam2();
                System.out.println("Alumne afegit correctament");
            }
            catch (Exception e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    /**
     * Funcio que mostra tots els alumnes de la base de dades
     */
    public static void llegirAlumne()
    {

        Alumne alumne = new Alumne("", "");

        try
        {
            alumne.readDam2();
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Funcio que modifica un alumne de la base de dades a partir d'un id de l'alumne
     */
    public static void actualitzarAlumne()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix l'id de l'alumne a actualitzar: ");
        int idAlumne = sc.nextInt();

        sc.nextLine();
        System.out.println("Introdueix el nom de l'alumne: ");
        String nomAlumne = sc.nextLine();

        System.out.println("Introdueix els cognoms de l'alumne: ");
        String cognomsAlumne = sc.nextLine();

        System.out.println("Introdueix la data de naixement l'alumne (YYYY-MM-DD): ");
        String data_text = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        Date dataNaixement = Date.valueOf(data_text);

        System.out.println("Introdueix el curs de l'alumne: ");
        String curs = sc.nextLine();

        System.out.println("Introdueix el projenitor de l'alumne: ");
        String projenitor = sc.nextLine();

        System.out.println("Vols afegir un nou projenitor? (S/N)");
        String lletra = sc.nextLine();

         /*Donem l'opcio a l'usuari de dir si te un altre projenitor o no
        Si te un altre projenitor, li demanem que introdueixi el nom del 2n projenitor
         */
        if(lletra.equalsIgnoreCase("S"))
        {
            System.out.println("Introdueix el nou projenitor: ");
            String nouProjenitor = sc.nextLine();
            String [] projenitors = {projenitor, nouProjenitor};
            Alumne alumne = new Alumne(idAlumne, nomAlumne, cognomsAlumne, dataNaixement, curs, projenitors);
            try
            {
                alumne.updateDam2();
                System.out.println("Alumne actualitzat correctament");
            }
            catch (Exception e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
        else
        {
            String [] projenitors = {projenitor};
            Alumne alumne = new Alumne(idAlumne, nomAlumne, cognomsAlumne, dataNaixement, curs, projenitors);
            try
            {
                alumne.updateDam2();
                System.out.println("Alumne actualitzat correctament");
            }
            catch (Exception e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }

    /**
     * Funcio que elimina un alumne de la base de dades a partir d'un id de l'alumne
     */
    public static void eliminarAlumne()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix l'id de l'alumne a eliminar: ");
        int idAlumne = sc.nextInt();

        Alumne alumne = new Alumne(idAlumne);

        try
        {
            alumne.deleteDam2();
            System.out.println("Alumne eliminat correctament");
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Programa principal
    public static void main(String [] arg) throws ParseException {

        Scanner read = new Scanner(System.in);

        read = new Scanner (System.in);
        int opcio= 0;

        //bucle perque el programa no acabi fins que s'entra l'opcio 3 del menu principal
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

                        //2n bucle perque el programa no acabi fins que s'entra l'opcio 5 del 2n menu
                        switch (gestionarprofessors)
                        {
                            case 1:
                                afegirProfessor();
                                break;

                            case 2:
                                llistarProfessors();
                                break;

                            case 3:
                                actualitzarProfessor();
                                break;

                            case 4:
                                eliminarProfessor();
                                break;

                                case 5:
                                    System.out.println("Tornem al menú principal.");
                                break;

                                default:
                                    System.err.println("Opció incorrecta");
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
                            case 1:
                                afegirModul();
                                break;

                            case 2:
                                llistarModuls();
                                break;

                            case 3:
                                actualitzarModul();
                                break;

                            case 4:
                                eliminarModul();
                                break;

                            case 5: System.out.println("Tornem al menu principal.");
                                break;

                            default: System.err.println("Opció incorrecta.");
                                break;
                        }

                    }while (gestionar_moduls_professors != 5);
                    break;

                case 3:
                    int gestioAlumnes = 0;
                    System.out.println("Gesio d'alumnes");
                    do
                    {
                        menu2();
                        gestioAlumnes = read.nextInt();

                        //3r bucle perque el programa no acabi fins que s'entra l'opcio 5 del 2n menu
                        switch (gestioAlumnes)
                        {
                            case 1:
                                afegirAlumne();
                                break;

                            case 2:
                                llegirAlumne();
                                break;

                            case 3:
                                actualitzarAlumne();
                                break;

                            case 4:
                                eliminarAlumne();
                                break;

                            case 5:
                                System.out.println("Tornem al menú principal.");
                                break;

                            default:
                                System.err.println("Opció incorrecta");
                                break;
                        }

                    }while (gestioAlumnes != 5);

                    break;

                case 4:
                    System.out.println("Has sortit del programa. Adeu!");
                    break;

                default:
                    System.err.println("Opcio incorrecta");
                    break;
            }
        }while (opcio != 4);
    }
}

