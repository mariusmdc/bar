# Bar à Cocktails

Bar à Cocktails est un simulateur de gestion de bar en JavaFX, permettant de gérer clients, commandes, cocktails et employés avec Happy Hour et interface graphique complète !

Développé en Java avec JavaFX (interface) et architecture POO (backend), il fonctionne avec Maven.

---

##  Fonctionnalités

- **Gestion des clients** : ajout, suppression, suivi du statut (arrivé, commande, boit, payé, parti)
- **Gestion des commandes** : création, ajout de cocktails, préparation, facturation
- **Carte des cocktails** : cocktails avec ou sans alcool (héritage POO)
- **Happy Hour** : réduction automatique de 20% sur toutes les commandes
- **Employés** : barman et serveur avec compétences (vitesse, qualité)
- **Interface JavaFX** : tables interactives, boutons, affichage en temps réel
- **Architecture POO** : héritage (Cocktail, Employee), interface (Bar), encapsulation

---

##  Installation et Lancement

### 1. Cloner le dépôt

```bash
$ git clone <url-du-repo>
$ cd bar
```
### 2. Compiler et lancer avec Maven

```bash
$ mvn clean javafx:run
```

Ou depuis IntelliJ :
- Ouvre le projet Maven
- Lance la classe `Launcher.java`

### 3. Utiliser l'application

- Ajoute un client, crée une commande
- Choisis des cocktails, apporte la commande
- Active le Happy Hour pour voir la réduction
- Facture et supprime le client quand il part

---

##  Arborescence
```text
bar/
├── src/main/java/com/example/bar/
│ ├── Launcher.java
│ ├── HelloApplication.java
│ ├── HelloController.java
│ ├── Client.java
│ ├── ClientStatus.java (enum)
│ ├── Cocktail.java
│ ├── CocktailAvecAlcool.java
│ ├── CocktailSansAlcool.java
│ ├── Order.java
│ ├── Employee.java
│ ├── Barman.java
│ ├── Waiter.java
│ ├── Bar.java (interface)
│ └── SimpleBar.java
├── src/main/resources/com/example/bar/
│ └── hello-view.fxml
├── pom.xml
├── Bar-project-POO.drawio (diagramme UML)
└── README.md
```
## Auteurs du projet

- **Modica Marius**
- **Mvura Jean Paul**
- **Gomes Dias Simão**







