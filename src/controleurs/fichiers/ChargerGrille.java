package controleurs.fichiers;

import modeles.Grille;

import vues.ChoisirFichier;
import vues.menus.MenuAccueil;

import controleurs.fichiers.Lecteur;


/**
 * La classe <code>ChargerGrille</code> charge une grille depuis un fichier.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class ChargerGrille {

    /**
     * Le mode d'accès à la grille.
     */
    private boolean edition;

    /**
     * Constructeur synchronisant le chargeur et le mode d'accès.
     *
     * @param e le mode d'accès
     */
    public ChargerGrille(boolean e) {
        this.edition = e;
    }

    /**
     * Retourne la grille lu depuis un fichier.
     *
     * @return la grille lu depuis un fichier
     */
    public Grille getGrille() {
        Grille grille = null;
        ChoisirFichier choix = new ChoisirFichier();

        if (choix.getAChoisis()) {
            Lecteur bob = new Lecteur(choix.getNomDuFichier(), this.edition);
            grille = bob.lireFichier();
        } else {
            MenuAccueil accueil = new MenuAccueil();
            accueil.setVisible(true);
        }

        return grille;
    }
}
