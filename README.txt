SIMQRI SIRIUS - SETTING UP A DEVELOPMENT ENVIRONMENT
----------------------------------------------------

3 Eclipse IDEs required : 

1) Obeo Designer Community 9.0
	* Level 0 instance : 
		- be.cetic.simqri.metamodel (Meta-model of SimQRI for Sirius)
		- be.cetic.simqri.metamodel.edit
		- be.cetic.simqri.metamodel.editor (Modelling project creation wizard)
	* Level 1 instance :
		- be.cetic.simqri.cockpit (Simulation management)
		- be.cetic.simqri.design (Sirius project)
		- be.cetic.simqri.wizard (SimQRI project creation wizard)
		- be.cetic.simqri.help (Local Website for help contents)
		- be.cetic.simqri.feature (Content of the SimQRI update site)
		- be.cetic.simqri.update (SimQRI update site)
	* Level 2 instance :
		- simqri.beergame (Test project)

2) Eclipse BIRT IDE
	- be.cetic.simqri.reports (Report templates design)

3) Scala IDE for Eclipse (or Intellij)
	- be.cetic.simqri.oscar ("DES" package of the OscaR library, tailored to SimQRi)
	- be.cetic.simqri.simulator (Mapping data from SimQRI Sirius to OscaR Engine)

	/!\ A JAR file of those two projects must be present into the "/lib" repository of the following projects : 
		- be.cetic.simqri.cockpit (Simulation management)
		- be.cetic.simqri.design (Sirius project)


APIs VERSIONS USED
-----------------
* Sirius : 4.0
* Java library: 1.8
* Scala library: 2.11.8
* Scala parser combinator: 2.11-1.0.4
* OscaR: latest update by Renaud
* BIRT Report Engine API: 4.4.2
* EEF: 1.5

IMPORTANT POINTS OF ATTENTION DURING DEVELOPMENT ENVIRONMENT SET UP
-------------------------------------------------------------------

* Update sites to add to Obeo Designer : 
	- BIRT Chart OSGi Runtime SDK Feature - http://download.eclipse.org/birt/update-site/4.4/
	- BIRT Engine OSGi Runtime SDK Feature - http://download.eclipse.org/birt/update-site/4.4/
	- Extended Editing Framework - EMF Edit generation using Acceleo (see Eclipse Marketplace)
	- Extended Editing Framework - SDK (see Eclipse Marketplace)

Note : BIRT Update Sites first require to install some other dependencies 
	-> voir http://download.eclipse.org/birt/downloads/

PACKAGING AN IDE INCLUDING SIMQRI
---------------------------------

1) Download "Obeo Designer"
2) Install the plug-ins required to install BIRT : 
	* http://www.eclipse.org/datatools/downloads.php
	* http://www.eclipse.org/modeling/emf/downloads/?project=emf
3) Install BIRT plug-ins: 
	* http://wiki.eclipse.org/BIRT_Update_Site_URL
		- BIRT Chart OSGi Runtime SDK Feature
		- BIRT Engine OSGi Runtime SDK Feature
4) Copy the "simqri-reports" repository containing the "overall-template" and
   "detailed-template" report templates into the Eclipse installation directory (See installation guide)
5) Install and test SimQRI from update site (project creation wizard, user manual, simulations, etc.)
6) Uninstall useless plug-ins (BIRT dependencies installed at 2)
6) Zip all IDE files


