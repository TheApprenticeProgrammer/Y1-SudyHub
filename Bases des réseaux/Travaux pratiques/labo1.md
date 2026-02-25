# Labo 1 : prise en main

## Table des matières
1. Création de l'espace de travail et de la connectique.  
2. Configuration du laptop et du serveur :  
   2.1 Configuration des adresses IP + subnet mask.  
   2.2 Configuration des passerelles par défaut.  
3. Configuration du routeur  
4. Ping de test

---
## 1. Création de l'espace de travail et de la connectique

j'ai placé sur l'espace de travail un laptop, un routeur et un serveur que j'ai connecté.

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
=> Cette commande permet de passer du mode utilisateur au mode d'exécution privilégié (#).

Routeur#conf t  
=> Cette commande permet de passer du mode privilégié au mode configuration globale.

Routeur(config)#interface GigabitEthernet0/0/0  
=> Cette commande permet de passer en mode configuration d'interface.

Routeur(config-if)#ip address 192.168.0.1 255.255.255.0

➡️ La marche à suivre est identique pour le deuxième sous-réseau.

---

## 5. Ping de test

Laptop >> Desktop >> Command Prompt

C:\>ping 192.168.1.254  
Pinging 192.168.1.254 with 32 bytes of data:  
Request timed out.  
Request timed out.  
Request timed out.  
Request timed out.  

Ping statistics for 192.168.1.254:  
Packets: Sent = 4, Received = 0, Lost = 4 (100% loss)

### Pourquoi cette réponse ?

Car un routeur de base a toujours tous ses ports fermés (shutdown).  
Il faut donc ouvrir ceux dont on a besoin avec la commande `no shutdown`.

### Commandes à exécuter

Routeur >> CLI :

Routeur>enable  
Routeur#conf t  
Routeur(config)#interface GigabitEthernet0/0/0  
Routeur(config-if)#no shutdown  

Messages typiques :

*Feb 25, 13:21:05.2121: %LINK-5-CHANGED: Interface GigabitEthernet0/0/0, changed state to up  
*Feb 25, 13:21:05.2121: %LINEPROTO-5-UPDOWN: Line protocol on Interface GigabitEthernet0/0/0, changed state to up  

➡️ Cette manipulation est nécessaire pour tous les ports concernés.

---

## Nouveau ping

C:\>ping 192.168.1.254  
Reply from 192.168.1.254: bytes=32 time=1ms TTL=127  
Reply from 192.168.1.254: bytes=32 time&lt;1ms TTL=127  
Reply from 192.168.1.254: bytes=32 time&lt;1ms TTL=127  
Reply from 192.168.1.254: bytes=32 time&lt;1ms TTL=127  

Ping statistics for 192.168.1.254:  
Packets: Sent = 4, Received = 4, Lost = 0 (0% loss)  
Approximate round trip times in milli-seconds:  
Minimum = 0ms, Maximum = 1ms, Average = 0ms  

➡️ Ping réussi !
