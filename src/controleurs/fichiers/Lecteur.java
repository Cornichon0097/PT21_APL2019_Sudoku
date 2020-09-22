package controleurs.fichiers;

import modeles.Grille;
import modeles.Cellule;

import vues.messages.Erreur;

import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * La classe <code>Lecture</code> lit une grille depuis un fichier.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class Lecteur {

    /**
     * Le fichier choisi.
     */
    private FileInputStream fichier;

    /**
     * Le flux de lecture.
     */
    private DataInputStream flux;

    /**
     * Mode d'accès à la grille.
     */
    private boolean edition;

    /**
     * Constructeur vérifiant si le fichier peut être lu.
     *
     * @param nom le nom du fichier
     * @param e le mode d'accès à la grille
     */
    public Lecteur(String nom, boolean e) {

        try {
            this.fichier = new FileInputStream(nom);
            this.flux = new DataInputStream(fichier); // pour du write
        }
        catch (FileNotFoundException f) {
            new Erreur(this.getClass() + " : impossible d'ouvrir le fichier " + nom);
        }
        catch (NullPointerException n) {
            new Erreur(this.getClass() + " : abandon");
            System.exit(1);
        }

        this.edition = e;
    }

    /**
     * Lit le fichier ouvert, et retourne la grille qu'il contient.
     *
     * @return la grille du fichier
     */
    public Grille lireFichier() {
        Grille grille = new Grille();
        Cellule cellule = null;
        int valeur = 0;
        int l = 0;

        try {
            for (int ligne = 0; ligne < Grille.TAILLE; ligne++) {
                l = this.flux.readInt();

                for (int colonne = Grille.TAILLE - 1; colonne >= 0; colonne--) {
                    valeur = l%10;
                    l = l/10;

                    if (edition) {
                        cellule = new Cellule(valeur, ligne, colonne, edition);
                    } else {
                        cellule = new Cellule(valeur, ligne, colonne);
                    }

                    grille.setCellule(cellule, ligne, colonne);
                }
            }
        }
        catch (IOException e) {
            new Erreur(this.getClass() + " : impossible de lire le fichier " + this.fichier);
            System.exit(0);
        }
        catch (NullPointerException e) {
            // new Erreur("Veuillez sélectionner un fichier au format \".gri\". " + this.getClass());
            // return;
        }

        return grille;
    }
}
