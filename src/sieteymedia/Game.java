package sieteymedia;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        // Objeto para llamar a la clase funciones
        Funciones game = new Funciones();

        // Creación de escáner para leer datos
        Scanner key = new Scanner(System.in);

        do {
            // Pide tirada al usuario
            System.out.println("¿Quieres sacar una carta (s/n)? ");
            game.tirada = key.nextLine();

        // Se ejecuta
        } while (game.tirada.equals("s"));



    }
}
