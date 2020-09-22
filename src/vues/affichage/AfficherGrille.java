package vues.affichage;

import modeles.Grille;

import vues.affichage.AfficherCellule;

import controleurs.utilisateur.ActionCellule;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.Color;


/**
 * La classe <code>AfficherGrille</code> affiche une grille à la fenêtre.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class AfficherGrille extends JPanel {

    /**
     * Tableau de cellule à l'écran.
     */
    private AfficherCellule[][] aLEcran;

    /**
     * Action attribuée aux cellules de l'écran.
     */
    private ActionCellule action;

    /**
     * Constructeur servant uniquement à l'affichage de la grille.
     *
     * @param aDessiner la grille à dessiner
     */
    public AfficherGrille(Grille aDessiner) {
        super(new GridLayout(3,3));

        /* Chaque région est représentée par un JPanel. */
        JPanel[][] panneaux = new JPanel[3][3];

        /* Chaque région se compose de 9 cellules. */
        for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				panneaux[x][y] = new JPanel(new GridLayout(3, 3));
                panneaux[x][y].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                this.add(panneaux[x][y]);
			}
		}

        this.aLEcran = new AfficherCellule[9][9];
        this.action = new ActionCellule(aDessiner, this);

        /* Chaque cellule est ajoutée une à une. */
        for (int x = 0; x < Grille.TAILLE; x++) {
            for (int y = 0; y < Grille.TAILLE; y++) {
                aLEcran[x][y] = new AfficherCellule(aDessiner.getCellule(x, y), x, y);
                panneaux[x/3][y/3].add(aLEcran[x][y]);
                aLEcran[x][y].addMouseListener(action);
                aLEcran[x][y].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            }
        }
    }

    /**
     * Retourne le tableau de cellules à l'écran.
     *
     * @return le tableau de cellules
     */
    public AfficherCellule[][] getALEcran() {
        return this.aLEcran;
    }

    /**
     * Retourne le contrôleur des cellules.
     *
     * @return le contrôleur des cellules
     */
    public ActionCellule getActionCellule() {
        return this.action;
    }

    /**
     * Rafraîchit la fenêtre.
     */
    public void rafraichir() {
        for (int x = 0; x < Grille.TAILLE; x++) {
            for (int y = 0; y < Grille.TAILLE; y++) {
                this.aLEcran[x][y].setBackground(AfficherCellule.DEFAUT_FOND);
            }
        }
    }
}
