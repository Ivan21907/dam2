package dam2;

import java.util.Scanner;

public class main {
    public static void main(String [] arg){

        Scanner read = new Scanner(System.in);

        read = new Scanner (System.in);
        int opcio= 0;

        do {
            System.out.println("\n 1.Gestionar Professors");
            System.out.println("\n 2.Gestionar moduls professors");
            System.out.println("");
            System.out.print("Ingressa l'opcio: ");
            opcio = read.nextInt();
            switch (opcio){
                case 1:
                    int gestionarprofessors = 0;
                    do {
                        System.out.println(" Gestio Professors");
                        System.out.println(" Que realitzaras? ");
                        System.out.println("\n 1.Alta");
                        System.out.println("\n 2.Llista");
                        System.out.println("\n 3.Actualitzar");
                        System.out.println("\n 4.Eliminar");
                        gestionarprofessors = read.nextInt();
                        switch (gestionarprofessors){
                            case 1: System.out.println("Selecciono Alta");

                            break;
                            case 2: System.out.println("Selecciono Llista");

                            break;
                            case 3: System.out.println("Selecciono Actualitzar");

                            break ;
                            case 4: System.out.println("Selecciono Eliminar.");

                            break;
                        }

                    }while (gestionarprofessors<2) ;
                    break;
                case 2:
                    int gestionar_moduls_professors = 0;
                    System.out.println("Gesio de moduls de professors");
                    do {
                        System.out.println(" Que realitzaras?...");
                        System.out.println("\n 1.Alta");
                        System.out.println("\n 2.Llista");
                        System.out.println("\n 3.Actualitzar");
                        System.out.println("\n 4.Eliminar");
                        System.out.println("");
                        System.out.print("Ingressa l'opcio: ");
                        gestionar_moduls_professors = read.nextInt();
                        switch (gestionar_moduls_professors){
                            case 1: System.out.println("Selecciono Alta");

                            break;
                            case 2: System.out.println("Selecciono Llista");

                            break;
                            case 3: System.out.println("Selecciono Actualitzar");

                            break ;
                            case 4: System.out.println("Selecciono Eliminar.");

                            break;
                        }
                    }while (gestionarprofessors <2);
            }
        }while (opcio<2);
    }
    }
}
