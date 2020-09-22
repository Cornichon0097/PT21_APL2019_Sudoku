package modeles;

import modeles.Pile;


/**
 * La classe <code>Cellule</code> modélise une cellule du plateau de Sudoku.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class Cellule extends Pile {

    /**
     * Capacité de la pile.
     */
    private static final byte CAPACITE = 4;

    /**
     * Valeur de la cellule (de 0 à 9).
     */
    private byte valeur;

    /**
     * État de la cellule (modifiable ou non).
     */
    private boolean modifiable;

    /**
     * Position en x dans le grille.
     */
    private byte positionX;

    /**
     * Position en y dans le grille.
     */
    private byte positionY;

    /**
     * Constructeur ajoutant une valeur à la cellule.
     *
     * @param v la valeur de la cellule (0 si vide)
     * @param x l'abscice de la cellule
     * @param y l'ordonnée de la cellule
     */
    public Cellule(int v, int x, int y) {
        super(Cellule.CAPACITE);
        this.valeur = (byte) v;

        if (v == 0) {
            this.modifiable = true;
        } else {
            this.modifiable = false;
        }

        this.positionX = (byte) x;
        this.positionY = (byte) y;
    }

    /**
     * Constructeur ajoutant une valeur à la cellule.
     *
     * @param v la valeur de la cellule (0 si vide)
     * @param x l'abscice de la cellule
     * @param y l'ordonnée de la cellule
     * @param m l'état de la cellule
     */
    public Cellule(int v, int x, int y, boolean m) {
        super(Cellule.CAPACITE);
        this.valeur = (byte) v;

        this.modifiable = m;

        this.positionX = (byte) x;
        this.positionY = (byte) y;
    }

    /**
     * Met à jour la valeur de la cellule.
     *
     * @param v la nouvelle valeur de la cellule (de 0 à 9)
     */
    public void setValeur(int v) {
        this.valeur = (byte) v;
    }

    /**
     * Retourne la valeur de la cellule.
     *
     * @return la valeur de la cellule (de 0 à 9)
     */
    public byte getValeur() {
        return this.valeur;
    }

    /**
     * Retourne la statut de la cellule (si elle est modifiable).
     *
     * @return le statut de la cellule (true si modifiable)
     */
    public boolean isModifiable() {
        return this.modifiable;
    }

    /**
     * Retourne la position en x de la cellule.
     *
     * @return la position en x de la cellule
     */
    public byte getPositionX() {
        return this.positionX;
    }

    /**
     * Retourne la position en y de la cellule.
     *
     * @return la position en y de la cellule
     */
    public byte getPositionY() {
        return this.positionY;
    }

    /**
     * Retourne la cellule sous forme de String.
     *
     * @return la cellule sous forme de String
     */
    @Override public String toString() {
        if (this.empty()) {
            if (this.valeur == 0) {
                return "";
            } else {
                return Byte.toString(this.valeur);
            }
        } else {
            return super.toString();
        }
    }
}
