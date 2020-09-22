package vues.sudoku;

import vues.Fenetre;
import vues.messages.Information;

import controleurs.utilisateur.ActionRetour;
import controleurs.utilisateur.ActionCellule;
import controleurs.utilisateur.ActionNombre;
import controleurs.utilisateur.ActionEffacer;
import controleurs.utilisateur.ActionNotes;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.FileInputStream;
import javax.imageio.ImageIO;


/**
 * La classe <code>Entrees</code> affiche des boutons pour interagir avec l'utilisateur.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class Entrees extends JPanel {

    /**
     * Texte du bouton pour effacer une valeur.
     */
    public static final String EFFACER = "Effacer";

    /**
     * Texte du bouton pour retourner au menu d'accueil.
     */
    public static final String RETOUR = "Accueil";

    /**
     * Constructeur servant à mettre en page les entrées pour l'utilisateur et
     * à associer les contrôleurs aux objets.
     *
     * @param sudoku la fenêtre actuelle à fermer en cas de retour au menu
     * @param actionCellule le contrôleur des cellules
     * @param actionNotes le contrôleur du mode note
     */
    public Entrees(Fenetre sudoku, ActionCellule actionCellule, ActionNotes actionNotes) {
        this.setLayout(new GridLayout(4, 3)); /* grille de 4 lignes */

        JButton[] boutons = new JButton[9];
        boolean image = true;

        ActionNombre nombre = new ActionNombre(actionCellule, actionNotes);
        for (int i = 0; i < 9; i++) {
            boutons[i] = new JButton(Integer.toString(i+1));
            boutons[i].addActionListener(nombre);
            this.add(boutons[i]);
        }

        JButton effacer = new JButton(Entrees.EFFACER);
        try {
            Image icone = ImageIO.read(new FileInputStream("icon/gomme.png"));
            icone = icone.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
            effacer.setIcon(new ImageIcon(icone));
        } catch (Exception ex) {
            image = false;
        }
        effacer.addActionListener(new ActionEffacer(actionCellule, actionNotes));
        this.add(effacer);


        JButton retour = new JButton(Entrees.RETOUR);
        try{
            Image icone = ImageIO.read(new FileInputStream("icon/retour.png"));
            icone = icone.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
            retour.setIcon(new ImageIcon(icone));
        } catch (Exception ex) {
            image = false;
        }
        retour.addActionListener(new ActionRetour(sudoku));
        this.add(retour);


        if (!image) {
            new Information("Impossible de charger certaines icônes");
        }
    }
}
