import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sala[] salas = { new Sala(1), new Sala(2), new Sala(3) };

        int opcion;
        do {
            System.out.println(" Cinema Paradiso");
            System.out.println("1. Mostrar disponibilidad");
            System.out.println("2. Comprar asientos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    for (Sala sala : salas) {
                        sala.mostrarDisponibilidad();
                    }
                    break;
                case 2:
                    System.out.print("Ingrese número de sala: ");
                    int numSala = sc.nextInt();
                    if (numSala < 1 || numSala > 3) {
                        System.out.println("Sala inválida.");
                        break;
                    }

                    System.out.print("Seleccione el numero de asientos que dese comprar: ");
                    int cantidad = sc.nextInt();
                    salas[numSala - 1].comprarAsientos(cantidad);
                    break;
                case 3:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 3);

        sc.close();
    }
}
