package controleurs.utilisateur;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * La classe <code>ActionNotes</code> permet de savoir si le mode note est actif.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class ActionNotes implements ActionListener {

    /**
     * Le mode note.
     */
    private boolean modeNote;

    /**
     * Pas défaut, les notes ne sont pas actives.
     */
    public ActionNotes() {
        this.modeNote = false;
    }

    /**
     * Se lance en cas de clic sur le bouton.
     *
     * @param evenement les informations sur l'événement
     */
    @Override public void actionPerformed(ActionEvent evenement) {
        if (this.modeNote) {
            this.modeNote = false;
        } else {
            this.modeNote = true;
        }
    }

    /**
     * Retourne si le mode note est actif.
     *
     * @return si le mode note est actif
     */
    public boolean isModeNote() {
        return this.modeNote;
    }
}
