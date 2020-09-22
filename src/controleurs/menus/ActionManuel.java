package controleurs.menus;

import modeles.Grille;

import vues.menus.Menu;
import vues.sudoku.Jeu;

import controleurs.menus.ActionMenu;

/**
 * La classe <code>ActionManuel</code> sert à ouvrir un Jeu en mode de résolution manuel.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class ActionManuel extends ActionMenu {

    /**
     * La grille de jeu.
     */
    private Grille grille;

    /**
     * Constructeur de ActionManuel, synchronisant les actions avec le menu correspondant.
     *
     * @param menu le menu actuel, à fermer après sélection
     */
    public ActionManuel(Menu menu, Grille g) {
        super(menu);
        this.grille  = g;
    }

    /**
     * Méthode héritée de la classe ActionMenu.
     * Dans ce cas, lance un Jeu en mode de résolution manuel.
     */
    @Override public void faireAction() {
        Jeu sudoku = new Jeu(this.grille);
        sudoku.setVisible(true);
    }
}
