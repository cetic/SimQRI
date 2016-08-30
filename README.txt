SIMQRI SIRIUS - CONFIGURATION DE L ENVIRONNEMENT DE DEVELOPPEMENT
-----------------------------------------------------------------

3 "Eclipse IDE" necessaires : 

1) Obeo Designer Community 9.0
	* Instance de base : 
		- be.cetic.simqri.metamodel (meta-modele de simqri-sirius)
		- be.cetic.simqri.metamodel.edit
		- be.cetic.simqri.metamodel.editor (gère le wizard de creation d'un projet de modélisation)
	* Instance 2 :
		- be.cetic.simqri.cockpit (gestion des simulations)
		- be.cetic.simqri.design (projet sirius)
		- be.cetic.simqri.wizard (wizard de creation d'un nouveau projet simqri)
		- be.cetic.simqri.help (site local du manuel utilisateur)
		- be.cetic.simqri.feature (feature regroupant le contenu de l'update site)
		- be.cetic.simqri.update (projet de l'update site)
	* Instance 3 :
		- simqri.beergame (projet de test)

2) Eclipse BIRT IDE
	- be.cetic.simqri.reports (projet de design des templates de rapports)

3) Scala IDE for Eclipse (ou Intellij, qui est bien meilleur #rdl)
	- be.cetic.simqri.oscar (package "DES" de la librairie OscaR, adaptee a SimQRi)
	- be.cetic.simqri.simulator (mapping des donnees simqri-sirius => OscaR Engine)

	/!\ Un JAR de ces deux projets doit se trouver dans le repertoire /lib des projets suivants : 
		- be.cetic.simqri.cockpit (gestion des simulations)
		- be.cetic.simqri.design (projet sirius)

? -> fk@cetic.be

