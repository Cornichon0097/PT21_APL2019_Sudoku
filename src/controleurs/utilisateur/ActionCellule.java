package controleurs.utilisateur;

import modeles.Grille;
import modeles.Cellule;

import vues.affichage.AfficherGrille;
import vues.affichage.AfficherCellule;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


/**
 * La classe <code>ActionCellule</code> modifie l'affichage d'une cellule à l'écran.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class ActionCellule implements MouseListener {

    /**
     * La grille de jeu.
     */
    private  Grille grille;

    /**
     * La cellule active (dernière cliquée).
     */
    private Cellule cellule;

    /**
     * Grille à l'écran.
     */
    private AfficherGrille aLEcran;

    /**
     * La cellule affichée active (dernière cliquée).
     */
    private AfficherCellule active;

    /**
     * Constructeur synchronisant les éléments graphiques.
     *
     * @param g la grille de jeu
     * @param a la représentation de la grille à l'écran
     */
    public ActionCellule(Grille g, AfficherGrille a) {
        this.grille = g;
        this.cellule = null;
        this.aLEcran = a;
        this.active = null;
    }

    /**
     * Méthode inutilisée.
     *
     * @param evenement MouseEvent
     */
    @Override public void mouseClicked(MouseEvent evenement) {}

    /**
     * Méthode inutilisée.
     *
     * @param evenement MouseEvent
     */
    @Override public void mouseExited(MouseEvent evenement) {}

    /**
     * Méthode inutilisée.
     *
     * @param evenement MouseEvent
     */
    @Override public void mouseEntered(MouseEvent evenement) {}

    /**
     * Méthode inutilisée.
     *
     * @param evenement MouseEvent
     */
    @Override public void mouseReleased(MouseEvent evenement) {}

    /**
     * Se lance en cas de clique sur une cellule à l'écran.
     *
     * @param evenement les informations sur l'événement
     */
    @Override public void mousePressed(MouseEvent evenement) {
        /* Rafraîchit la fenêtre. */
        this.aLEcran.rafraichir();
        /* La nouvelle cellule active. */
        this.active = (AfficherCellule) evenement.getSource();
        this.active.setBackground(AfficherCellule.ACTIVE);
        /* Le modèle de la cellule en question. */
        this.cellule = this.grille.getCellule(this.active.getPositionX(), this.active.getPositionY());
    }

    /**
     * Retourne la grille.
     *
     * @return la grille.
     */
    public Grille getGrille() {
        return this.grille;
    }

    /**
     * Retourne la cellule active.
     *
     * @return la cellule active
     */
    public Cellule getCelluleActive() {
        return this.cellule;
    }

    /**
     * Retourne la grille à l'écran.
     *
     * @return la grille à l'écran
     */
    public AfficherGrille getAfficherGrille() {
        return this.aLEcran;
    }

    /**
     * Retourne la cellule affichée active.
     *
     * @return la cellule affichée active
     */
    public AfficherCellule getAfficherCelluleActive() {
        return this.active;
    }
}
