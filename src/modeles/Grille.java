package modeles;

import modeles.Cellule;

import java.util.Random;

/**
 * La classe <code>Grille</code> modélise un plateau de Sudoku grâce à un
 * tableau de cellules à deux dimmensions.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class Grille {

    /**
     * Constante correspondant à la taille de la grille.
     */
    public static final byte TAILLE = 9;

    /**
     * Tableau de cellules à deux dimmensions représentant la grille.
     */
    protected Cellule[][] tableau;

    /**
     * Constructeur qui génère la grille.
     */
    public Grille() {
        this.tableau = new Cellule[Grille.TAILLE][Grille.TAILLE];

        for (int x = 0; x < Grille.TAILLE; x++) {
            for (int y = 0; y < Grille.TAILLE; y++) {
                this.tableau[x][y] = new Cellule(0, x, y);
            }
        }
    }

    /**
     * Met à jour une cellule de la grille.
     *
     * @param x l'abcisse d'une cellule (x entre 0 et taille-1)
     * @param y l'ordonnée d'une cellule (y entre 0 et taille-1)
     * @param c la nouvelle cellule
     */
    public void setCellule(Cellule c, int x, int y) {
        this.tableau[x][y] = c;
    }

    /**
     * Retourne une cellule.
     *
     * @param x l'abcisse de la cellule (x entre 0 et taille-1)
     * @param y l'ordonnée de la cellule (y entre 0 et taille-1)
     *
     * @return la cellule aux coordonées (x, y)
     */
    public Cellule getCellule(int x, int y) {
        return this.tableau[x][y];
    }

    /**
     * Retourne une ligne.
     *
     * @param x la position de la ligne
     *
     * @return la ligne x
     */
    public Cellule[] getLigne(int x) {
        return this.tableau[x];
    }

    /**
     * Retourne une ligne.
     *
     * @param cellule une cellule appartenant à la ligne
     *
     * @return la ligne à laquelle la cellule appartient
     */
    public Cellule[] getLigne(Cellule cellule) {
        return this.getLigne(cellule.getPositionX());
    }

    /**
     * Retourne une colonne.
     *
     * @param y la position de la colonne
     *
     * @return la colonne y
     */
    public Cellule[] getColonne(int y) {
        Cellule[] colonne = new Cellule[Grille.TAILLE];

        for (int i = 0; i < Grille.TAILLE; i++) {
            colonne[i] = this.tableau[i][y];
        }

        return colonne;
    }

    /**
     * Retourne une colonne.
     *
     * @param cellule une cellule appartenant à la colonne
     *
     * @return la colonne à laquelle la cellule appartient
     */
    public Cellule[] getColonne(Cellule cellule) {
        return this.getColonne(cellule.getPositionY());
    }

    /**
     * Retourne une région.
     *
     * @param x l'abcisse d'une cellule (x entre 0 et taille-1)
     * @param y l'ordonnée d'une cellule (y entre 0 et taille-1)
     *
     * @return la région à laquelle la cellule appartient
     */
    public Cellule[][] getRegion(int x, int y) {
        Cellule[][] region = new Cellule[Grille.TAILLE/3][Grille.TAILLE/3];

        x = x /3 * 3;
        y = y /3 * 3;

        for (int i = 0; i < Grille.TAILLE/3; i++) {
            for (int j = 0; j < Grille.TAILLE/3; j++) {
                region[i][j] = this.tableau[x+i][y+j];
            }
        }

        return region;
    }

    /**
     * Retourne une région.
     *
     * @param cellule une cellule appartenant à la région
     *
     * @return la région à laquelle la cellule appartient
     */
    public Cellule[][] getRegion(Cellule cellule) {
        return this.getRegion(cellule.getPositionX(), cellule.getPositionY());
    }

    /**
     * Retourne la grille sous forme de String.
     *
     * @return la grille sous forme de String
     */
    @Override public String toString() {
        String texte = "";
        for (byte i = 0; i < Grille.TAILLE; i++) {
            for (byte j = 0; j < Grille.TAILLE; j++) {
                texte += Byte.toString(this.tableau[i][j].getValeur());
            }
            texte += "\n";
        }
        return texte;
    }
}
