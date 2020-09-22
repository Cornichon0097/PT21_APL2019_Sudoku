package controleurs.utilisateur;

import modeles.Grille;

import vues.ChoisirFichier;

import controleurs.fichiers.Ecrivain;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * La classe <code>ActionEnregistrer</code> sauvegarde une grille dans un fichier.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class ActionEnregistrer implements ActionListener {

    /**
     * La grille à sauvegarder.
     */
    private Grille grille;

    /**
     * Constructeur synchronisant ActionEnregistrer et la grille à sauvegarder.
     *
     * @param g la grille à sauvegarder
     */
    public ActionEnregistrer(Grille g) {
        this.grille = g;
    }

    /**
     * Se lance en cas de clic sur le bouton.
     *
     * @param evenement les informations sur l'événement
     */
    @Override public void actionPerformed(ActionEvent evenement) {
        /* Explorateur de fichier. */
        ChoisirFichier choix = new ChoisirFichier();
        String fichier = choix.getNomDuFichier();

        if (choix.getAChoisis()) {
            /* Accès au fichier en mode écriture. */
            Ecrivain moliere = new Ecrivain(fichier);
            /* Ècriture dans le fichier. */
            moliere.ecrireFichier(this.grille);
        }
    }
}
