package controleurs.menus;

import vues.menus.Menu;
import vues.menus.MenuGrille;

import controleurs.menus.ActionMenu;

/**
 * La classe <code>ActionJouer</code> sert à ouvrir un menu de sélection de
 * grille pour jouer.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class ActionJouer extends ActionMenu {

    /**
     * Constructeur synchronisant les actions avec le menu correspondant.
     *
     * @param menu le menu actuel
     */
    public ActionJouer(Menu menu) {
        super(menu);
    }

    /**
     * La liste d'actions à exécuter en cas de clique sur un bouton.
     */
    @Override public void faireAction() {
        MenuGrille grille = new MenuGrille();
        grille.setVisible(true);
    }
}
