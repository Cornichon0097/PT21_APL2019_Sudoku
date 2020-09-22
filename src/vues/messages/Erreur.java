package vues.messages;

import javax.swing.JOptionPane;

/**
 * La classe <code>Erreur</code> ouvre une fenêtre avec une message d'erreur.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class Erreur {

	/**
	 * Constructeur servant uniquement à afficher le message d'erreur.
	 *
	 * @param message le message d'erreur
	 */
	public Erreur(String message) {
		JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}
}
