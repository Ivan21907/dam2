public class main {
    public static void main(String [] arg){
        Scanner sn = new Scanner(System.in);
        boolean sortir = false;
        int opcio; //Guardaremos la opcion del usuario

        while (!sortir) {

            System.out.println("1. ");
            System.out.println("2. ");
            System.out.println("3. ");

            try {

                System.out.println("Escriu una de les seguents opcions: ");
                opcio = sn.nextInt();

                switch (opcio) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
}
