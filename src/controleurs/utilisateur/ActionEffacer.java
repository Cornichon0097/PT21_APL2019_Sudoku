package controleurs.utilisateur;

import vues.affichage.AfficherCellule;

import controleurs.utilisateur.ActionUtilisateur;
import controleurs.utilisateur.ActionCellule;


/**
 * La classe <code>ActionEffacer</code> permet d'effacer une valeur dans une cellule.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class ActionEffacer extends ActionUtilisateur {

    /**
     * Constructeur faisant appel au constructeur d'ActionUtilisateur.
     *
     * @param c le contrôleur lié aux cellules
     * @param n le contrôleur lié aux notes
     */
    public ActionEffacer(ActionCellule c, ActionNotes n) {
        super(c, n);
    }

    /**
     * La liste d'actions à exécuter en cas de clique sur le bouton.
     *
     * @param texteDuBouton le texte du bouton
     */
    @Override public void faireAction(String texteDuBouton) {
        if (this.cellule.empty()) {
            this.cellule.setValeur(0);
        } else {
            this.cellule.pop();
            this.afficherCellule.setForeground(AfficherCellule.COULEUR_NOTES);
        }
        this.afficherCellule.setText(cellule.toString());
    }
}
