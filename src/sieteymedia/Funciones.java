package sieteymedia;

public class Funciones {

    // Array de dos dimensiones que guarda la baraja
    static final double baraja[][] =
            {{1, 2, 3, 4, 5, 6, 7, 0.5, 0.5, 0.5},
                    {1, 2, 3, 4, 5, 6, 7, 0.5, 0.5, 0.5},
                    {1, 2, 3, 4, 5, 6, 7, 0.5, 0.5, 0.5},
                    {1, 2, 3, 4, 5, 6, 7, 0.5, 0.5, 0.5}};

    // Contiene el número de la jugada actual
    int jugadaJ1, jugadaJ2;

    // El número que introduce el usuario
    String tirada;

    // Función que saca una carta con número aleatorio
    double sacaCarta(){
        // Genera un número aleatorio del 1 al 9
        int posicion = (int) (Math.random()* baraja[0].length);
        int tipoCarta = (int) (Math.random()* baraja.length);

        double carta = (double) baraja[posicion];


        return 2;
    }

}
