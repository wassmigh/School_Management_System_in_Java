# 🎓 School Management System - Java Swing & MySQL

Projet de gestion d'école développé dans le cadre du module **Programmation Orientée Objet** à l'Université pour l'année universitaire 2023-2024.

## 🧩 Objectif

Ce projet a pour but de créer un système complet de gestion scolaire en Java, intégrant :

- **Swing** pour les interfaces graphiques,
- **JDBC** pour la communication avec la base de données,
- **MySQL** comme système de gestion de base de données relationnelle.

## 👥 Utilisateurs du système

Le système gère trois types d'utilisateurs principaux :

- **Administrateur**
- **Enseignant**
- **Étudiant**

Chaque utilisateur peut se connecter avec un **nom d'utilisateur** et un **mot de passe** et accéder à des fonctionnalités spécifiques.

## ⚙️ Fonctionnalités

### 👨‍🏫 Enseignant
- Consulter la liste des étudiants
- Consulter la liste des matières

### 🎓 Étudiant
- Consulter la liste des matières
- Consulter la liste des enseignants

### 🧑‍💼 Administrateur
- Gérer les étudiants (Ajouter, Modifier, Supprimer)
- Gérer les enseignants
- Affecter les matières aux enseignants
- Affecter les étudiants aux matières

## 💻 Interface

Exemple d’interface pour la gestion des étudiants :
- Liste des étudiants
- Boutons : `Ajouter`, `Modifier`, `Supprimer`, `Enregistrer`, `Fermer`

## 🧱 Architecture

Le projet suit l’architecture **MVC** (Modèle-Vue-Contrôleur) avec une séparation claire entre :
- Les **interfaces utilisateur (Vue)** via Java Swing
- La **logique métier (Contrôleur)**
- L’**accès aux données (Modèle)** via un modèle DAO (Data Access Object)

## 🛡️ Bonnes pratiques

- Utilisation de **requêtes préparées** pour éviter les injections SQL
- **Gestion des exceptions** avec messages d’erreur clairs
- **Connexion fermée proprement** après chaque opération

