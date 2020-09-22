package vues;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;


/**
 * La classe <code>Fenetre</code> sert à créer une nouvelle fenêtre.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public abstract class Fenetre extends JFrame {

    /**
     * Panneau dans lequel doit se trouver le contenu à afficher.
     */
    protected JPanel affichage;

    /**
     * Constructeur servant uniquement à la création de la fenêtre.
     * Cette nouvelle fenêtre doit être affichée via un contrôleur.
     *
     * @param x la position (horizontale) de la fenêtre à l'écran (en pixels)
     * @param y la position (verticale) de la fenêtre à l'écran (en pixels)
     * @param largeur la largeur de la fenêtre (en pixels)
     * @param hauteur la hauteur de la fenêtre (en pixels)
     * @param titre le titre de la fenêtre
     */
    public Fenetre(int x, int y, int largeur, int hauteur, String titre) {
        super(titre);
        this.setLocation(x, y);
        this.setSize(largeur, hauteur);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            ImageIcon image = new ImageIcon("icon/edit.png");
            this.setIconImage(image.getImage());
        }
        catch(Exception e){
            /* Dommage, c'est pas grave */
        }

        this.affichage = new JPanel();
        this.affichage.setLayout(null);
        this.add(this.affichage);
    }
}
