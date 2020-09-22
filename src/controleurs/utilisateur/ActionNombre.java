package controleurs.utilisateur;

import vues.affichage.AfficherCellule;
import vues.messages.Information;

import controleurs.utilisateur.ActionUtilisateur;
import controleurs.utilisateur.ActionCellule;
import controleurs.assistance.Rapporteur;


/**
 * La classe <code>ActionNombre</code> permet de remplacer une valeur dans une cellule.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class ActionNombre extends ActionUtilisateur {

    /**
     * Constructeur faisant appel au constructeur d'ActionUtilisateur.
     *
     * @param c le contrôleur lié aux cellules
     * @param n le contrôleur lié aux notes
     */
    public ActionNombre(ActionCellule c, ActionNotes n) {
        super(c, n);
    }

    /**
     * La liste d'actions à exécuter en cas de clique sur le bouton.
     *
     * @param texteDuBouton le texte du bouton
     */
    @Override public void faireAction(String texteDuBouton) {
        int valeur = Integer.parseInt(texteDuBouton);

        /* Si le mode note est désactivé, la valeur est mise directement dans la cellule.
        La pile de valeurs temporaires est alors vidée. */
        if (!(this.actionNotes.isModeNote())) {
            while(!(this.cellule.empty())) {
                this.cellule.pop();
            }
            this.cellule.setValeur(valeur);
        }

        Rapporteur temoin = new Rapporteur(this.actionCellule.getGrille(), this.actionCellule.getAfficherGrille().getALEcran());
        if (temoin.verifierCellule(this.cellule, valeur)) {
            /* En mode note, c'est la valeur de la cellule qui est réinitialisée. */
            if (this.actionNotes.isModeNote()) {
                this.cellule.setValeur(0);
                this.cellule.push(valeur);
                this.afficherCellule.setForeground(AfficherCellule.COULEUR_NOTES);
            } else {
                this.afficherCellule.setForeground(AfficherCellule.VALIDE);
                if (temoin.verifierVictoire()) {
                    new Information("Félicitation : vous avez gagné!");
                }
            }
        } else {
            temoin.mettreEnEvidence();
            this.afficherCellule.setForeground(AfficherCellule.INVALIDE);
        }
        this.afficherCellule.setText(this.cellule.toString());
    }
}
