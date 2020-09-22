package controleurs.assistance;

import modeles.Grille;
import modeles.Cellule;


/**
 * La classe <code>Inspecteur</code> se charge de vérifie s'il est possible ou
 * non de modifier une valeur dans une cellule de la grille.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class Inspecteur {

    /**
     * La grille concernée.
     */
    protected Grille grille;

    /**
     * Les cellules posant problème.
     */
    protected Cellule[] quiPosentProbleme;

    /**
     * Constructeur synchronisant l'inspecteur et la grille.
     *
     * @param g la grille concernée
     */
    public Inspecteur(Grille g) {
        this.grille = g;
        this.quiPosentProbleme = new Cellule[3];
    }

    /**
     * Retourne true si la nouvelle valeur peut être insérée dans la cellule.
     *
     * @param cellule la cellule à modifier
     * @param nouvelleValeur la nouvelle valeur
     *
     * @return true si la cellule peut prendre cette valeur, false sinon
     */
    public boolean verifierCellule(Cellule cellule, int nouvelleValeur) {
        this.setQuiPosentProbleme();
        boolean a = this.verifierLigne(cellule, nouvelleValeur);
        boolean b = this.verifierColonne(cellule, nouvelleValeur);
        boolean c = this.verifierRegion(cellule, nouvelleValeur);

        return (a && b && c);
    }

    /**
     * Réinitialise le tableau de cellules qui posent problème.
     */
    private void setQuiPosentProbleme() {
        for (byte i = 0; i < 3; i++) {
            this.quiPosentProbleme[i] = null;
        }
    }

    /**
     * Retourne false si la valeur se trouve déjà dans la ligne.
     *
     * @param cellule la cellule à modifier
     * @param valeur la valeur
     *
     * @return true si la cellule peut prendre cette valeur, false sinon
     */
    private boolean verifierLigne(Cellule cellule, int valeur) {
        Cellule[] ligne = this.grille.getLigne(cellule);

        for (byte i = 0; i < Grille.TAILLE; i++) {
            if ((ligne[i].getValeur() == valeur) && (ligne[i] != cellule)) {
                this.quiPosentProbleme[0] = ligne[i];
                return false;
            }
        }

        return true;
    }

    /**
     * Retourne false si la valeur se trouve déjà dans la colonne.
     *
     * @param cellule la cellule à modifier
     * @param valeur la valeur
     *
     * @return true si la cellule peut prendre cette valeur, false sinon
     */
    private boolean verifierColonne(Cellule cellule, int valeur) {
        Cellule[] colonne = this.grille.getColonne(cellule);

        for (byte i = 0; i < Grille.TAILLE; i++) {
            if ((colonne[i].getValeur() == valeur) && (colonne[i] != cellule)) {
                this.quiPosentProbleme[1] = colonne[i];
                return false;
            }
        }

        return true;
    }

    /**
     * Retourne false si la valeur se trouve déjà dans la région.
     *
     * @param cellule la cellule à modifier
     * @param valeur la valeur
     *
     * @return true si la cellule peut prendre cette valeur, false sinon
     */
    private boolean verifierRegion(Cellule cellule, int valeur) {
        Cellule[][] region = this.grille.getRegion(cellule);

        for (byte i = 0; i < 3; i++) {
            for (byte j = 0; j < 3; j++) {
                if ((region[i][j].getValeur() == valeur) && (region[i][j] != cellule)) {
                    this.quiPosentProbleme[2] = region[i][j];
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Retourne le statut de victoire.
     *
     * @return le statut de victoire
     */
    public boolean verifierVictoire() {
        for (int x = 0; x < Grille.TAILLE; x++) {
            for (int y = 0; y < Grille.TAILLE; y++) {
                Cellule cellule = this.grille.getCellule(x, y);
                if (cellule.getValeur() == 0) {
                    return false;
                }
            }
        }

        this.setQuiPosentProbleme();
        for (int x = 0; x < Grille.TAILLE; x++) {
            for (int y = 0; y < Grille.TAILLE; y++) {
                Cellule cellule = this.grille.getCellule(x, y);
                if (!(this.verifierCellule(cellule, cellule.getValeur()))) {
                    return false;
                }
            }
        }

        return true;
    }
}
