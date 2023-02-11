package buscaminas;

import java.util.Arrays;

public class Funciones {
    // Tamaño tablero
    final int TAMTABLERO = 20;

    // Constante con el número de minas
    final int NUMERO_MINAS = 6;

    // Array con el tablero con la respuesta
    final char TABLERO_RESPUESTA[] = generaRespuesta();

    // Variable para controlar si se quiere ver la respuesta
    final boolean CHEAT = false;

    // Array con el tablero sin la respuesta
    char tableroPrincipal[] = tableroSinRespuesta();

    char[] tableroSinRespuesta() {
        // Creación de tabla para darle valor
        char tablero[] = new char[TAMTABLERO];
        // Genera interrogaciones en todas las posiciones del tablero
        for (int i = 0; i < TAMTABLERO; i++) {
            tablero[i] = '?';
        } // Fin de bucle
        // Devuelve tablero
        return tablero;
    }


    void muestraTablero(char tablero[]) {
        System.out.println(Arrays.toString(tablero));
    }

    char[] generaMinas(char tablero[]) {
        // Variable para saber la posición en la que colocar la mina
        int posMinas;
        // Variable que conprueba las minas que hay en la tabla
        int compruebaMinas = 0;

        // Mientras las minas en la tabla sea menor al número total de minas que debe haber se ejecuta
        while (compruebaMinas < NUMERO_MINAS) {
            // Genera una posición aleatoria dentro del tablero
            posMinas = (int) (Math.random() * TAMTABLERO);
            // Si no hay x en esa posición se genera una
            if (tablero[posMinas] != 'x') {
                tablero[posMinas] = 'x';
                // Si metemos una mina le sumamos uno al contador
                compruebaMinas++;
            }
        } // Fin de bucle

        tablero[1] = 'x';
        return tablero;
    }

    char[] generaRespuesta() {
        // Creación de tabla para darle valor
        char tablero[] = new char[TAMTABLERO];

        // Introduce las minas en el tablero
        generaMinas(tablero);

        // Introduce las pistas en el tablero
        for (int i = 0; i < tablero.length; i++) {

            // Comprueba que en la posición no haya una mina
            if (tablero[i] != 'x') {

                if (i == 0 || i == tablero.length - 1) {
                    if ((i == 0 && tablero[i + 1] == 'x') || (i == tablero.length-1 && tablero[i - 1] == 'x')) {
                        tablero[i] = '1';
                    } else {
                        tablero[i] = '0';
                    }
                } else {
                    // Si tiene una mina por delante y por detrás la pista será 2
                    if (tablero[i - 1] == 'x' && tablero[i + 1] == 'x') {
                        tablero[i] = '2';
                        // Si tiene una mina por delante o por detrás la pista será 1
                    } else if (tablero[i - 1] == 'x' || tablero[i + 1] == 'x' || tablero[1] == 'x' || tablero[tablero.length - 2] == 'x') {
                        tablero[i] = '1';
                        // Sino será 0
                    } else {
                        tablero[i] = '0';
                    }
                }


            } // Termina condición para saber si es distinto de x

        } // Fin de bucle
        // Devuelve tablero
        return tablero;
    }

    char[] destapaPosicion(int posicion) {
        // Intercambio posición
        tableroPrincipal[posicion] = TABLERO_RESPUESTA[posicion];
        return tableroPrincipal;
    }

    boolean compruebaMina(int posicion) {
        // Esta variable comprobará si el usuario ha perdido
        boolean gameOver = false;
        // Comprueba si la posición es una mina
        if (TABLERO_RESPUESTA[posicion] == 'x') {
            // En ese caso ha perdido
            gameOver = true;
        }
        return gameOver;
    }

}
