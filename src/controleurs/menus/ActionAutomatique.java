package controleurs.menus;

import modeles.Grille;
import modeles.Chronometre;

import vues.menus.Menu;
import vues.sudoku.Jeu;
import vues.messages.Information;

import controleurs.menus.ActionMenu;
import controleurs.assistance.Solveur;


/**
 * La classe <code>ActionAutomatique</code> est un contrôleur qui donne les actions
 * à faire si l'utilisateur choisit de lancer la grille en résolution automatique.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class ActionAutomatique extends ActionMenu {

    /**
     * La grille de jeu.
     */
    private Grille grille;

    /**
     * Constructeur de ActionAutomatique, synchronisant les actions avec le menu correspondant.
     *
     * @param menu le menu actuel, à fermer après sélection
     * @param g la grille à construre
     */
    public ActionAutomatique(Menu menu, Grille g) {
        super(menu);
        this.grille = g;
    }

    /**
     * Méthode héritée de la classe ActionMenu.
     * Dans ce cas, lance une partie en mode résolution automatique.
     */
    @Override public void faireAction() {
        Jeu sudoku = new Jeu(this.grille);
        sudoku.setVisible(true);

        Solveur superman = new Solveur(this.grille, sudoku.getALEcran());
        Chronometre chrono = new Chronometre();

        if (superman.resoudre(superman.caseARemplir(), 0, 0)) {
            new Information("Résolution terminée en " + chrono.toString() + " millisecondes");
        } else {
            new Information("Cette grille n'est pas solvable.");
        }
    }
}
