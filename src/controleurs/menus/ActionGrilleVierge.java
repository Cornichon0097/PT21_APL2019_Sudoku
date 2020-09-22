package controleurs.menus;

import modeles.Grille;

import vues.menus.Menu;
import vues.sudoku.Editeur;

import controleurs.menus.ActionMenu;

/**
 * La classe <code>ActionGrilleVierge</code> sert à créer un éditeur avec une grille vierge.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class ActionGrilleVierge extends ActionMenu {

    /**
     * Constructeur de ActionGrilleVierge, synchronisant les actions avec le menu correspondant.
     *
     * @param menu le menu actuel, à fermer après sélection
     */
    public ActionGrilleVierge(Menu menu) {
        super(menu);
    }

    /**
     * Méthode héritée de la classe ActionMenu.
     * Dans ce cas, lance un éditeur avec une grille vierge.
     */
    @Override public void faireAction() {
        Editeur sudoku = new Editeur(new Grille());
        sudoku.setVisible(true);
    }
}
