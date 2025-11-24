# 📅 SmartPlanner – Application Android Moderne

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

---

**SmartPlanner** est une application Android minimaliste et performante, conçue pour vous aider à organiser efficacement vos tâches quotidiennes et à gérer vos projets, en mettant l'accent sur une architecture **Android moderne** et une expérience utilisateur Material 3.

## 🚀 Fonctionnalités (MVP)

Cette première version se concentre sur la **gestion des tâches en mode local (Offline-First)** pour démontrer la maîtrise de l'écosystème Android moderne.

### ✅ Inclus dans la version actuelle (MVP)
* **Gestion Complète des Tâches (CRUD) :** Création, lecture, modification et suppression de tâches (incluant titre et description).
* **Statut de Complétion :** Marquer une tâche comme terminée ou non terminée.
* **Organisation par Projet :** Création de projets et association d'une tâche à un projet unique.
* **Filtrage :** Affichage des tâches filtrées par projet.
* **Thème :** Implémentation du **Thème Clair** basé sur **Material 3**.
* **Persistance Locale :** Utilisation de **Room Database** pour le stockage hors ligne.
* **Architecture Robuste :** Mise en œuvre d'une architecture **MVVM** propre et scalable.

---

### 🔜 Roadmap (Prochaines Étapes)
* **Gestion Avancée :** Tags / catégories pour une classification plus fine.
* **Rappels :** Notifications et alertes pour les échéances.
* **Design :** Implémentation complète du **Mode Sombre** automatique.
* **Synchronisation Cloud :** Intégration du **SmartPlanner API (Spring boot)** pour la synchronisation des données.
* **Améliorations UI/UX :** Ajout de **Widgets Android** et fonctionnalités d'export/backup.

---

## 🧱 Architecture du Projet

SmartPlanner est structuré en modules (packages) pour garantir une séparation des préoccupations claire, suivant le principe de l'architecture propre :

```

com.smartplanner
│
├── data                     \# Implémentation des sources de données
│   ├── local                \# Room Database et DAOs
│   ├── repository           \# Implémentation du Repository
│   └── mapper               \# Logique de conversion (Model \<-\> Entity)
│
├── domain                   \# Le cœur de l'application (logique métier)
│   ├── model                \# Classes de données Pures (la vérité de l'app)
│   └── repository           \# Interfaces des Repositories
│
├── ui                       \# Couche de présentation (Jetpack Compose)
│   ├── screens              \# Composables des écrans principaux
│   ├── components           \# Composables réutilisables (design system)
│   └── navigation           \# Gestion du graphe de navigation (Navigation Compose)
│
├── di                       \# Injection de dépendances (Hilt Modules)
└── MainActivity.kt          \# Point d'entrée de l'application

````

---

## 🛠️ Stack Technique

| Domaine | Technologie | Rôle Principal |
| :--- | :--- | :--- |
| **UI/Design** | **Jetpack Compose + Material 3** | Construction de l'interface utilisateur moderne. |
| **Architecture** | **MVVM** | Séparation des couches et testabilité. |
| **Injection** | **Hilt** | Gestion des dépendances simplifiée. |
| **Persistance** | **Room Database** | Stockage de données structurées hors ligne. |
| **Asynchronisme** | **Kotlin Coroutines + Flow** | Gestion efficace des opérations asynchrones. |
| **Navigation** | **Navigation Compose** | Gestion du flux entre les écrans. |
| **Langage** | **Kotlin** | Langage principal de développement. |

---

## 📦 Installation & Lancement

### 1. Cloner le Projet
```bash
git clone [https://github.com/votre-nom/smartplanner.git](https://github.com/votre-nom/smartplanner.git)
cd smartplanner
````

### 2\. Ouvrir et Synchroniser

  * Ouvrir le dossier `smartplanner` dans **Android Studio**.
  * Laisser Gradle synchroniser et télécharger toutes les dépendances.

### 3\. Lancer l’Application

  * Assurez-vous qu'un émulateur ou un appareil physique est connecté.
  * Cliquez sur le bouton ▶️ **Run**.

-----

## 🧩 Conventions Git

### Structure des Branches

| Branche | Rôle |
| :--- | :--- |
| **`main`** | Version stable et livrable (prête pour la production ou le déploiement). |
| **`dev`** | Environnement de développement actif et tests d'intégration. |
| **`feature/*`** | Développement de nouvelles fonctionnalités. |
| **`fix/*`** | Corrections de bugs (hotfixes). |

### Conventions de Commit

Ce projet suit les **Conventional Commits** pour un historique clair et générable :

```
<type>(<scope>): <description>
```

| Type | Description | Exemple |
| :--- | :--- | :--- |
| **`feat`** | Nouvelle fonctionnalité | `feat(task): ajouter l'édition de la description` |
| **`fix`** | Correction de bug | `fix(project): éviter le crash lors de la création sans nom` |
| **`refactor`** | Remaniement de code | `refactor(vm): nettoyer TaskViewModel` |
| **`docs`** | Changement de documentation | `docs(readme): mettre à jour la roadmap` |

-----

## 🤝 Contribution

Nous accueillons les contributions \! N'hésitez pas à :

1.  Ouvrir une **Issue** pour signaler un bug ou proposer une fonctionnalité.
2.  Créer une **Pull Request (PR)** avec vos améliorations ou corrections.

-----

## 📄 Licence

Ce projet est distribué sous la **Licence MIT**. Vous êtes libre de l'utiliser, le modifier et le distribuer.

-----

## 👨‍💻 Auteur

**[Jean Ronald MBOUMGNI](https://portfolio.vimelec.tech/)**
Ingénieur Logiciel & Développeur Mobile
📍 Cameroun

```

---
