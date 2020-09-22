package vues.menus;

import vues.menus.MenuTroisBoutons;

import controleurs.menus.ActionJouer;
import controleurs.menus.ActionCreer;
import controleurs.menus.ActionQuitter;


/**
 * La classe <code>MenuAccueil</code> sert à créer un menu d'accueil.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class MenuAccueil extends MenuTroisBoutons {

    /**
     * Constante représentant les différents choix possibles (texte des boutons).
     */
    private static final String[] SELECTION = {"Jouer", "Créer une grille", "Quitter"};

    /**
     * Constructeur qui crée le menu et attribue une action aux boutons.
     */
    public MenuAccueil() {
        super(MenuAccueil.SELECTION);
        this.setAction();
    }

    /**
     * Attribue une action à chaque bouton.
     */
    @Override public void setAction() {
        this.boutons[0].addActionListener(new ActionJouer(this));
        this.boutons[1].addActionListener(new ActionCreer(this));
        this.boutons[2].addActionListener(new ActionQuitter(this));
    }
}
