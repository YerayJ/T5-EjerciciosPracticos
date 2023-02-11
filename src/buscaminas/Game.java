package buscaminas;

public class Game {
    // Tabla sin respuestas
    public static void main(String[] args) {

        // Crea objeto para llamar a la clase Funciones
        Funciones game = new Funciones();

        // Comprueba si el queremos visualizar la respuesta
        if (game.CHEAT) {
            // Muestra el tablero con las respuestas
            game.muestraTablero(game.TABLERO_RESPUESTA);
        }


        game.muestraTablero(game.tableroPrincipal);


    }
}
