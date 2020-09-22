package vues.menus;

import modeles.Grille;

import vues.menus.Menu;

import controleurs.menus.ActionManuel;
import controleurs.menus.ActionAutomatique;


/**
 * La classe <code>MenuJouer</code> sert à créer un menu de jeu.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class MenuJouer extends Menu {

    /**
     * Constante désignant la position (horizontale) de la fenêtre (en pixels).
     */
    private static final int X = 800;

    /**
     * Constante désignant la position (verticale) de la fenêtre (en pixels).
     */
    private static final int Y = 350;

    /**
     * Constante désignant la largeur de la fenêtre (en pixels).
     */
    private static final int LARGEUR = 300;

    /**
     * Constante désignant la largeur de la fenêtre (en pixels).
     */
    private static final int HAUTEUR = 280;

    /**
     * Constante représentant les différents choix possibles (texte des boutons).
     */
    private static final String[] SELECTION = {"Manuel", "Automatique"};

    /**
     * Lecteur de fichier pour la grille.
     */
    private Grille grille;

    /**
     * Constructeur qui crée le menu et attribue une action aux boutons.
     */
    public MenuJouer(Grille g) {
        super(MenuJouer.X, MenuJouer.Y, MenuJouer.LARGEUR, MenuJouer.HAUTEUR, MenuJouer.SELECTION);
        this.grille = g;
        this.setAction();
    }

    /**
     * Attribue une action à chaque bouton.
     */
    @Override public void setAction() {
        this.boutons[0].addActionListener(new ActionManuel(this, this.grille));
        this.boutons[1].addActionListener(new ActionAutomatique(this, this.grille));
    }
}
