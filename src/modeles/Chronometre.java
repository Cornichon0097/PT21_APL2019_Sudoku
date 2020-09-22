package modeles;


/**
 * La classe <code>Chronometre</code> permet de mesurer le temps écoulé.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class Chronometre {

    /**
     * Le moment où le chronomètre débute.
     */
    private long debut;

    /**
     * Constructeur servant à remettre à zéro le chronomètre.
     */
    public Chronometre() {
        this.debut = System.nanoTime();
    }

    /**
     * Retourne le temps écoulé sous forme de long en nanosecondes.
     *
     * @return le temps écoulé (long) (nanosecondes)
     */
    public long tempsEcoule() {
        return System.nanoTime() - this.debut;
    }

    /**
     * Retourne le temps écoulé sous forme de double en secondes.
     *
     * @return le temps écoulé (double) (seconde)
     */
    public double tempsEnSecondes() {
        return (double) (this.tempsEcoule() /Math.pow(10, 9));
    }


    /**
     * Retourne le temps écoulé sous forme de double en millisecondes.
     *
     * @return le temps écoulé (double) (milliseconde)
     */
    public double tempsEnMillisecondes() {
        return (double) (this.tempsEcoule() /Math.pow(10, 6));
    }

    /**
     * Retourne le temps écoulé sous forme de String en milliseconde.
     *
     * @return le temps écoulé (String) (milliseconde)
     */
    @Override public String toString() {
        return Double.toString(this.tempsEnMillisecondes());
    }
}
