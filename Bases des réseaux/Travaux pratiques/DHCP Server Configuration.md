# Configurer un serveur avec un service DHCP

## Table des matières :

1. Configuration de l'espace de travail
2. Configuration du serveur
3. Configuration des laptops
4. Ping de test

## Configuration de l'espace de travail :
Je place un serveur, un switch et trois laptops que je connecte.

## Configuration du serveur :
Server0 >> Services >> DHCP => set the Default Gateway (192.168.10.1)
                            => set the DNS Server (192.168.10.1)
  => And save the modifications and set the service (On)

Server0 >> Desktop >> IP Configuration >> Static => set the IPv4 Address + Subnet Mask (192.168.10.1)
                                                 => set the DNS Server (192.168.10.1)

## Configuration des laptops :
Laptop0 >> Desktop >> IP Configuration => set to DHCP => résultat : "DHCP request successful"

## Ping de test :
Laptop0 >> Desktop >> Command Prompt => ping 192.168.10.1
