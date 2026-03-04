# 🌐 Programmation Réseau et Système Distribué (TP-ALGO-REPA)

<div align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/TCP-Networking-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/UDP-Networking-green?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Sockets-API-red?style=for-the-badge" />
</div>

<br />

Ce dépôt contient une collection de Travaux Pratiques (TP) implémentant des concepts de programmation réseau et de systèmes distribués en **Java**, axés sur la manipulation des **Sockets (TCP/UDP)** et la **Sérialisation d'objets**.

## 📂 Structure du Projet

Le projet est divisé en quatre TPs progressifs pour comprendre et maîtriser les communications réseau en Java.

### 🔌 [TP1] - Introduction aux Sockets (TCP)
*Communication unidirectionnelle simple*
- **Client (`p1.java`) :** Se connecte à un serveur local sur le port `1234` et envoie un objet sérialisé (`String` : `"HELLO RSD"`).
- **Concept clé :** `Socket`, `ObjectOutputStream`.

### 🔄 [TP2] - Communication Bidirectionnelle (TCP)
*Échange de données dans les deux sens*
- **Client (`p1.java`) :** Se connecte sur le port `2004`, envoie un message et attend un accusé de réception/réponse du serveur.
- **Concept clé :** `Socket`, `ObjectOutputStream`, `ObjectInputStream`.

### 💬 [TP3] - Mode Interactif (TCP)
*Boucle d'interaction continue*
- **Client (`p1.java`) :** Lit un nombre `N` depuis la console de l'utilisateur, l'envoie au serveur (`port 5002`), récupère le résultat et l'affiche. Cette boucle s'exécute indéfiniment.
- **Concept clé :** `BufferedReader`, flux d'E/S standard interactifs, `Socket`.

### 🚀 [TP4] - Mode Non Connecté (UDP)
*Communication sans connexion préalable avec Datagrammes*
- **Client (`p1.java`) :** Construit et envoie un `DatagramPacket` contenant la chaîne `"RSD"` au serveur sur le port `2004`. Il attend ensuite la réponse du serveur.
- **Serveur (`p2.java`) :** Écoute sur le port `2004`, reçoit le datagramme, convertit le message en majuscules, puis renvoie un nouveau datagramme en réponse au client.
- **Concepts clés :** `DatagramSocket`, `DatagramPacket`, `InetAddress`.

---

## 🛠️ Prérequis

Pour compiler et exécuter ces TPs, vous aurez besoin de :
- [**Java Development Kit (JDK)**](https://www.oracle.com/java/technologies/downloads/) (version 8 ou ultérieure)
- Un terminal (Invite de commandes, PowerShell ou Bash)
- Un IDE Java (IntelliJ IDEA, Eclipse, VS Code) - *Optionnel mais recommandé*

## 🚀 Comment Exécuter

Voici la démarche générale pour exécuter un TP donné. Vous devez toujours lancer le **Serveur** en premier (s'il y en a un), puis le **Client**.

### Exemple d'exécution avec le terminal (Exemple sur le TP4)

1. **Compilation des fichiers Java :**
   ```bash
   javac TP4/p2.java  # Compilateur du serveur
   javac TP4/p1.java  # Compilateur du client
   ```

2. **Démarrage du Serveur :**
   Ouvrez un premier terminal à la racine du projet (`TP ALGO`) et exécutez la classe serveur (`p2` dans le TP4) :
   ```bash
   java TP4.p2
   ```

3. **Démarrage du Client :**
   Ouvrez un second terminal à la racine du projet et lancez la classe client (`p1` dans le TP4) :
   ```bash
   java TP4.p1
   ```

> ⚠️ **Remarque :** Pour le TP4 (Client IP), si le serveur est en local, l'adresse IP `192.168.233.156` définie "en dur" dans le code `TP4/p1.java` devra peut-être être remplacée par `localhost` (ou `127.0.0.1`) ou votre IP locale pour que cela fonctionne correctement.

---

<div align="center">
  <i>Développé pour maîtriser la programmation réseau en Java.</i>
</div>
