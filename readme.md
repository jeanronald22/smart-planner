# 📘 **README.md – SmartPlanner**

```markdown
# 📅 SmartPlanner  
_application Android moderne pour organiser tâches & projets_

SmartPlanner est une application Android minimaliste conçue pour aider les utilisateurs à organiser leurs tâches quotidiennes et gérer leurs projets.

---

## 🚀 Fonctionnalités (MVP)

### ✅ Inclus dans la première version (MVP)
- Création de tâches (titre + description)
- Modification de tâches
- Suppression de tâches
- Marquer une tâche comme terminée / non terminée
- Création de projets
- Associer une tâche à un projet
- Filtrer les tâches par projet
- Thème clair basé sur Material 3
- Persistance locale avec Room  
- Architecture MVVM propre

### 🔜 Prochaines étapes (Future Release)
- Tags / catégories avancées
- Notifications / rappels
- Mode sombre automatique
- Synchronisation cloud (API FastAPI)
- Widgets Android
- Export / backup

---

## 🧱 Architecture

SmartPlanner utilise une architecture propre et scalable basée sur les bonnes pratiques Android :

```

com.smartplanner
│
├── data
│   ├── local (Room)
│   ├── repository
│   └── mapper
│
├── domain
│   ├── model
│   └── repository
│
├── ui
│   ├── screens
│   ├── components
│   └── navigation
│
├── di (Hilt)
└── MainActivity.kt

````

---

## 🛠️ Stack Technique

| Domaine | Technologie |
|--------|-------------|
| UI | Jetpack Compose + Material 3 |
| Architecture | MVVM |
| DI | Hilt |
| Persistance | Room Database |
| Async | Kotlin Coroutines + Flow |
| Navigation | Navigation Compose |
| Langage | Kotlin |

---

## 📦 Installation & Lancement

### 1. Cloner le projet
```bash
git clone https://github.com/votre-nom/smartplanner.git
cd smartplanner
````

### 2. Ouvrir dans Android Studio

* File → Open → sélectionner le dossier du projet
* Android Studio se charge d’installer les dépendances Gradle automatiquement

### 3. Lancer l’app

* Brancher un device ou lancer un émulateur
* Cliquer ▶️ **Run**

---

## 🧩 Structure des branches Git

| Branche   | Rôle                           |
| --------- | ------------------------------ |
| **main**  | version stable prête à publier |
| **dev**   | développement actif            |
| feature/* | nouvelles fonctionnalités      |
| fix/*     | corrections de bugs            |

---

## 📝 Conventions de Commit

Ce projet utilise les **commits conventionnels** :

```
<type>(<scope>): <description>
```

Exemples :

```
feat(task): add task creation feature
fix(project): fix project list not updating
refactor(vm): clean TaskViewModel logic
```

---

## 🤝 Contribution

Les contributions sont les bienvenues !
Vous pouvez ouvrir une issue, proposer une fonctionnalité ou créer une PR.

---

## 📄 License

Projet disponible sous licence **MIT**.
Tu peux l’utiliser librement dans tes projets personnels ou professionnels.

---

## 👨‍💻 Auteur

**Jean Ronald MBOUMGNI**
Ingénieur logiciel & développeur mobile
🇨🇲 Cameroun

```

---

Si tu veux, je peux ajouter :  
🔥 un **badge GitHub (build, license, langage, version Android)**  
🔥 un **screenshot / mockup**  
🔥 une **section “Roadmap”**  
🔥 une **documentation API** (pour la future synchronisation FastAPI)  
🔥 un **diagramme d’architecture**  

Tu veux qu’on enrichisse le README avec ça ?
```
