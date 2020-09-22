package vues.affichage;

import modeles.Cellule;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;


/**
 * La classe <code>AfficherCellule</code> est la représentation graphique d'une cellule.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class AfficherCellule extends JLabel {

    /**
     * Constante représentant la couleur par défaut de fond d'une cellule.
     */
    public static final Color DEFAUT_FOND = new Color(240, 240, 240);

    /**
     * Constante représentant la couleur par défaut du texte d'une cellule.
     */
    public static final Color DEFAUT_TEXTE = new Color(0, 0, 0);

    /**
     * Constante représentant la couleur du texte d'une cellule dont la valeur est valide.
     */
    public static final Color VALIDE = new Color(0, 0, 255);

    /**
     * Constante représentant la couleur du texte d'une cellule dont la valeur n'est pas valide.
     */
    public static final Color INVALIDE = new Color(255, 0, 0);

    /**
     * Couleur du texte pour les notes.
     */
    public static final Color COULEUR_NOTES = new Color(120, 120, 180);

    /**
     * Constante représentant la couleur de fond de la cellule active.
     */
    public static final Color ACTIVE = new Color(223, 242, 255);

    /**
     * Constante représentant la couleur de fond d'une cellule posant problème.
     */
    public static final Color POSE_PROBLEME = new Color(253, 76, 83);

    /**
     * Abscisse de la cellule.
     */
    private byte positionX;

    /**
     * Ordonnée de la cellule.
     */
    private byte positionY;

    /**
     * Constructeur affichant la valeur de la cellule correspondante.
     *
     * @param c la cellule associée
     * @param x l'abscisse de la cellule à l'écran
     * @param y l'ordonnée de la cellule à l'écran
     */
    public AfficherCellule(Cellule c, int x, int y) {
        super();
        if (c.getValeur() == 0) {
            this.setText("");
        } else {
            this.setText(Byte.toString(c.getValeur()));
        }
        this.setFont(new Font("Arial", Font.BOLD, 20));

        this.positionX = (byte) x;
        this.positionY = (byte) y;

        this.setOpaque(true);
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    /**
     * Retourne l'abscisse de la cellule à l'écran.
     *
     * @return l'abscisse de la cellule
     */
    public byte getPositionX() {
        return this.positionX;
    }

    /**
     * Retourne l'ordonnée de la cellule à l'écran.
     *
     * @return l'ordonnée de la cellule
     */
    public byte getPositionY() {
        return this.positionY;
    }
}
