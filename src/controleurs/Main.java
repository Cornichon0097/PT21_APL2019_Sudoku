import vues.menus.MenuAccueil;

/**
 * La classe <code>Main</code> contient le main.
 *
 * @version 1.0
 * @author Adrien Costandi, Antoni Blanche
 */
public class Main {

    /**
     * Lance le menu d'accueil.
     *
     * @param args les arguments passés en ligne de commande (pas pris en compte)
     */
    public static void main(String[] args) {
        MenuAccueil accueil = new MenuAccueil();
        accueil.setVisible(true);
    }
}
