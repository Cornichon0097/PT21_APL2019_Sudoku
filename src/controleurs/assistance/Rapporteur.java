package controleurs.assistance;

import modeles.Grille;

import vues.affichage.AfficherCellule;

import controleurs.assistance.Inspecteur;


/**
 * La classe <code>Rapporteur</code> affiche à l'écran les rapports de l'inspecteur.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class Rapporteur extends Inspecteur {

    /**
     * Tableau de cellule affichée à l'écran.
     */
    private AfficherCellule[][] affichage;

    /**
     * Constructeur synchronisant le rapporteur et l'affichage.
     *
     * @param g la grille pour l'inspecteur
     * @param a la tableau de cellule à l'écran
     */
    public Rapporteur(Grille g, AfficherCellule[][] a) {
        super(g);
        this.affichage = a;
    }

    /**
     * Met en évidence les problèmes repérés par l'inspecteur.
     */
    public void mettreEnEvidence() {
        for (byte i = 0; i < 3; i++) {
            if (this.quiPosentProbleme[i] != null) {
                this.affichage[this.quiPosentProbleme[i].getPositionX()]
                              [this.quiPosentProbleme[i].getPositionY()]
                              .setBackground(AfficherCellule.POSE_PROBLEME);
            }
        }
    }
}
