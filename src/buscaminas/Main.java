package buscaminas;

public class Main {
    // Tamaño tablero
    static final int TAMTABLERO = 20;

    // Constante con el número de minas
    static final int NUMERO_MINAS = 6;

    // Tabla sin respuestas
    static char tableroVacio[] = {'?','?','?','?','?','?','?','?','?','?','?','?','?','?','?','?','?','?','?','?'};
    public static void main(String[] args) {
        // Array con el tablero
        char tableroRespuesta[] = new char[TAMTABLERO];

        // Genera el tablero con las minas
        Funciones.generaRespuesta(tableroRespuesta);

        Funciones.muestraTablero(tableroRespuesta);


    }
}
