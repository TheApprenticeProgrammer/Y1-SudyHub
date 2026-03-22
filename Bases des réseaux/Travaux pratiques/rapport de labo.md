Création de la topologie :

  Création du réseau de l'entreprise Imperium contenant deux sous-réseaux :
    Nous aurons besoins d'un routeur (routeur A), de deux switch (switch clients et le switch serveur),
    d'un serveur (serveur A) et de plusieur laptop (laptop client A1, laptop client A2, ...).

  Création du réseau de l'entreprise Xenos contenant deux sous-réseaux :
    Nous aurons besoins d'un routeur (routeur B), de deux switch (switch clients et le switch serveur),
    d'un serveur (serveur B) et de plusieur laptop (laptop client B1, laptop client B2, ...).

  Création du réseau Internet :
    Nous aurons besoin d'un routeur (routeur internet, d'un switch (switch internet), et de deux
    serveur (serveur DNS et serveur Web).

  Connectique :
    C.F Image 01

Création / conception des réseaux et adresses réseaux :
  Les réseaux privés :
    Entreprise Imperium :
      Sous-réseau 01 : 192.168.1.0 /24 => Ce réseau est destiné aux serveurs de l'entreprise Imperium
      Sous-réseau 02 : 192.168.2.0 /24 => Ce réseau est destiné au clients de l'entreprise Imperium
  
    Serveur A :
      ip address : 192.168.1.2 => Deuxième adresse du sous-réseau la première etant toujours donnée au routeur A
      mask : 255.255.255.0 (/24)
      Gateway : 192.168.1.1 => Adresse du routeur qui permet de sortir du réseau
      DNS Server : 203.0.113.2

    Laptops clients :
      Afin de faciliter l'ajout de nouveaux hôtes je suis parti pour un serveur DHCP mais pendant mes recherches
      sur internet j'ai appris que l'on peut aussi avoir un routeur DHCP et je suis donc parti avec cette idée.

      Configuration routeur DHCP :
        Routeur A >> CLI :
          enable
          conf t
          ip dhcp pool clientEntrpriseImperium
          network 192.168.2.0 255.255.255.0 => adresse réseau du sous-réseau
          default-router 192.168.2.1 => adresse hôte du routeur A
          dns-server 203.0.113.2 => adresse DNS ???
          ip dhcp excluded-address 192.168.2.1 => j'exclu l'adresse du routeur A pour éviter les problèmes
       Laptop client A1 >> Desktop >> IP Configuration :
         Cochez DHCP => DHCP request sucessfull
           Répeter l'opération sur les autres ordinateurs.
    
    Entreprise Xenos :
      Sous-réseau 01 : 192.168.3.0 => Ce réseau est destiné aux serveurs de l'entreprise Xenos
      Sous-réseau 02 : 192.168.4.0 => Ce réseau est destiné aux clients de l'entreprise Xenos

    Pour le reste c'est exactement la même méthode montrée pour l'entreprise Imperium. Il faut cependant
    changer les différentes adresses.

  Les réseaux publiques (internet) :
    Sous-réseau 01 : 198.51.100.0 /30 => réseau connectant le routeur A au routeur Internet
    Sous-réseau 02 : 198.51.100.0 /30 => réseau connectant le routeur B au routeur Internet
    Sous-réseau 03 : 203.0.113.0 /24 => réseau servant à connecter le serveur DNS, le serveur Web et le routeur.


Première étape configuration du réseau Internet :
  Configuration du routeur internet :
    vers Switch Internet :

  ----------------------------------------------------------------
      Router>
      Router>ena
      Router>enable 
      Router#conf
      Router#configure t
      Router#configure terminal 
      Enter configuration commands, one per line.  End with CNTL/Z.
      Router(config)#int
      Router(config)#interface gi
      Router(config)#interface gigabitEthernet 0/0
      Router(config-if)#ip add
      Router(config-if)#ip address 203.0.113.1 255.255.255.0
      Router(config-if)#no shut
      Router(config-if)#no shutdown do
      Router(config-if)#no shutdown
      Router(config-if)#
      %LINK-5-CHANGED: Interface GigabitEthernet0/0, changed state to up
      %LINEPROTO-5-UPDOWN: Line protocol on Interface GigabitEthernet0/0, changed state to up
      Router(config-if)#exit
--------------------------------------------------------
    vers routeur A :
--------------------------------------------------------
      Router(config)#interface gigabitEthernet 0/1
      Router(config-if)#ip address 198.51.100.1 255.255.255.252
      Router(config-if)#no shutdown 
      Router(config-if)#
      %LINK-5-CHANGED: Interface GigabitEthernet0/1, changed state to up
      Router(config-if)#exit
--------------------------------------------------------
    vers routeur B :
----------------------------------------------------------
      Router(config)#interface gigabitEthernet 0/2
      Router(config-if)#int
      Router(config-if)#ip ad
      Router(config-if)#ip address 198.51.100.5 255.255.255.252
      Router(config-if)#no shut
      Router(config-if)#no shutdown 
      Router(config-if)#
      %LINK-5-CHANGED: Interface GigabitEthernet0/2, changed state to up
      Router(config-if)#exit
      Router(config)#
-----------------------------------------------------------

Configuration serveur A :
  Serveur A >> Desktop >> IP Configuration :
    ip address : 192.168.1.2 => Deuxième adresse du sous-réseau la première etant toujours donnée au routeur A
    mask : 255.255.255.0 (/24)
    Gateway : 192.168.1.1 => Adresse du routeur qui permet de sortir du réseau
    DNS Server : 203.0.113.2
Configuration serveur B : 
  Même procédure que le serveur A.

Configuration du routeur A:
  vers routeur internet :
  
--------------------------------------------------------------------
Router>enable 
Router#conf t
Enter configuration commands, one per line.  End with CNTL/Z.
Router(config)#inter
Router(config)#interface gi
Router(config)#interface gigabitEthernet 0/0
Router(config-if)#ip add
Router(config-if)#ip address 198.51.100.2 255.255.255.252
Router(config-if)#no shut
Router(config-if)#no shutdown 
Router(config-if)#
%LINK-5-CHANGED: Interface GigabitEthernet0/0, changed state to up
%LINEPROTO-5-UPDOWN: Line protocol on Interface GigabitEthernet0/0, changed state to up
exit
Router(config)#
--------------------------------------------------------------------
  vers switch serveur A :
  
---------------------------------------------
Router(config)#interface gigabitEthernet 0/2
Router(config-if)#ip address 192.168.1.1 255.255.255.0
Router(config-if)#no shutdown 
Router(config-if)#
%LINK-5-CHANGED: Interface GigabitEthernet0/2, changed state to up
%LINEPROTO-5-UPDOWN: Line protocol on Interface GigabitEthernet0/2, changed state to up
Router(config-if)#exit
--------------------------------------------
vers switch client A :

-------------------------------------------------------
Router(config)#interface gigabitEthernet 0/1
Router(config-if)#ip add
Router(config-if)#ip address 192.168.2.1 255.255.255.0
Router(config-if)#no shu
Router(config-if)#no shutdown 
Router(config-if)#
%LINK-5-CHANGED: Interface GigabitEthernet0/1, changed state to up
%LINEPROTO-5-UPDOWN: Line protocol on Interface GigabitEthernet0/1, changed state to up
Router(config-if)#exit
-------------------------------------------------------

Configuration du routeur DHCP :

--------------------------------------
Router(config)#ip dhcp pool clientsImperium
Router(dhcp-config)#ne
Router(dhcp-config)#network 192.168.2.1 255.255.255.0
Router(dhcp-config)#dn
Router(dhcp-config)#dns-server 203.0.113.2
Router(dhcp-config)#exit
Router(config)#ip dhcp excluded-address 192.168.2.1
-------------------------------------  

Configuration du Serveur B :
  Même chose que serveur A 


Configuration route par défaut + ip route

  Router(config)#ip route 0.0.0.0 0.0.0.0 198.51.100.1

  Router(config)#ip route 192.168.1.0 255.255.255.0 198.51.100.2
  Router(config)#ip route 192.168.2.0 255.255.255.0 198.51.100.2
  Router(config)#ip route 192.168.3.0 255.255.255.0 198.51.100.6
  Router(config)#ip route 192.168.4.0 255.255.255.0 198.51.100.6


Configuration du serveur DNS :
  Serveur DNS >> Desktop >> IP Configuration :
    IPv4 Address : 203.0.113.2
    Mask : 255.255.255.0
    Gateway : 203.0.113.1
    DNS Server : 203.0.113.2
  Serveur DNS >> Services >> DNS 
    DNS Service => ON
    Name : www.bnet.be
    Address : 203.0.113.3
    Cliquer sur => Add

Configuration du serveur Web :
  Serveur Web >> Desktop >> IP Configuration :
    IPv4 Address : 203.0.113.3
    Mask : 255.255.255.0
    Gateway : 203.0.113.1
    DNS : 203.0.113.2
  Serveur Web >> Services >> HTTP
    CLique sur => ON

Configuration de Laptop Clients :
  Laptop Client A1 >> Desktop >> IP Configuration :
    Cliquez sur => DHCP => DHCP request successful
      => répeter sur les autres laptops
    


      
