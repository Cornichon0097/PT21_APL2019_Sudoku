package vues.sudoku;

import vues.Fenetre;
import vues.sudoku.Entrees;
import vues.messages.Information;

import controleurs.utilisateur.ActionCellule;
import controleurs.utilisateur.ActionNombre;
import controleurs.utilisateur.ActionEffacer;
import controleurs.utilisateur.ActionNotes;

import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.FileInputStream;
import javax.imageio.ImageIO;


/**
 * La classe <code>EntreesJeu</code> affiche des boutons pour interagir
 * avec l'utilisateur dans le mode joueur.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class EntreesJeu extends Entrees {

    /**
     * Texte du bouton pour passer en mode note.
     */
    public static final String NOTES = "Notes";

    /**
     * Constructeur servant à mettre en page les entrées pour l'utilisateur et
     * à associer les contrôleurs aux objets.
     *
     * @param sudoku la fenêtre actuelle à fermer en cas de retour au menu
     * @param actionCellule le contrôleur des cellules
     * @param actionNotes le contrôleur du mode note
     */
    public EntreesJeu(Fenetre sudoku, ActionCellule actionCellule, ActionNotes actionNotes) {
        super(sudoku, actionCellule, actionNotes);

        JToggleButton notes = new JToggleButton(EntreesJeu.NOTES);
        try {
            Image icone = ImageIO.read(new FileInputStream("icon/note.png"));
            icone = icone.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
            notes.setIcon(new ImageIcon(icone));
        } catch (Exception ex) {
            new Information("Impossible de charger certaines icônes");
        }
        notes.addActionListener(actionNotes);
        this.add(notes);
    }
}
