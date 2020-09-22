package controleurs.menus;

import modeles.Grille;

import vues.menus.Menu;
import vues.menus.MenuJouer;
import vues.sudoku.Jeu;

import controleurs.menus.ActionMenu;
import controleurs.fichiers.ChargerGrille;


/**
 * La classe <code>ActionChargerJeu</code> sert à chrger une grille de départ
 * depuis un fichier pour jouer.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class ActionChargerJeu extends ActionMenu {

    /**
     * Constructeur synchronisant les actions avec le menu correspondant.
     *
     * @param menu le menu actuel
     */
    public ActionChargerJeu(Menu menu) {
        super(menu);
    }

    /**
     * La liste d'actions à exécuter en cas de clique sur un bouton.
     */
    @Override public void faireAction() {
        ChargerGrille chargerGrille = new ChargerGrille(Jeu.JOUER);
        Grille grille = chargerGrille.getGrille();

        if (grille != null) {
            MenuJouer jouer = new MenuJouer(grille);
            jouer.setVisible(true);
        }
    }
}
