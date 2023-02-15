package sieteymedia;

import java.util.Scanner;

public class Funciones {
    // Creación de escáner para leer datos
    Scanner key = new Scanner(System.in);

    // Array de dos dimensiones que guarda la baraja
     final double baraja[][] =
            {{1, 2, 3, 4, 5, 6, 7, 0.5, 0.5, 0.5},
                    {1, 2, 3, 4, 5, 6, 7, 0.5, 0.5, 0.5},
                    {1, 2, 3, 4, 5, 6, 7, 0.5, 0.5, 0.5},
                    {1, 2, 3, 4, 5, 6, 7, 0.5, 0.5, 0.5}};

    // Contiene el número de la jugada actual
    double jugadaJ1, jugadaJ2;

    // El número que introduce el usuario
    String tirada;


    String sacaTipo() {
        // Saca un número aleatorio del 0 al 3 que es el número de filas
        int tipoCarta = (int) (Math.random() * baraja.length);

        // Variable que guarda el nombre del tipo de la carta
        String tipo = "";

        switch (tipoCarta) {
            // Según el número que haya sacado se asigna un valor al tipo carta
            case 0 -> {
                tipo = "oros";
            }
            case 1 -> {
                tipo = "copas";
            }
            case 2 -> {
                tipo = "espadas";
            }
            case 3 -> {
                tipo = "bastos";
            }
        }

        return tipo;
    }

    double sacaJugada() {
        // Variable que guarda el valor de la carta actual
        double carta;

        // Variable que guarda la posición de la tabla
        int posicion;

        // Suma de las cartas actual
        double sumaCartas = 0;

        // Variable que comprueba si sigue jugando
        boolean sigueJugando = true;

        // Pide tirada al usuario
        System.out.println("¿Quieres sacar una carta (s/n)? ");
        tirada = key.next();

        while (tirada.equals("s") && sigueJugando) {
            // Saca la posición de la carta en el array
            posicion = (int) (Math.random() * baraja[0].length);

            // La variable carta coge el valor de la posición en la tabla
            carta = baraja[0][posicion];

            // La añade a la suma de cartas
            sumaCartas += carta;

            // Genera una tirada
            switch (posicion){
                case 8 -> {
                    System.out.println("Tu carta es: " + "sota de " + sacaTipo());
                }
                case 9 -> {
                    System.out.println("Tu carta es: " + "caballo de " + sacaTipo());
                }
                case 10 -> {
                    System.out.println("Tu carta es: " + "rey de " + sacaTipo());
                }
                case default -> {
                    System.out.println("Tu carta es: " + carta + " " + sacaTipo());
                }
            }


            // Muestra puntuación actual
            System.out.println("Puntuación actual: " + sumaCartas);

            if (sumaCartas <= 7.5) {
                // Pide tirada al usuario
                System.out.println("¿Quieres sacar una carta (s/n)? ");
                tirada = key.next();
            } else {
                // Si se pasa del límite la variable cambia a false
                sigueJugando = false;
            }

        } // Termina bucle

        return sumaCartas;
    }

    int compruebaGanador() {
        // Guarda el resultado. En caso de 0 será empate, 1 gana el jugador uno, 2 gana el jugador dos
        int esGanador = 0;

        // Calcula la diferencia para saber cuál tiene menos distancia con el resultado
        double auxJ1 = 7.5 - jugadaJ1;
        double auxJ2 = 7.5 - jugadaJ2;

        // Si son iguales o se salen los dos del rango es un empate
        if ((jugadaJ2 == jugadaJ1) || (jugadaJ2 > 7.5 && jugadaJ1 > 7.5) ) {

        } else {
            // Si el jugador sale del límite gana jugador 1
            if (jugadaJ1 > 7.5) {
                esGanador = 2;
                // Si el jugador sale del límite gana jugador 1
            } else if (jugadaJ2 > 7.5) {
                esGanador = 1;
                // Si la diferencia de J1 es menor ganará él
            } else if (auxJ1 < auxJ2) {
                esGanador = 1;
                // Si la diferencia de J2 es menor ganará él
            } else if (auxJ1 > auxJ2) {
                esGanador = 2;
            }

        }

        // Devuelve la variable que indica quién es ganador
        return esGanador;
    }

    boolean repetirPartida() {
        // Indica si se vuelve a jugar
        boolean game = false;

        // Guarda decisión de usuario
        String opc;

        //Pide la opción al usuario
        opc = key.next();

        // Comprueba si la opción es válida
        switch (opc) {
            case "s", "si", "Si", "SI" -> {
                // Si es si sigue el juego
                game = true;
            }
            case "n", "no", "No", "NO" -> {
            }
            case default -> {
                System.err.println("Esa opción no existe");
            }

        }
        return game;
    }

}
