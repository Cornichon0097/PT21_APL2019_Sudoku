package vues.sudoku;

import modeles.Grille;

import vues.sudoku.Sudoku;
import vues.sudoku.EntreesJeu;

import controleurs.utilisateur.ActionNotes;


/**
 * La classe <code>Jeu</code> sert à créer un grille pour jouer.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class Jeu extends Sudoku {

    /**
     * Constructeur servant uniquement à afficher la grille.
     *
     * @param grille la grille pour jouer
     */
    public Jeu(Grille grille) {
        /* Affichage de la grille. */
        super(grille);

        /* Affiche les boutons d'intéraction. */
        EntreesJeu boutons = new EntreesJeu(this, this.aLEcran.getActionCellule(), new ActionNotes());
        this.affichage.add(boutons);
    }
}
