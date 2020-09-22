package controleurs.menus;

import vues.menus.Menu;

import controleurs.menus.ActionMenu;


/**
 * La classe <code>ActionQuitter</code> sert à quitter le programme.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class ActionQuitter extends ActionMenu {

    /**
     * Constructeur synchronisant les actions avec le menu correspondant.
     *
     * @param menu le menu actuel
     */
    public ActionQuitter(Menu menu) {
        super(menu);
    }

    /**
     * La liste d'actions à exécuter en cas de clique sur un bouton.
     */
    @Override public void faireAction() {
        System.exit(0);
    }
}
