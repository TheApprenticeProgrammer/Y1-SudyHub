Configuration du serveur hébergeant les deux services + laptop :
  => Configuration du serveur :
      Server0 >> Config >> FastEthernet0 :
        => IPv4 Address (192.168.0.254)
        => Subnet Mask (255.255.255.0)
      Server0 >> Settings :
        => Default Gateway (192.168.0.1) // Adresse du routeur vers d'autres réseaux.
        => DNS Server (192.168.0.254) // Adresse du serveur qui héberge le service.
  => Configuration service DHCP :
      Server0 >> Services >> DHCP :
        => Service (On)
        => Default Gateway (192.168.0.1) // Adresse du routeur permettant la sortie vers d'autres réseaux
        => DNS Server (192.168.0.254)
        => Start IP Address (192.168.0.10)
        => Subnet Mask (255.255.255.0)
        => Save
  => Configuration du service DNS :
      Server0 >> Service >> DNS :
        => Service (on)
        => Name (intranet.bnet.be)
        => Address (192.168.1.254) // adresse du serveur qui héberge la page web.
        => Add
  => Configuration du laptop :
      Laptop0 >> Desktop >> IP Configuration :
        => (DHCP) => DHCP request successful.

Configuration du serveur hébergeant le service web :
  => Configuration du serveur :
      Server1 >> Config >> FastEthernet0 :
        => IPv4 Address (192.168.1.254)
        => Subnet Mask (255.255.255.0)
      Server0 >> Settings :
        => Default Gateway (192.168.1.1) // Adresse du routeur vers d'autres réseaux.

Configuration des routeurs :
  => Configuration router1 :
      Router0 >> CLI :
        => enable
        => conf t
        => int gigabitEthernet 0/0/0
        => ip address 192.168.0.1 255.255.255.0 // première adresse du réseau contenant le serveur(DNS & DHCP) et le laptop.
        => no shutdown
    => Configuration réseau interco :
        => enable
        => conf t
        => int gigabitEthernet 0/0/1
        => ip address 192.168.2.1 255.255.255.0
        => no shutdown
  => Configuration router 2 :
      Router0 >> CLI :
        => enable
        => conf t
        => int gigabitEthernet 0/0/1
        => ip address 192.168.1.1 255.255.255.0 // première adresse du réseau contenant le serveur hébergeant le service web.
        => no shutdown
    => Configuration réseau interco :
        => enable
        => conf t
        => int gigabitEthernet 0/0/1
        => ip address 192.168.2.2 255.255.255.0
        => no shutdown

Configuration des ip routes :
  Router0 >> CLI :
    => enable
    => conf t
    => ip route 192.168.1.0 255.255.255.0 192.168.2.2 // si tu veux aller dans ce réseau (192.168.1.0) passe par là (192.168.2.2)
  Router1 >> CLI :
    => enable
    => conf t
    => ip route 192.168.0.0 255.255.255.0 192.168.2.1
