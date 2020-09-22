package controleurs.fichiers;

import modeles.Grille;
import modeles.Cellule;

import vues.messages.Erreur;

import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * La classe <code>Ecrivain</code> est un contrôleur spécilisé
 * dans l'écriture d'une grille dans un fichier au format ".gri"
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class Ecrivain {

    /**
     * Représentation du fichier.
     */
    private FileOutputStream fichier;

    /**
     * Représentation du flux d'octets.
     */
    private DataOutputStream flux;

    /**
     * Constructeur d'écrivain, nécessite un nom de fichier.
     *
     * @param nom le nom du fichier
     */
    public Ecrivain(String nom) {

        try {
            this.fichier = new FileOutputStream(nom);
            this.flux = new DataOutputStream(fichier); // pour du write
        }
        catch (FileNotFoundException e) {
            new Erreur("Impossible de créer un nouveau fichier. " + this.getClass());
        }
        catch (NullPointerException e) {
            new Erreur("Veuillez sélectionner un fichier au format \".gri\". " + this.getClass());
        }

    }

    /**
     * Ecrit la représentation de la grille dans le fichier au format ".gri".
     *
     * @param grille la grille à écrire dans le fichier.
     */
    public void ecrireFichier(Grille grille) {
        Cellule[] ligne = new Cellule[Grille.TAILLE];
        String ligneInt = "";
        for (byte i = 0; i < Grille.TAILLE; i++) {
            ligne = grille.getLigne(i);
            ligneInt = "";
            for (byte j = 0; j < Grille.TAILLE; j++) {
                ligneInt += "" + ligne[j].getValeur();
                // System.out.println("char : "+ligne[j].getValeur());
            }
            // System.out.println("ligne : "+ligneInt);

            try {
                this.flux.writeInt(Integer.parseInt(ligneInt));
            }
            catch (IOException e) {
                new Erreur(" Impossible d'écrire dans le fichier." + this.getClass());
            }
            catch (NullPointerException e) {
                // new Erreur("Veuillez sélectionner un fichier au format \".gri\". " + this.getClass());
                return;
            }
        }
    }

    //
    // public void ecrire(Grille g) {
    //     Cellule[] l = new Cellule[9];
    //     String entier = "";
    //     for (byte i = 0; i < 9; i++) {
    //         l = g.getLigne(i);
    //
    //         for (byte j = 0; j < l.length; j++) {
    //             if (l[j].getValeur() != 0) {
    //                 entier += ""+l[j].getValeur();
    //             }
    //         }
    //         entier += "\n";
    //
    //     }
    //     System.out.print(entier);
    // }
}
