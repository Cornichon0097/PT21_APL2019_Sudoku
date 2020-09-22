package controleurs.utilisateur;

import vues.Fenetre;
import vues.menus.MenuAccueil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * La classe <code>ActionRetour</code> sert à revenir au menu d'accueil.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class ActionRetour implements ActionListener {

    private Fenetre actuelle;

    /**
     * Constructeur synchronisant les actions avec le menu correspondant.
     *
     * @param a la fenettre actuelle
     */
    public ActionRetour(Fenetre a) {
        this.actuelle = a;
    }

    /**
     * Se lance en cas de clic sur le bouton.
     *
     * @param evenement les informations sur l'événement
     */
    @Override public void actionPerformed(ActionEvent evenement) {
        this.actuelle.dispose();
        MenuAccueil accueil = new MenuAccueil();
        accueil.setVisible(true);
    }
}
