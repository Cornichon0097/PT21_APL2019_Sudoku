package vues.menus;

import vues.menus.Menu;


/**
 * La classe <code>MenuTroisBoutons</code> sert à créer un menu de trois boutons.
 */
public abstract class MenuTroisBoutons extends Menu {

    /**
     * Constante désignant la position (horizontale) de la fenêtre (en pixels).
     */
    private static final int X = 800;

    /**
     * Constante désignant la position (verticale) de la fenêtre (en pixels).
     */
    private static final int Y = 300;

    /**
     * Constante désignant la largeur de la fenêtre (en pixels).
     */
    private static final int LARGEUR = 300;

    /**
     * Constante désignant la largeur de la fenêtre (en pixels).
     */
    private static final int HAUTEUR = 400;

    /**
     * Constructeur qui crée le menu de trois boutons.
     */
    public MenuTroisBoutons(String[] selection) {
        super(MenuTroisBoutons.X, MenuTroisBoutons.Y, MenuTroisBoutons.LARGEUR, MenuTroisBoutons.HAUTEUR, selection);
    }
}
