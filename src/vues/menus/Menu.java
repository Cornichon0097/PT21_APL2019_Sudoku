package vues.menus;

import vues.Fenetre;

import javax.swing.JButton;


/**
 * La classe <code>Menu</code> sert à créer un menu avec des boutons.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public abstract class Menu extends Fenetre {

    /**
     * Tableau des boutons du menu.
     */
    protected JButton[] boutons;

    /**
     * Nombre de boutons du menu.
     */
    protected int nombreDeBoutons;

    /**
     * Constructeur servant uniquement à mettre en page le menu.
     *
     * @param texteDesBoutons le tableau contenant le texte de chaque bouton
     */
    public Menu(int x, int y, int largeur, int hauteur, String[] texteDesBoutons) {
        /* Caractéristiques de la fenêtre. */
        super(x, y, largeur, hauteur, "Menu");
        /* Le nombre de boutons est défini par la taille du tableau de String. */
        this.nombreDeBoutons = texteDesBoutons.length;
        /* Les différents boutons du menu. */
        this.boutons = new JButton[this.nombreDeBoutons];

        /* Chaque bouton contient le texte présent dans le tableau de String à
        la position qui correspond à sa position dans le tableau de boutons. */
        for (byte i = 0; i < this.nombreDeBoutons; i++) {
            this.boutons[i] = new JButton(texteDesBoutons[i]);
            /* Disposition des boutons à l'écran. Leur taille et leur position
            sont adaptées en fonction de la taille de la fenêtre au moment de la création. */
            this.boutons[i].setSize((largeur - 100),
                                    (hauteur / ((this.nombreDeBoutons * 2) + 1)));
            this.boutons[i].setLocation(50,
                                        (i * (hauteur / (this.nombreDeBoutons + 1)) + (hauteur / 10)));
            this.affichage.add(this.boutons[i]);
        }
    }

    /**
     * Attribue une action à chaque bouton.
     */
    public abstract void setAction();
}
