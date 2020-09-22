package vues.sudoku;

import modeles.Grille;

import vues.sudoku.Sudoku;
import vues.sudoku.EntreesEditeur;

import controleurs.utilisateur.ActionNotes;


/**
 * La classe <code>Editeur</code> sert à créer un éditeur de grille.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class Editeur extends Sudoku {

    /**
     * Constructeur servant uniquement à afficher l'éditeur.
     *
     * @param grille la grille à éditer
     */
    public Editeur(Grille grille) {
        super(grille);

        /* Affiche les boutons d'intéraction. */
        EntreesEditeur boutons = new EntreesEditeur(grille, this, this.aLEcran.getActionCellule(), new ActionNotes());
        this.affichage.add(boutons);
    }
}
