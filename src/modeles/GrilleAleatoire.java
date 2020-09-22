package modeles;

import modeles.Grille;
import modeles.Cellule;

import controleurs.assistance.Inspecteur;

import java.util.Random;


/**
 * La classe <code>GrilleAleatoire</code> génère une grille générée aléatoirement.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class GrilleAleatoire extends Grille {

    /**
     * Constructeur qui génère la grille aléatoirement.
     */
     public GrilleAleatoire() {
         super();
         // for (byte i = 0; i < Grille.TAILLE; i++) {
         //     for (byte j = 0; j < Grille.TAILLE; j++) {
         //         this.tableau[((i*3)+(i/3))%Grille.TAILLE][j] = new Cellule(((i + j) %Grille.TAILLE + 1), (((i*3)+(i/3))%Grille.TAILLE), j);
         //     }
         // }
         this.remplir((int)(Math.pow(Grille.TAILLE, 2)), 0, 0);
         // this.melanger();
         this.retirerValeurs(50);
         // System.out.println(this.toString());
     }

     /**
      * Méthode reprise du solveur, ajoutée au dernier moment
      * car l'angoisse d'une grille aléatoire pas suffisamment aléatoire me
      * rongeait.
      *
      * Méthode récursive, retourne si la grille est solvable ou non.
      *
      * @param nombreDeCaseARemplir le nombre de cases qu'il reste à remplir
      * @param x la position x d'une cellule
      * @param y la position y d'une cellule
      *
      * @return true si la grille est solvable, false sinon
      */
     public boolean remplir(int nombreDeCaseARemplir, int x, int y) {

         /* S'il ne reste aucune case vide, alors la grille est résolue. */
         if (nombreDeCaseARemplir == 0) {
             return true;
         }

         /* Pour passer à la ligne suivante. */
         if (y == Grille.TAILLE) {
             x++;
             y = 0;
         }

         Cellule cellule = this.getCellule(x, y);

         /* Si la cellule possède déjà une valeur, retourne le statut de la suivante. */
         if (cellule.getValeur() != 0) {
             return this.remplir(nombreDeCaseARemplir, x, (y+1));
         } else {
             Inspecteur gadget = new Inspecteur(this);
             Random r = new Random();
             int val = 0, index = 0;
             int[] listeVal = new int[Grille.TAILLE];

             for (byte i = 0; i < Grille.TAILLE; i++) {
                 listeVal[i] = i+1;
             }

             /* Essaye de mettre les valeurs de 1 à 9 dans la cellule. */
             for (int i = 1; i <= 9; i++) {
                 do {
                     index = r.nextInt(9);
                     val = listeVal[index];
                 } while (val == 0);
                 listeVal[index] = 0;
                 /* Si la valeur peut être mise dans le cellule : */
                 if (gadget.verifierCellule(cellule, val)) {
                     cellule.setValeur(val);
                     /* Affiche la valeur à l'écran. */
                     // this.affichage[x][y].setCouleurTexte(AfficherCellule.VALIDE);
                     // this.affichage[x][y].setTexte(Integer.toString(val));
                     /* Passe à la cellule suivante. */
                     if (this.remplir((nombreDeCaseARemplir-1), x, (y+1))) {
                         /* Retourne true si le statut de la cellule précédente
                         est true lui aussi. */
                         return true;
                     }
                 }
                 /* Si aucune valeur ne peut être mise dans la cellule, celle-ce
                 est remise à zéro. */
                 cellule.setValeur(0);
             }
         }

         /* Retourne false si aucune valeur n'a pu être mise dans la cellule. */
         return false;
     }


     /**
      * Permute deux lignes.
      *
      * @param i la position de la 1ère ligne
      * @param j la position de la 2ère ligne
      */
    private void swapLignes(int x1, int x2) {

        byte val = 0;

        for (int col = 0; col < Grille.TAILLE; col++) {
            val = this.getCellule(x1, col).getValeur();
            this.getCellule(x1, col).setValeur(this.getCellule(x2, col).getValeur());
            this.getCellule(x2, col).setValeur(val);
        }
    }

    /**
     * Permute deux colonnes.
     *
     * @param i la position de la 1ère colonne
     * @param j la position de la 2ère colonne
     */
    private void swapColonnes(int y1, int y2) {
        byte val = 0;

        for (int ligne = 0; ligne < Grille.TAILLE; ligne++) {
            val = this.getCellule(ligne, y1).getValeur();
            this.getCellule(ligne, y1).setValeur(this.getCellule(ligne, y2).getValeur());
            this.getCellule(ligne, y2).setValeur(val);
        }
    }

    /**
     * Mélange la grille.
     */
    private void melanger() {
        Random r = new Random();
		int repeter = r.nextInt(10000)+1000;
        int ligne, colonne;
        int cote;
        // System.out.println(repeter);


        for (int i = 0; i < repeter; i++) {
            cote = r.nextInt(2);

            if (cote == 0) {
                // System.out.println("ligne");

                ligne = r.nextInt(9);

                if (ligne % 3 == 1) {
                    if (r.nextInt(2) == 0) {
                        this.swapLignes(ligne, ligne+1);
                    }
                    else {
                        this.swapLignes(ligne, ligne-1);
                    }
                }

                else if (ligne % 3 == 2) {
                    this.swapLignes(ligne, ligne-1);
                }

                else {
                    this.swapLignes(ligne, ligne+1);
                }
            }
            else {
                colonne = r.nextInt(9);
                // System.out.println("colonne");

                if (colonne % 3 == 1) {
                    if (r.nextInt(2) == 0) {
                        this.swapColonnes(colonne, colonne+1);
                    }
                    else {
                        this.swapColonnes(colonne, colonne-1);
                    }
                }
                else if (colonne % 3 == 2) {
                    this.swapColonnes(colonne, colonne-1);
                }
                else {
                    this.swapColonnes(colonne, colonne+1);
                }
            }

        }
    }

    /**
     * Retire n valeurs dans la grille.
     *
     * @param n le nombre de valeurs à retirer de la grille
     */
    public void retirerValeurs(int n) {
        int x;
        int y;

        for (byte i = 0; i < n; i++) {
            Random r = new Random();
            x = r.nextInt(Grille.TAILLE);
    		y = r.nextInt(Grille.TAILLE);

            this.setCellule(new Cellule(0, x, y), x, y);
        }
    }
}
