package controleurs.menus;

import modeles.Grille;

import vues.menus.Menu;
import vues.sudoku.Editeur;

import controleurs.menus.ActionMenu;
import controleurs.fichiers.ChargerGrille;


/**
 * La classe <code>ActionChargerEditeur</code> est un contrôleur qui donne les
 * actions à faire si l'utilisateur choisit de lancer un éditeur de grilles.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class ActionChargerEditeur extends ActionMenu {

    /**
     * Constructeur de ActionChargerEditeur, synchronisant les actions avec le menu correspondant.
     *
     * @param menu le menu actuel, à fermer après sélection
     */
    public ActionChargerEditeur(Menu menu) {
        super(menu);
    }

    /**
     * Méthode héritée de la classe ActionMenu.
     * Dans ce cas, lance un éditeur de grilles.
     */
    @Override public void faireAction() {
        ChargerGrille chargerGrille = new ChargerGrille(Editeur.EDITER);
        Grille grille = chargerGrille.getGrille();

        if (grille != null) {
            Editeur sudoku = new Editeur(grille);
            sudoku.setVisible(true);
        }
    }
}
