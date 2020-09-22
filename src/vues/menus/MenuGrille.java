package vues.menus;

import vues.menus.MenuTroisBoutons;

import controleurs.menus.ActionChargerJeu;
import controleurs.menus.ActionGrilleAleatoire;
import controleurs.utilisateur.ActionRetour;


/**
 * La classe <code>MenuGrille</code> sert à sélectionner une grille de départ.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class MenuGrille extends MenuTroisBoutons {

    /**
     * Constante représentant les différents choix possibles (texte des boutons).
     */
    private static final String[] SELECTION = {"Charger une grille", "Grille aléatoire", "Retour"};

    /**
     * Constructeur qui crée le menu et attribue une action aux boutons.
     */
    public MenuGrille() {
        super(MenuGrille.SELECTION);
        this.setAction();
    }

    /**
     * Attribue une action à chaque bouton.
     */
    @Override public void setAction() {
        this.boutons[0].addActionListener(new ActionChargerJeu(this));
        this.boutons[1].addActionListener(new ActionGrilleAleatoire(this));
        this.boutons[2].addActionListener(new ActionRetour(this));
    }
}
