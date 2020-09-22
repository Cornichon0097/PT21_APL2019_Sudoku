package vues;

import vues.messages.Erreur;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JOptionPane;
import java.io.File;


/**
 * La classe <code>ChoisirFichier</code> ouvre un explorateur de fichier pour
 * choisir une grille depuis un fichier.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class ChoisirFichier extends JFileChooser{

    /**
     * Constante correspondant à l'extension de fichier à respecter.
     */
    public static final String EXTENSION = ".gri";

    /**
     * Nom du fichier choisi par l'utilisateur.
     */
    private String nomDuFichier;

    /**
     * Si l'utilisateur a choisi ou non.
     */
    private boolean aChoisis;

    /**
     * Constructeur qui ouvre un explorateur de fichier.
     */
    public ChoisirFichier() {
        /* ".gri" */
        // System.getProperty("user.dir")

		super(System.getProperty("user.dir"));


        this.setDialogTitle("Choisir une grille à charger : ");
		this.setFileSelectionMode(JFileChooser.FILES_ONLY);

        this.choisir();
	}

    /**
     * Retourne si l'utilisateur a choisi ou non.
     *
     * @return true si l'utilisateur a choisi un fichier, false sinon
     */
    public boolean getAChoisis() {
        return this.aChoisis;
    }

    /**
     * Retourne le nom du fichier choisi par l'utilisateur.
     *
     * @return le nom du fichier choisi par l'utilisateur
     */
    public String getNomDuFichier() {
        return this.nomDuFichier;
    }

    /**
     * Laisse l'utilisateur choisir un fichier.
     */
    private void choisir() {
        int actionUser = this.showSaveDialog(null);

        if (actionUser == JFileChooser.APPROVE_OPTION) {
            this.nomDuFichier = this.getSelectedFile().getAbsolutePath();
            this.aChoisis = true;

            if (!this.nomDuFichier.endsWith(ChoisirFichier.EXTENSION)) {
                // this.nomDuFichier += ChoisirFichier.EXTENSION;

                new Erreur("Le fichier " + this.getSelectedFile() + " n'est pas une grille, il n'a pas l'extension \".gri\".");
                this.aChoisis = false;
                // this.nomDuFichier = null;
            }
        }
        else if (actionUser == JFileChooser.CANCEL_OPTION) {
            // new Erreur(this.getClass() + " : annuler");
            this.aChoisis = false;
        }
    }
}
