package buscaminas;

import java.util.Scanner;

public class Game {
    // Tabla sin respuestas
    public static void main(String[] args) {

        // Crea objeto para llamar a la clase Funciones
        Funciones game = new Funciones();

        // Creación de escáner para leer datos
        Scanner key = new Scanner(System.in);

        // Variable que contiene la posición elegida por el usuario
        int posicionUsuario;

        // Variable que contiene el número de intentos del usuario
        int intentos = 0;

        // Comprueba si el queremos visualizar la respuesta
        if (game.CHEAT) {
            // Muestra el tablero con las respuestas
            game.muestraTablero(game.TABLERO_RESPUESTA);
        }

        while (intentos < (game.TAMTABLERO - game.NUMERO_MINAS)) {
            // Variable que contiene el número de intentos del usuario
            do {
                System.out.println("Deme una posición del tablero: ");
                // Pide posición al usuario
                posicionUsuario = key.nextInt();
                // Si la posición dada por el usuario está fuera del tablero la vuelve a pedir
            } while (posicionUsuario < 0 || posicionUsuario > game.TAMTABLERO);
            // Después de dar la condición suma 1 al número de intentos
            intentos++;

            game.muestraTablero(game.tableroPrincipal);

        }

    }
}
