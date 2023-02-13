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

        // Variable booleana que comprueba si sigue jugando la partida
        boolean gameOver = false;

        do {
            // Comprueba si el queremos visualizar la respuesta
            if (game.CHEAT) {
                // Muestra el tablero con las respuestas
                game.muestraTablero(game.TABLERO_RESPUESTA);
            }
            // Muestra tablero al usuario
            game.muestraTablero(game.tableroPrincipal);

            // Variable que contiene el número de intentos del usuario
            do {

                System.out.println("Deme una posición del tablero: ");
                // Pide posición al usuario
                posicionUsuario = key.nextInt();

                // Si la posición dada por el usuario está fuera del tablero la vuelve a pedir
            } while (posicionUsuario < 0 || posicionUsuario > game.TAMTABLERO || game.tableroPrincipal[posicionUsuario] != '?');

            // Después de dar la condición suma 1 al número de intentos
            intentos++;

            // Función que devuelve la tabla con la posición destapada que ha elegido el usuario
            game.destapaPosicion(posicionUsuario);

            // Función que comprueba si la posición ha caído en una mina
            gameOver = game.compruebaMina(posicionUsuario);

        } // Comprueba que el número de intentos esta por debajo de los posibles y que el jugador no ha pisado una mina
        while (intentos < (game.TAMTABLERO - game.NUMERO_MINAS) && !gameOver);

        // Comprueba si ha perdido
        if (gameOver) {
            System.out.println("\n¡HAS PERDIDO!");
            game.muestraTablero(game.tableroPrincipal);
        } else {
            System.out.println("\n¡HAS GANADO!");
        }


        // Booleano donde diga que si ha perdido lo muestre o al contrario
    }
}
