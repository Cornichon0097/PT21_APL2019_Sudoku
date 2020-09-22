package controleurs.menus;

import vues.menus.Menu;
import vues.menus.MenuCreer;

import controleurs.menus.ActionMenu;

/**
 * La classe <code>ActionCreer</code> sert à ouvrir un menu de sélection de
 * grille en mode éditeur.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class ActionCreer extends ActionMenu {

    /**
     * Constructeur synchronisant les actions avec le menu correspondant.
     *
     * @param menu le menu actuel
     */
    public ActionCreer(Menu menu) {
        super(menu);
    }

    /**
     * La liste d'actions à exécuter en cas de clique sur un bouton.
     */
    @Override public void faireAction() {
        MenuCreer creer = new MenuCreer();
        creer.setVisible(true);
    }
}
