import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] seats = new char[10][10];
        char response = 'n', graphic = 'n';
        Scanner input = new Scanner(System.in);
        int row, column;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                seats[i][j] = 'L';
            }
        }

        do {
            clearConsole();
            welcomeMessage();

            System.out.print("¿Quieres ver un gráfico con los asientos disponibles? Presione 'S' para confirmar, de lo contrario presione cualquier otra tecla:");
            graphic = input.next().charAt(0);

            if (graphic == 's' || graphic == 'S') {
                printSeats(seats);
            }

            System.out.print("\nIngrese el número de fila (valores enteros entre 1 y 10): ");
            row = (input.nextInt() - 1);
            System.out.print("Ingrese el número de columna (valores enteros entre 1 y 10):");
            column = (input.nextInt() - 1);

            if (row > 10 || row < 0) {
                System.out.println("\nEl número de fila no es válido.");
            }

            if (column > 10 || column < 0) {
                System.out.println("\nEl número de columna no es válido.");
            }

            if (row == -1 && column == -1) {
                continue;
            }

            if (seats[row][column] == 'X') {
                System.out.println("\nEl asiento está actualmente ocupado. Por favor elige otro asiento.\n");
            } else {
                seats[row][column] = 'X';
                System.out.println("\nEl asiento ha sido reservado con éxito.\n");
            }

            System.out.print("¿Quieres elegir otro asiento?\n" + //
                    "\tS: Sí.\n" + //
                    "\tCualquier otra letra: No, ya terminé de reservar.\n" + //
                    "Respuesta: ");
            response = input.next().charAt(0);

            if (response != 'S' && response != 's') {
                row = column = -1;
            }
        } while (row != -1 || column != -1);
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void welcomeMessage() {
        System.out.println("####################################################################################################################\n");
        System.out.println("################################### Bienvenido al Sistema de Reserva de Asientos ###################################\n");
        System.out.println("####################################################################################################################\n");
    }

    public static void printSeats(char[][] seats) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("[" + seats[i][j] + "] ");
            }
            System.out.println("");
        }
    }
}
