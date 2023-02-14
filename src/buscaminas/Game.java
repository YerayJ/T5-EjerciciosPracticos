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
        boolean gameOver;

        // Variable para elegir la opción en la que podemos tener trucos
        String opcCheat;
        // Variable para comprobar si la respuesta está mal
        boolean respuestaCheat;

        do {
            // Se inicializa en cada vuelta a false
            respuestaCheat = false;

            // Pide al usuario una cadena String
            System.out.println("Quieres tener trucos en la siguiente partida");
            opcCheat = key.nextLine();

            // Comprueba la respuesta del usuario
            respuestaCheat = game.RespuestaCheat(game, opcCheat, respuestaCheat);

            // Se ejecuta mientras la variable respuestaCheat sea igual a true
        } while (respuestaCheat);


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

        } // Comprueba que el número de intentos está por debajo de los posibles y que el jugador no ha pisado una mina
        while (intentos < (game.TAMTABLERO - game.NUMERO_MINAS) && !gameOver);

        // Comprueba si ha perdido
        if (gameOver) {
            System.out.println("\n¡HAS PERDIDO!");
            // Muestra tablero al usuario
            game.muestraTablero(game.TABLERO_RESPUESTA);
        } else {
            System.out.println("\n¡HAS GANADO!");
            // Muestra tablero al usuario
            game.muestraTablero(game.TABLERO_RESPUESTA);
        }

    }


}
