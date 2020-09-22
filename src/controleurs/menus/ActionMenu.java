package controleurs.menus;

import vues.menus.Menu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * La classe <code>ActionMenu</code> est une liste d'actions à attribuer à un
 * bouton d'un menu spécifique.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public abstract class ActionMenu implements ActionListener {

    /**
     * Menu concerné.
     */
    protected Menu menu;

    /**
     * Constructeur synchronisant les actions avec le menu correspondant.
     *
     * @param m le menu actuel
     */
    public ActionMenu(Menu m) {
        this.menu = m;
    }

    /**
     * Se lance en cas de clic sur le bouton.
     *
     * @param evenement les informations sur l'événement
     */
    @Override public void actionPerformed(ActionEvent evenement) {
        this.menu.dispose();
        this.faireAction();
    }

    /**
     * La liste d'actions à exécuter en cas de clique sur un bouton.
     */
    public abstract void faireAction();
}
