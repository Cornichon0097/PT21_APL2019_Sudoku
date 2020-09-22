package vues.sudoku;

import modeles.Grille;

import vues.Fenetre;
import vues.affichage.AfficherGrille;
import vues.sudoku.Entrees;

import java.awt.GridLayout;


/**
 * La classe <code>Sudoku</code> sert à créer une fenêtre de sudoku.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public abstract class Sudoku extends Fenetre {

    /**
     * Constante désignant la position (horizontale) de la fenêtre (en pixels).
     */
    private static final int X = 400;

    /**
     * Constante désignant la position (verticale) de la fenêtre (en pixels).
     */
    private static final int Y = 200;

    /**
     * Constante désignant la largeur de la fenêtre (en pixels).
     */
    private static final int LARGEUR = 1200;

    /**
     * Constante désignant la largeur de la fenêtre (en pixels).
     */
    private static final int HAUTEUR = 600;

    /**
     * Constante interdisant l'édition d'une grille.
     */
    public static final boolean JOUER = false;

    /**
     * Constante autorisant l'édition d'une grille.
     */
    public static final boolean EDITER = true;

    /**
     * Grille affichée à l'écran.
     */
    protected AfficherGrille aLEcran;

    /**
     * Constructeur servant uniquement à ajouter à la fenêtre les éléements
     * d'intéraction avec l'utilisateur.
     *
     * @param grille la grille à afficher
     */
    public Sudoku(Grille grille) {
        super(X, Y, LARGEUR, HAUTEUR, "Sudoku");
        this.affichage.setLayout(new GridLayout(1,2));

        /* Affiche la grille de sudoku. */
        this.aLEcran = new AfficherGrille(grille);
        this.affichage.add(this.aLEcran);
    }

    /**
     * Retourne la grille affichée à l'écran.
     *
     * @return la grille affichée à l'écran
     */
    public AfficherGrille getALEcran() {
        return this.aLEcran;
    }
}
