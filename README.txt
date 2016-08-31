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


VERSIONS DES APIs UTILISEES
----------------------------
* Sirius : 4.0
* Java library: 1.8
* Scala library: 2.11.8
* Scala parser combinator: 2.11-1.0.4
* OscaR: latest update by Renaud
* BIRT Report Engine API: 4.4.2
* EEF: 1.5

POINTS D'ATTENTION LORS DE L'INIT DE L'ENVIRONNEMENT DE DEVELOPPEMENT
---------------------------------------------------------------------

* Update sites à installer sur Obeo Designer : 
	- BIRT Chart OSGi Runtime SDK Feature - http://download.eclipse.org/birt/update-site/4.4/
	- BIRT Engine OSGi Runtime SDK Feature - http://download.eclipse.org/birt/update-site/4.4/
	- Extended Editing Framework - EMF Edit generation using Acceleo (voir Eclipse Marketplace)
	- Extended Editing Framework - SDK (voir Eclipse Marketplace)

Note : les updates sites de BIRT nécessitent d'abord l'installation de certaines dépendances 
	-> voir http://download.eclipse.org/birt/downloads/

* La démarche de réalisation d'un nouvel update site pour SimQRi est basée sur celle indiquée dans le
  syllabus fourni par Obeo.

* De l'aide pour la manipulation des projets liés au méta-modèle peut être obtenue sur le wiki de la forge
  intitulée "Stage-SIMQRI-IHM"

* Faire attention à actualiser les .jar d'un projet dans le répertoire /lib des projets concernés
  après la mise à jour du projet faisant l'objet du .jar.

? -> fk@cetic.be

