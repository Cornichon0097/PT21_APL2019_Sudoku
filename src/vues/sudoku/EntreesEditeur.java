package vues.sudoku;

import modeles.Grille;

import vues.Fenetre;
import vues.sudoku.Entrees;
import vues.messages.Information;

import controleurs.utilisateur.ActionCellule;
import controleurs.utilisateur.ActionNombre;
import controleurs.utilisateur.ActionEffacer;
import controleurs.utilisateur.ActionNotes;
import controleurs.utilisateur.ActionEnregistrer;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.FileInputStream;
import javax.imageio.ImageIO;


/**
 * La classe <code>EntreesEditeur</code> affiche des boutons pour interagir
 * avec l'utilisateur dans le mode éditeur.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class EntreesEditeur extends Entrees {

    /**
     * Texte du bouton pour enregistrer la grille.
     */
    public static final String ENREGISTRER = "Enregistrer";

    /**
     * Constructeur servant à mettre en page les entrées pour l'utilisateur et
     * à associer les contrôleurs aux objets.
     *
     * @param grille la grille qui pourra être sauvegardée
     * @param sudoku la fenêtre actuelle à fermer en cas de retour au menu
     * @param actionCellule le contrôleur des cellules
     * @param actionNotes le contrôleur du mode note
     */
    public EntreesEditeur(Grille grille, Fenetre sudoku, ActionCellule actionCellule, ActionNotes actionNotes) {
        super(sudoku, actionCellule, actionNotes);

        JButton enregistrer = new JButton(EntreesEditeur.ENREGISTRER);
        try {
            Image icone = ImageIO.read(new FileInputStream("icon/save.png"));
            icone = icone.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
            enregistrer.setIcon(new ImageIcon(icone));
        } catch (Exception ex) {
            new Information("Impossible de charger certaines icônes");
        }
        enregistrer.addActionListener(new ActionEnregistrer(grille));
        this.add(enregistrer);
    }
}
