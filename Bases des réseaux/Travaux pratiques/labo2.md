Rapport laboratoire 02 :

01 : Préparation de l'espace de travail :

Pour réaliser ce laboratoire j' aurai d'un laptop, de deux routeurs et d'un serveur.

Le laptop aura comme adresse 192.168.0.10 /24, ce qui signifie :
    Adresse réseau : 192.168.0.0
    Adresse de broadcast 192.168.0.255
Son adresse de passerelle par défaut est 192.168.0.1

Le serveur aura comme adresse 192.168.1.254 /24, ce qui signifie :
    Adresse réseau : 192.168.1.0
    Adresse de broadcast : 192.168.1.255
Son adresse de passerelle par défaut est 192.168.1.1

Le routeur 1 aura comme adresse :
    Dans le premier sous-réseau 192.168.0.1 /24, ce qui signifie :
        Adresse réseau : 192.168.0.0
        Adresse de broadcast 192.168.0.255
    Dans le sous-réseau interco 192.168.100.1 /30, ce qui signifie :
        Adresse réseau : 192.168.100.0
        Adresse de broadcast : 192.168.100.3

Le routeur 2 aura comme adresse :
        Dans le premier sous-réseau 192.168.1.1 /24, ce qui signifie :
            Adresse réseau : 192.168.1.0
            Adresse de broadcast : 192.168.1.255
        Dans le sous-réseau interco 192.168.100.2 /30
            Adresse réseau : 192.168.100.0
            Adresse de broadcast : 192.168.100.3

Commande de configuration lien entre laptop et routeur 01 :
        Router>enable 
        Router#conf t
        Router(config)#interface gigabitEthernet 0/0
        Router(config-if)#ip address 192.168.0.1 255.255.255.0
        Router(config-if)#no shutdown 
        Router(config-if)#
        %LINK-5-CHANGED: Interface GigabitEthernet0/0, changed state to up
        %LINEPROTO-5-UPDOWN: Line protocol on Interface GigabitEthernet0/0, changed state to up

Commande de configuration lien entre serveur et routeur 02 :
        Router>enable 
        Router#configure terminal 
        Router(config)#interface gigabitEthernet 0/1
        Router(config-if)#ip address 192.168.1.1 255.255.255.0
        Router(config-if)#no shutdown 
        %LINK-5-CHANGED: Interface GigabitEthernet0/1, changed state to up
        %LINEPROTO-5-UPDOWN: Line protocol on Interface GigabitEthernet0/1, changed state to up

Commande de configuration lien entre routeur 2 et routeur 1 :

