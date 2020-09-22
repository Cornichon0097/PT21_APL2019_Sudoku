package vues.menus;

import vues.menus.MenuTroisBoutons;

import controleurs.menus.ActionChargerEditeur;
import controleurs.menus.ActionGrilleVierge;
import controleurs.utilisateur.ActionRetour;


/**
 * La classe <code>MenuCreer</code> sert à créer un menu d'édition.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class MenuCreer extends MenuTroisBoutons {


    /**
     * Constante représentant les différents choix possibles (texte des boutons).
     */
    private static final String[] SELECTION = {"Charger une grille", "Grille vierge", "Retour"};

    /**
     * Constructeur qui crée le menu et attribue une action aux boutons.
     */
    public MenuCreer() {
        super(MenuCreer.SELECTION);
        this.setAction();
    }

    /**
     * Attribue une action à chaque bouton.
     */
    @Override public void setAction() {
        this.boutons[0].addActionListener(new ActionChargerEditeur(this));
        this.boutons[1].addActionListener(new ActionGrilleVierge(this));
        this.boutons[2].addActionListener(new ActionRetour(this));
    }
}
