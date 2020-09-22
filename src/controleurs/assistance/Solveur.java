package controleurs.assistance;

import modeles.Grille;
import modeles.Cellule;

import vues.affichage.AfficherGrille;
import vues.affichage.AfficherCellule;

import controleurs.assistance.Inspecteur;


/**
 * La classe <code>Solveur</code> résout une grille de sudoku.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class Solveur {

    /**
     * La grille à résoudre.
     */
    protected Grille aResoudre;

    /**
     * Représentation de la grille à l'écran.
     */
    private AfficherCellule[][] affichage;

    /**
     * Constructeur du solveur.
     *
     * @param grille la grille à résoudre
     * @param afficherGrille la version graphique de la grille
     */
    public Solveur(Grille grille, AfficherGrille afficherGrille) {
        this.aResoudre = grille;
        this.affichage = afficherGrille.getALEcran();
    }

    /**
     * Retourne le nombre de case à remplir dans la grille à résoudre.
     *
     * @return le nombre de case à remplir
     */
    public int caseARemplir() {
        int nombreDeCaseARemplir = 0;

        for (int x = 0; x < Grille.TAILLE; x++) {
            for (int y = 0; y < Grille.TAILLE; y++) {
                if (this.aResoudre.getCellule(x, y).getValeur() == 0) {
                    nombreDeCaseARemplir++;
                }
            }
        }

        return nombreDeCaseARemplir;
    }

    /**
     * Méthode récursive, retourne si la grille est solvable ou non.
     *
     * @param nombreDeCaseARemplir le nombre de cases qu'il reste à remplir
     * @param x la position x d'une cellule
     * @param y la position y d'une cellule
     *
     * @return true si la grille est solvable, false sinon
     */
    public boolean resoudre(int nombreDeCaseARemplir, int x, int y) {
        /* S'il ne reste aucune case vide, alors la grille est résolue. */
        if (nombreDeCaseARemplir == 0) {
            return true;
        }

        /* Pour passer à la ligne suivante. */
        if (y == Grille.TAILLE) {
            x++;
            y = 0;
        }

        Cellule cellule = this.aResoudre.getCellule(x, y);

        /* Si la cellule possède déjà une valeur, retourne le statut de la suivante. */
        if (cellule.getValeur() != 0) {
            return this.resoudre(nombreDeCaseARemplir, x, (y+1));
        } else {
            Inspecteur gadget = new Inspecteur(this.aResoudre);
            /* Essaye de mettre les valeurs de 1 à 9 dans la cellule. */
            for (int i = 1; i <= 9; i++) {
                /* Si la valeur peut être mise dans le cellule : */
                if (gadget.verifierCellule(cellule, i)) {
                    cellule.setValeur(i);
                    /* Affiche la valeur à l'écran. */
                    this.affichage[x][y].setForeground(AfficherCellule.VALIDE);
                    this.affichage[x][y].setText(Integer.toString(i));
                    /* Passe à la cellule suivante. */
                    if (this.resoudre((nombreDeCaseARemplir-1), x, (y+1))) {
                        /* Retourne true si le statut de la cellule précédente
                        est true lui aussi. */
                        return true;
                    }
                }
                /* Si aucune valeur ne peut être mise dans la cellule, celle-ce
                est remise à zéro. */
                cellule.setValeur(0);
            }
        }

        /* Retourne false si aucune valeur n'a pu être mise dans la cellule. */
        return false;
    }
}
