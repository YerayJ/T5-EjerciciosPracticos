package sieteymedia;


public class Game {
    public static void main(String[] args) {

        // Objeto para llamar a la clase funciones
        Funciones game = new Funciones();

        // Comprueba si el usuario quiere volver a jugar
        boolean repetirPartida;

        do {
            // Empieza el juego
            System.out.println("Bienvenidos al juego de las Siete y Media");

            // Llama a la función para sacar la jugada del jugador 1
            game.jugadaJ1 = game.sacaJugada();

            // Si el jugador 1 se pasa del rango lo indica pero sigue el juego
            if (game.jugadaJ1 > 7.5) {
                System.out.println("Te has pasado");
            }

            // Empieza el turno del jugador 2
            System.out.println("EMPIEZA EL TURNO DEL JUGADOR 2");

            // Llama a la función para sacar la jugada del jugador 2
            game.jugadaJ2 = game.sacaJugada();

            // Si el jugador 1 se pasa del rango lo indica pero sigue el juego
            if (game.jugadaJ2 > 7.5) {
                System.out.println("Te has pasado");
            }

            // Imprime las puntuaciones
            System.out.println("El JUGADOR 1 tiene " + game.jugadaJ1 + " puntos y el JUGADOR 2 tiene " + game.jugadaJ2 +
                    " puntos");

            // Comprueba quién es el ganador
            // Si el valor que devuelve es 0, habrá un empate
            if (game.compruebaGanador() == 0) {
                System.out.println("HAN EMPATADO");
                // En caso de 1 gana el jugador 1
            } else if (game.compruebaGanador() == 1) {
                System.out.println("Enhorabuena, JUGADOR 1, has ganado la partida");
                // Si no se cumplen los anteriores casos gana el jugador 2
            } else {
                System.out.println("Enhorabuena, JUGADOR 2, has ganado la partida");
            }

            // Pregunta si quiere repetir la partida
            System.out.println("¿Quiere volver a jugar? (s/n)");
            repetirPartida = game.repetirPartida();
        } while (repetirPartida);


    }

}
