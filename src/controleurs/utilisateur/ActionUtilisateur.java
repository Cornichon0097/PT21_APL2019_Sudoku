package controleurs.utilisateur;

import modeles.Cellule;

import vues.affichage.AfficherCellule;
import vues.messages.Information;

import controleurs.utilisateur.ActionCellule;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * La classe <code>ActionUtilisateur</code> est une liste d'actions à attribuer
 * à un bouton de l'interface utilisateur.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public abstract class ActionUtilisateur implements ActionListener {

    /**
     * La cellule active.
     */
    protected Cellule cellule;

    /**
     * La cellule affichée active.
     */
    protected AfficherCellule afficherCellule;

    /**
     * Le contrôleur de la cellule.
     */
    protected ActionCellule actionCellule;

    /**
     * Le contrôleur des notes.
     */
    protected ActionNotes actionNotes;

    /**
     * Constructeur synchronisant les contrôleurs.
     *
     * @param a le contrôleur de la cellule
     * @param n le contrôleur des notes
     */
    public ActionUtilisateur(ActionCellule a, ActionNotes n) {
        this.actionCellule = a;
        this.actionNotes = n;
    }

    /**
     * Se lance en cas de clic sur le bouton.
     *
     * @param evenement les informations sur l'événement
     */
    @Override public void actionPerformed(ActionEvent evenement) {
        this.actionCellule.getAfficherGrille().rafraichir();
        String texte = evenement.getActionCommand();

        this.cellule = this.actionCellule.getCelluleActive();

        if (this.cellule == null) {
            new Information("Sélectionnez d'abord une case.");
            return;
        }

        this.afficherCellule = this.actionCellule.getAfficherCelluleActive();
        this.afficherCellule.setBackground(AfficherCellule.ACTIVE);

        if (!(this.cellule.isModifiable())) {
            this.afficherCellule.setBackground(AfficherCellule.POSE_PROBLEME);
            return;
        }

        /* L'envoie du texte du bouton est util pour la valeur sur laquelle
        l'utilisateur vient de cliquer. */
        this.faireAction(texte);
    }

    /**
     * La liste d'actions à exécuter en cas de clique sur le bouton.
     *
     * @param texteDuBouton le texte du bouton
     */
    public abstract void faireAction(String texteDuBouton);
}
