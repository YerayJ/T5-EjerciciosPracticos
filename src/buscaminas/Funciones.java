package buscaminas;

import java.util.Arrays;

public class Funciones {
    static boolean sigueJugando() {
        boolean sigueJugando = true;


        return sigueJugando;
    }

    static void muestraTablero(char tablero[]) {
        System.out.println(Arrays.toString(tablero));
    }

    static char[] generaMinas(char tablero[]) {
        int posMinas;
        int compruebaMinas = 0;

        while (compruebaMinas < Main.NUMERO_MINAS) {
            posMinas = (int) (Math.random() * Main.TAMTABLERO);
            if (tablero[posMinas] != 'x') {
                tablero[posMinas] = 'x';
                compruebaMinas++;
            }
        } // Fin de bucle

        return tablero;
    }

    static char[] generaRespuesta(char tablero[]) {

        // Introduce las minas en el tablero
        generaMinas(tablero);

        // Introduce las pistas en el tablero
        for (int i = 0; i < tablero.length; i++) {
            // Comprueba que en la posición no haya una mina
            if (tablero[i] != 'x') {

                if (i == 0 || i == 19) {
                    tablero[i] = '0';
                }
                // Si tiene una mina por delante y por detrás la pista será 2
                else if (tablero[i - 1] == 'x' && tablero[i + 1] == 'x') {
                    tablero[i] = '2';
                    // Si tiene una mina por delante o por detrás la pista será 1
                } else if (tablero[i - 1] == 'x' || tablero[i + 1] == 'x') {
                    tablero[i] = '1';
                    // Sino será 0
                } else {
                    tablero[i] = '0';
                }
            }
        } // Fin de bucle

        return tablero;
    }

}
