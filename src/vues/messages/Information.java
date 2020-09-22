package vues.messages;

import javax.swing.JOptionPane;

/**
 * La classe <code>Information</code> ouvre une fenêtre avec une message d'information.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class Information {

	/**
	 * Constructeur servant uniquement à afficher le message d'information.
	 *
	 * @param message le message d'information
	 */
	public Information(String message) {
        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }
}
