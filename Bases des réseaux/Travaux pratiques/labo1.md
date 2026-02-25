Labo 1 : prise en main

Table des matières :
  1. Création de l'espace de travail et de la connectique.
  2. Configuration laptop et server :
      2.1 Configuration des adresses IP + subnet mask.
      2.2 Configuration des passerrelles par défaut.
  3. Configuration du routeur
  4. Ping de test

2. Configuration du laptop et du server :

  2.1 Configuration des adresses IP + subnet mask (pour le laptop0) :
        Laptop0 >> Config >> FastEthernet0 >> IPv4Address >> 192.168.0.10
        Laptop0 >> Config >> FastEthernet0 >> Subnet Mask >> 255.255.255.0 (/24)

  2.2 Configuration des passerrelles par défaut (pour le laptop0)
        Laptop0 >> Config >> Settings >> Default Gateway >> 192.168.0.1

      => La marche à suivre est identique pour le server0
      
3. Configuration du routeur :
   
   3.1 Configuration de l'adresse IP + subnet mask du sous-réseau :
     Routeur>enable => Cette commande permet de passer du mode utilisateur au mode d'exécution privilégié (#).
     Routeur#conf t  => La commande conf t (configure terminal) sur un routeur ou un switch permet de passer du mode privilégié (mode enable) au mode configuration globale.
     Routeur(config)#interface GigabitEthernet0/0/0  => Cette commande permet de passer du mode de configuration globale au mode de configuration d'interface sur le routeur.
     Routeur(config-if)#ip address 192.168.0.1 255.255.255.0

     => la marche à suivre est identique pour le deuxième sous-réseau

5. Ping de test :
   Laptop >> Desktop >> Command Prompt
     C:\>ping 192.168.1.254
     Pinging 192.168.1.254 with 32 bytes of data:

     Request timed out.
     Request timed out.
     Request timed out.
     Request timed out.

     Ping statistics for 192.168.1.254:
       Packets: Sent = 4, Received = 0, Lost = 4 (100% loss),

   Pourquoi cette réponse ? :
     Car un routeur de base à toujours tout ses ports fermés (shutdown) il faut donc ouvrir ceux dont on a besoin avec la commande "no shutdown)
     Routeur >> CLI :
       Routeur>enable
       Routeur#conf t
       Routeur(config)#interface GigabitEthernet0/0/0
       Routeur(config-if)#
       Router(config-if)#
       *Feb 25, 13:21:05.2121: %LINK-5-CHANGED: Interface GigabitEthernet0/0/0, changed state to up
       *Feb 25, 13:21:05.2121: %LINEPROTO-5-UPDOWN: Line protocol on Interface GigabitEthernet0/0/0, changed state to up

         => Cette manipulation est nécessaire pour tout les ports concernés.

     Maintenant nous pouvons réessayer :
       Laptop >> Desktop >> Command Prompt
         C:\>ping 192.168.1.254
         Pinging 192.168.1.254 with 32 bytes of data:

         Reply from 192.168.1.254: bytes=32 time=1ms TTL=127
         Reply from 192.168.1.254: bytes=32 time<1ms TTL=127
         Reply from 192.168.1.254: bytes=32 time<1ms TTL=127
         Reply from 192.168.1.254: bytes=32 time<1ms TTL=127

         Ping statistics for 192.168.1.254:
            Packets: Sent = 4, Received = 4, Lost = 0 (0% loss),
         Approximate round trip times in milli-seconds:
            Minimum = 0ms, Maximum = 1ms, Average = 0ms

     => Ping réussi !
       
     
     
     


   
