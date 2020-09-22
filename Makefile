# --------------- Les sources --------------- #
SOURCE=./src/

# --------------- Les modèles --------------- #
S_MODELES=$(SOURCE)modeles/

# --------------- Les vues --------------- #
S_VUES=$(SOURCE)vues/

SV_MENUS=$(S_VUES)menus/
SV_SUDOKU=$(S_VUES)sudoku/
SV_AFFICHAGE=$(S_VUES)affichage/
SV_FICHIERS=$(S_VUES)fichiers/
SV_MESSAGES=$(S_VUES)messages/

# --------------- Les contrôleurs --------------- #
S_CONTROLEURS=$(SOURCE)controleurs/

SC_MENUS=$(S_CONTROLEURS)menus/
SC_UTILISATEUR=$(S_CONTROLEURS)utilisateur/
SC_ASSISTANCE=$(S_CONTROLEURS)assistance/
SC_FICHIERS=$(S_CONTROLEURS)fichiers/


# --------------- Les classes --------------- #
BUILD=./class/

# --------------- Les modèles --------------- #
B_MODELES=$(BUILD)modeles/

# --------------- Les vues --------------- #
B_VUES=$(BUILD)vues/

BV_MENUS=$(B_VUES)menus/
BV_SUDOKU=$(B_VUES)sudoku/
BV_AFFICHAGE=$(B_VUES)affichage/
BV_MESSAGES=$(B_VUES)messages/

# --------------- Les contrôleurs --------------- #
B_CONTROLEURS=$(BUILD)controleurs/

BC_MENUS=$(B_CONTROLEURS)menus/
BC_UTILISATEUR=$(B_CONTROLEURS)utilisateur/
BC_ASSISTANCE=$(B_CONTROLEURS)assistance/
BC_FICHIERS=$(B_CONTROLEURS)fichiers/


# --------------- Outils de compilation --------------- #
JC=javac
JCFLAGS=--release 8 -encoding UTF-8 -d $(BUILD) -implicit:none -sourcepath "$(SOURCE)" -classpath "$(BUILD)"
JVM=java
JVMFLAGS=-cp


# --------------- But principal --------------- #
but : $(BUILD)Main.class

# --------------- Dépendances --------------- #
# --------------- Main --------------- #
$(BUILD)Main.class : $(S_CONTROLEURS)Main.java \
					 $(BV_MENUS)MenuAccueil.class
	$(JC) $(JCFLAGS) $(S_CONTROLEURS)Main.java


# --------------- Modèles --------------- #
$(B_MODELES)Grille.class : $(S_MODELES)Grille.java \
						   $(B_MODELES)Cellule.class
	$(JC) $(JCFLAGS) $(S_MODELES)Grille.java


$(B_MODELES)GrilleAleatoire.class : $(S_MODELES)GrilleAleatoire.java \
								    $(B_MODELES)Grille.class \
									$(B_MODELES)Cellule.class \
									$(BC_ASSISTANCE)Inspecteur.class
	$(JC) $(JCFLAGS) $(S_MODELES)GrilleAleatoire.java


$(B_MODELES)Cellule.class : $(S_MODELES)Cellule.java \
						    $(B_MODELES)Pile.class
	$(JC) $(JCFLAGS) $(S_MODELES)Cellule.java


$(B_MODELES)Pile.class : $(S_MODELES)Pile.java \
						 $(BV_MESSAGES)Information.class
	$(JC) $(JCFLAGS) $(S_MODELES)Pile.java


$(B_MODELES)Chronometre.class : $(S_MODELES)Chronometre.java
	$(JC) $(JCFLAGS) $(S_MODELES)Chronometre.java


# --------------- Vues --------------- #
$(B_VUES)ChoisirFichier.class : $(S_VUES)ChoisirFichier.java \
								$(BV_MESSAGES)Erreur.class
	$(JC) $(JCFLAGS) $(S_VUES)ChoisirFichier.java


$(B_VUES)Fenetre.class : $(S_VUES)Fenetre.java
	$(JC) $(JCFLAGS) $(S_VUES)Fenetre.java


# --------------- Les menus --------------- #
$(BV_MENUS)Menu.class : $(SV_MENUS)Menu.java \
						$(B_VUES)Fenetre.class
	$(JC) $(JCFLAGS) $(SV_MENUS)Menu.java


$(BV_MENUS)MenuTroisBoutons.class : $(SV_MENUS)MenuTroisBoutons.java \
									$(BV_MENUS)Menu.class
	$(JC) $(JCFLAGS) $(SV_MENUS)MenuTroisBoutons.java


$(BV_MENUS)MenuAccueil.class : $(SV_MENUS)MenuAccueil.java \
							   $(BV_MENUS)MenuTroisBoutons.class \
							   $(BC_MENUS)ActionJouer.class \
							   $(BC_MENUS)ActionCreer.class \
							   $(BC_MENUS)ActionQuitter.class
	$(JC) $(JCFLAGS) $(SV_MENUS)MenuAccueil.java


$(BV_MENUS)MenuGrille.class : $(SV_MENUS)MenuGrille.java \
							  $(BV_MENUS)MenuTroisBoutons.class \
							  $(BC_MENUS)ActionChargerJeu.class \
							  $(BC_MENUS)ActionGrilleAleatoire.class \
							  $(BC_UTILISATEUR)ActionRetour.class
	$(JC) $(JCFLAGS) $(SV_MENUS)MenuGrille.java


$(BV_MENUS)MenuJouer.class : $(SV_MENUS)MenuJouer.java \
							 $(B_MODELES)Grille.class \
							 $(BV_MENUS)Menu.class \
					   		 $(BC_MENUS)ActionManuel.class \
							 $(BC_MENUS)ActionAutomatique.class
	$(JC) $(JCFLAGS) $(SV_MENUS)MenuJouer.java


$(BV_MENUS)MenuCreer.class : $(SV_MENUS)MenuCreer.java \
							 $(BV_MENUS)MenuTroisBoutons.class \
							 $(BC_MENUS)ActionChargerEditeur.class \
							 $(BC_MENUS)ActionGrilleVierge.class \
							 $(BC_UTILISATEUR)ActionRetour.class
	$(JC) $(JCFLAGS) $(SV_MENUS)MenuCreer.java


# --------------- Le sudoku --------------- #
$(BV_SUDOKU)Sudoku.class : $(SV_SUDOKU)Sudoku.java \
						   $(B_MODELES)Grille.class \
						   $(B_VUES)Fenetre.class \
						   $(BV_AFFICHAGE)AfficherGrille.class \
						   $(BV_SUDOKU)Entrees.class
	$(JC) $(JCFLAGS) $(SV_SUDOKU)Sudoku.java


$(BV_SUDOKU)Jeu.class : $(SV_SUDOKU)Jeu.java \
						  $(B_MODELES)Grille.class \
						  $(BV_SUDOKU)Sudoku.class \
						  $(BV_SUDOKU)EntreesJeu.class
	$(JC) $(JCFLAGS) $(SV_SUDOKU)Jeu.java


$(BV_SUDOKU)Editeur.class : $(SV_SUDOKU)Editeur.java \
							$(B_MODELES)Grille.class \
							$(BV_SUDOKU)Sudoku.class \
							$(BV_SUDOKU)EntreesEditeur.class
	$(JC) $(JCFLAGS) $(SV_SUDOKU)Editeur.java


$(BV_SUDOKU)Entrees.class : $(SV_SUDOKU)Entrees.java \
							$(B_VUES)Fenetre.class \
							$(BV_MESSAGES)Information.class \
							$(BC_UTILISATEUR)ActionRetour.class \
							$(BC_UTILISATEUR)ActionCellule.class \
							$(BC_UTILISATEUR)ActionNombre.class \
							$(BC_UTILISATEUR)ActionEffacer.class \
							$(BC_UTILISATEUR)ActionNotes.class
	$(JC) $(JCFLAGS) $(SV_SUDOKU)Entrees.java


$(BV_SUDOKU)EntreesJeu.class : $(SV_SUDOKU)EntreesJeu.java \
							   $(B_VUES)Fenetre.class \
							   $(BV_SUDOKU)Entrees.class \
   							   $(BV_MESSAGES)Information.class \
   							   $(BC_UTILISATEUR)ActionCellule.class \
   							   $(BC_UTILISATEUR)ActionNombre.class \
   							   $(BC_UTILISATEUR)ActionEffacer.class \
   							   $(BC_UTILISATEUR)ActionNotes.class
	$(JC) $(JCFLAGS) $(SV_SUDOKU)EntreesJeu.java


$(BV_SUDOKU)EntreesEditeur.class : $(SV_SUDOKU)EntreesEditeur.java \
							   	   $(B_MODELES)Grille.class \
							   	   $(B_VUES)Fenetre.class \
							   	   $(BV_SUDOKU)Entrees.class \
   							   	   $(BV_MESSAGES)Information.class \
   							   	   $(BC_UTILISATEUR)ActionCellule.class \
   							   	   $(BC_UTILISATEUR)ActionNombre.class \
  							   	   $(BC_UTILISATEUR)ActionEffacer.class \
   							   	   $(BC_UTILISATEUR)ActionNotes.class \
								   $(BC_UTILISATEUR)ActionEnregistrer.class
	$(JC) $(JCFLAGS) $(SV_SUDOKU)EntreesEditeur.java


# --------------- L'affichage --------------- #
$(BV_AFFICHAGE)AfficherGrille.class : $(SV_AFFICHAGE)AfficherGrille.java \
									  $(B_MODELES)Grille.class \
									  $(BV_AFFICHAGE)AfficherCellule.class \
									  $(BC_UTILISATEUR)ActionCellule.class
	$(JC) $(JCFLAGS) $(SV_AFFICHAGE)AfficherGrille.java


$(BV_AFFICHAGE)AfficherCellule.class : $(SV_AFFICHAGE)AfficherCellule.java \
									   $(B_MODELES)Cellule.class
	$(JC) $(JCFLAGS) $(SV_AFFICHAGE)AfficherCellule.java


# --------------- Les messages --------------- #
$(BV_MESSAGES)Information.class : $(SV_MESSAGES)Information.java
	$(JC) $(JCFLAGS) $(SV_MESSAGES)Information.java


$(BV_MESSAGES)Erreur.class : $(SV_MESSAGES)Erreur.java
	$(JC) $(JCFLAGS) $(SV_MESSAGES)Erreur.java


# --------------- Contrôleurs --------------- #
# --------------- Les menus --------------- #
$(BC_MENUS)ActionMenu.class : $(SC_MENUS)ActionMenu.java \
							  $(BV_MENUS)Menu.class
	$(JC) $(JCFLAGS) $(SC_MENUS)ActionMenu.java


$(BC_MENUS)ActionJouer.class : $(SC_MENUS)ActionJouer.java \
							   $(BV_MENUS)Menu.class \
							   $(BV_MENUS)MenuGrille.class \
							   $(BC_MENUS)ActionMenu.class
	$(JC) $(JCFLAGS) $(SC_MENUS)ActionJouer.java


$(BC_MENUS)ActionCreer.class : $(SC_MENUS)ActionCreer.java \
							   $(BV_MENUS)Menu.class \
							   $(BV_MENUS)MenuCreer.class \
							   $(BC_MENUS)ActionMenu.class
	$(JC) $(JCFLAGS) $(SC_MENUS)ActionCreer.java


$(BC_MENUS)ActionManuel.class : $(SC_MENUS)ActionManuel.java \
								$(B_MODELES)Grille.class \
								$(SV_MENUS)Menu.java \
								$(BV_SUDOKU)Jeu.class \
								$(BC_MENUS)ActionMenu.class
	$(JC) $(JCFLAGS) $(SC_MENUS)ActionManuel.java


$(BC_MENUS)ActionAutomatique.class : $(SC_MENUS)ActionAutomatique.java \
									 $(B_MODELES)Grille.class \
									 $(B_MODELES)Chronometre.class \
									 $(SV_MENUS)Menu.java \
									 $(BV_SUDOKU)Jeu.class \
									 $(BC_MENUS)ActionMenu.class \
									 $(BC_ASSISTANCE)Solveur.class
	$(JC) $(JCFLAGS) $(SC_MENUS)ActionAutomatique.java


$(BC_MENUS)ActionChargerJeu.class : $(SC_MENUS)ActionChargerJeu.java \
									$(B_MODELES)Grille.class \
									$(BV_MENUS)Menu.class \
									$(BV_MENUS)MenuJouer.class \
									$(BV_SUDOKU)Jeu.class \
									$(BC_MENUS)ActionMenu.class \
									$(BC_FICHIERS)ChargerGrille.class
	$(JC) $(JCFLAGS) $(SC_MENUS)ActionChargerJeu.java


$(BC_MENUS)ActionChargerEditeur.class : $(SC_MENUS)ActionChargerEditeur.java \
										$(B_MODELES)Grille.class \
										$(BV_MENUS)Menu.class \
										$(BV_SUDOKU)Editeur.class \
										$(BC_MENUS)ActionMenu.class \
										$(BC_FICHIERS)ChargerGrille.class
	$(JC) $(JCFLAGS) $(SC_MENUS)ActionChargerEditeur.java


$(BC_MENUS)ActionGrilleVierge.class : $(SC_MENUS)ActionGrilleVierge.java \
									  $(B_MODELES)Grille.class \
									  $(BV_MENUS)Menu.class \
									  $(BV_SUDOKU)Editeur.class \
									  $(BC_MENUS)ActionMenu.class
	$(JC) $(JCFLAGS) $(SC_MENUS)ActionGrilleVierge.java


$(BC_MENUS)ActionGrilleAleatoire.class : $(SC_MENUS)ActionGrilleAleatoire.java \
										 $(B_MODELES)GrilleAleatoire.class \
										 $(BV_MENUS)Menu.class \
										 $(BV_SUDOKU)Jeu.class \
										 $(BC_MENUS)ActionMenu.class
	$(JC) $(JCFLAGS) $(SC_MENUS)ActionGrilleAleatoire.java


$(BC_MENUS)ActionQuitter.class : $(SC_MENUS)ActionQuitter.java
	$(JC) $(JCFLAGS) $(SC_MENUS)ActionQuitter.java


# --------------- L'utilisateur --------------- #
$(BC_UTILISATEUR)ActionCellule.class : $(SC_UTILISATEUR)ActionCellule.java \
									   $(B_MODELES)Grille.class \
									   $(B_MODELES)Cellule.class \
									   $(SV_AFFICHAGE)AfficherGrille.java \
									   $(BV_AFFICHAGE)AfficherCellule.class
	$(JC) $(JCFLAGS) $(SC_UTILISATEUR)ActionCellule.java


$(BC_UTILISATEUR)ActionUtilisateur.class : $(SC_UTILISATEUR)ActionUtilisateur.java \
										   $(B_MODELES)Cellule.class \
	 									   $(BV_AFFICHAGE)AfficherCellule.class \
	 									   $(BV_MESSAGES)Information.class \
	 									   $(BC_UTILISATEUR)ActionCellule.class
	$(JC) $(JCFLAGS) $(SC_UTILISATEUR)ActionUtilisateur.java


$(BC_UTILISATEUR)ActionNombre.class : $(SC_UTILISATEUR)ActionNombre.java \
									  $(BV_AFFICHAGE)AfficherCellule.class \
									  $(BC_ASSISTANCE)Rapporteur.class \
									  $(BC_UTILISATEUR)ActionCellule.class \
									  $(BC_UTILISATEUR)ActionUtilisateur.class \
									  $(BC_UTILISATEUR)ActionNotes.class
	$(JC) $(JCFLAGS) $(SC_UTILISATEUR)ActionNombre.java


$(BC_UTILISATEUR)ActionEffacer.class : $(SC_UTILISATEUR)ActionEffacer.java \
									   $(BV_AFFICHAGE)AfficherCellule.class \
									   $(BC_UTILISATEUR)ActionCellule.class \
									   $(BC_UTILISATEUR)ActionUtilisateur.class \
									   $(BC_UTILISATEUR)ActionNotes.class
	$(JC) $(JCFLAGS) $(SC_UTILISATEUR)ActionEffacer.java


$(BC_UTILISATEUR)ActionNotes.class : $(SC_UTILISATEUR)ActionNotes.java
	$(JC) $(JCFLAGS) $(SC_UTILISATEUR)ActionNotes.java


$(BC_UTILISATEUR)ActionEnregistrer.class : $(SC_UTILISATEUR)ActionEnregistrer.java \
										   $(B_MODELES)Grille.class \
										   $(B_VUES)ChoisirFichier.class \
										   $(BC_FICHIERS)Ecrivain.class
	$(JC) $(JCFLAGS) $(SC_UTILISATEUR)ActionEnregistrer.java


$(BC_UTILISATEUR)ActionRetour.class : $(SC_UTILISATEUR)ActionRetour.java \
									  $(B_VUES)Fenetre.class \
									  $(SV_MENUS)MenuAccueil.java
	$(JC) $(JCFLAGS) $(SC_UTILISATEUR)ActionRetour.java


# --------------- L'assistance --------------- #
$(BC_ASSISTANCE)Inspecteur.class : $(SC_ASSISTANCE)Inspecteur.java \
								   $(B_MODELES)Grille.class \
								   $(B_MODELES)Cellule.class
	$(JC) $(JCFLAGS) $(SC_ASSISTANCE)Inspecteur.java


$(BC_ASSISTANCE)Rapporteur.class : $(SC_ASSISTANCE)Rapporteur.java \
								   $(B_MODELES)Grille.class \
								   $(BV_AFFICHAGE)AfficherCellule.class \
								   $(BC_ASSISTANCE)Inspecteur.class
	$(JC) $(JCFLAGS) $(SC_ASSISTANCE)Rapporteur.java


$(BC_ASSISTANCE)Solveur.class : $(SC_ASSISTANCE)Solveur.java \
								$(B_MODELES)Grille.class \
								$(B_MODELES)Cellule.class \
								$(BV_AFFICHAGE)AfficherGrille.class \
								$(BV_AFFICHAGE)AfficherCellule.class \
								$(BC_ASSISTANCE)Inspecteur.class
	$(JC) $(JCFLAGS) $(SC_ASSISTANCE)Solveur.java


# --------------- Les fichiers --------------- #
$(BC_FICHIERS)ChargerGrille.class : $(SC_FICHIERS)ChargerGrille.java \
									$(B_MODELES)Grille.class \
									$(B_VUES)ChoisirFichier.class \
									$(SV_MENUS)MenuAccueil.java \
									$(BC_FICHIERS)Lecteur.class
	$(JC) $(JCFLAGS) $(SC_FICHIERS)ChargerGrille.java


$(BC_FICHIERS)Ecrivain.class : $(SC_FICHIERS)Ecrivain.java \
							   $(B_MODELES)Grille.class \
							   $(B_MODELES)Cellule.class \
							   $(BV_MESSAGES)Erreur.class
	$(JC) $(JCFLAGS) $(SC_FICHIERS)Ecrivain.java


$(BC_FICHIERS)Lecteur.class : $(SC_FICHIERS)Lecteur.java \
							  $(B_MODELES)Grille.class \
							  $(B_MODELES)Cellule.class \
							  $(BV_MESSAGES)Erreur.class
	$(JC) $(JCFLAGS) $(SC_FICHIERS)Lecteur.java


# --------------- Les règles --------------- #
run : but
	$(JVM) $(JVMFLAGS) $(BUILD) Main

jarExe : but
	jar --create --file Sudoku.jar --manifest Manifest.md -C class/ .

javadoc : but
	@javadoc -d javadoc/ $(shell find ./src -name *.java)

clean :
	rm -rf ./class/*

.PHONY : run \
		 jarExe \
		 javadoc \
		 clean
