# Labo 1 : prise en main

## Table des matières
1. Création de l'espace de travail et de la connectique.  
2. Configuration laptop et server :  
   2.1 Configuration des adresses IP + subnet mask.  
   2.2 Configuration des passerelles par défaut.  
3. Configuration du routeur  
4. Ping de test

---

## 2. Configuration du laptop et du server

### 2.1 Configuration des adresses IP + subnet mask (pour le Laptop0)

Laptop0 >> Config >> FastEthernet0 >> IPv4 Address >> 192.168.0.10  
Laptop0 >> Config >> FastEthernet0 >> Subnet Mask >> 255.255.255.0 (/24)

### 2.2 Configuration des passerelles par défaut (pour le Laptop0)

Laptop0 >> Config >> Settings >> Default Gateway >> 192.168.0.1

➡️ La marche à suivre est identique pour le Server0.

---

## 3. Configuration du routeur

### 3.1 Configuration de l'adresse IP + subnet mask du sous-réseau

Routeur>enable  
➡️ Cette commande permet de passer du mode utilisateur au mode d'exécution privilégié (#).

Routeur#conf t  
➡️ Cette commande permet de passer du mode privilégié au mode configuration globale.

Routeur(config)#interface GigabitEthernet0/0/0  
➡️ Cette commande permet de passer en mode de configuration d'interface.

Routeur(config-if)#ip address 192.168.0.1 255.255.255.0

➡️ La marche à suivre est identique pour le deuxième sous-réseau.

---

## 5. Ping de test

Laptop >> Desktop >> Command Prompt
