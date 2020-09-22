package modeles;

import vues.messages.Information;


/**
 * La classe <code>Pile</code> est une pile de quatre valeurs.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class Pile {

    /**
     * Valeurs de la pile.
     */
    private byte[] valeurs;

    /**
     * Capacité de la pile
     */
    private byte capacite;

    /**
     * Constructeur de la pile.
     */
    public Pile(int c) {
        this.valeurs = new byte[c];
        this.capacite = (byte) c;
    }

    /**
     * Ajoute une valeur à la pile.
     *
     * @param v la valeur à ajouter
     */
    public void push(int v) {
        for (byte i = 0; i < this.capacite; i++) {
            if (this.valeurs[i] == v) {
                new Information("Vous avez déjà mis cette valeur.");
                return;
            }

            if (this.valeurs[i] == 0) {
                this.valeurs[i] = (byte) v;
                return;
            }
        }

        new Information("Vous ne pouvez mettre que " + Byte.toString(this.capacite)
                        + " valeurs au maximum dans une seule case.");
    }

    /**
     * Retire la dernière valeur ajoutée à la pile.
     */
    public byte pop() {
        for (int i = (this.capacite - 1); i >= 0; i--) {
            if (this.valeurs[i] != 0) {
                byte v = this.valeurs[i];
                this.valeurs[i] = 0;
                return v;
            }
        }

        return 0;
    }

    /**
     * Retourne si la pile est vide.
     *
     * @return true si la pile est vide, false sinon
     */
    public boolean empty() {
        if (this.valeurs[0] == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retourne la pile sous forme de String.
     *
     * @return la pile sous forme de String
     */
    @Override public String toString() {
        String texte = "<html>(";

        for (byte i = 0; (i < this.capacite) && (this.valeurs[i] != 0); i++) {
            if (i > 0) {
                texte = texte + ";";
            }
            if (i == 2) {
                texte += "<br/> ";
            }
            texte = texte + Byte.toString(this.valeurs[i]);
        }

        return texte + ")</html>";
    }
}
