package controleurs.menus;

import modeles.GrilleAleatoire;

import vues.menus.Menu;
import vues.sudoku.Jeu;

import controleurs.menus.ActionMenu;


/**
 * La classe <code>ActionGrilleAleatoire</code> sert à créer une grille générée aléatoirement.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class ActionGrilleAleatoire extends ActionMenu {

    /**
     * Constructeur de ActionGrilleAleatoire, synchronisant les actions avec le menu correspondant.
     *
     * @param menu le menu actuel, à fermer après sélection
     */
    public ActionGrilleAleatoire(Menu menu) {
        super(menu);
    }

    /**
     * Méthode héritée de la classe ActionMenu.
     * Dans ce cas, lance un Jeu avec une grille générée aléatoirement.
     */
    @Override public void faireAction() {
        Jeu sudoku = new Jeu(new GrilleAleatoire());
        sudoku.setVisible(true);
    }
}
