# Labo 2 : routage statique

## Table des matières :
1. Création de l'espace de travail et de la connectique
2. Configuration du laptop et du serveur : 
    2.1 Configuration des adresses IP + subnet mask.
    2.2 Configuration des passerelles par défaut.
3. Configuration des routeurs
4. Ping de test

---

## 1. Création de l'espace de travail et de la connectique

J'ai placé sur l'espace de travail un laptop, un serveur et deux routeurs que j'ai connecté.

## 2. Configuration du laptop et du serveur :

### 2.1 Configuration des adresses IP + subnet mask
Laptop0 >> Config >> FastEthernet0 >> IPv4 Address >> 192.168.0.10
Laptop0 >> Config >> FastEthernet0 >> Subnet mask >> 255.255.255.0 (/24)

### 2.2 Configuration des passerelles par défaut
Laptop0 >> Config >> Settings >> Default Gateway 192.168.0.1


➡️ La marche à suivre est identique pour le Server0.

---

## 3. Configuration des routeurs :

### 3.1 Configuration du premier sous-réseau :
