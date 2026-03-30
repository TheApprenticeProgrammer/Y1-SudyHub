# Rapport laboratoire 02

---

## 01 : Préparation de l'espace de travail

Pour réaliser ce laboratoire j'aurai besoin d'un laptop, de deux routeurs et d'un serveur.

---

### Laptop

- **Adresse IP :** `192.168.0.10 /24`
  - Adresse réseau : `192.168.0.0`
  - Adresse de broadcast : `192.168.0.255`
- **Passerelle par défaut :** `192.168.0.1`

---

### Serveur

- **Adresse IP :** `192.168.1.254 /24`
  - Adresse réseau : `192.168.1.0`
  - Adresse de broadcast : `192.168.1.255`
- **Passerelle par défaut :** `192.168.1.1`

---

### Routeur 1

- **Interface vers le laptop** — `192.168.0.1 /24`
  - Adresse réseau : `192.168.0.0`
  - Adresse de broadcast : `192.168.0.255`
- **Interface interco** — `192.168.100.1 /30`
  - Adresse réseau : `192.168.100.0`
  - Adresse de broadcast : `192.168.100.3`

---

### Routeur 2

- **Interface vers le serveur** — `192.168.1.1 /24`
  - Adresse réseau : `192.168.1.0`
  - Adresse de broadcast : `192.168.1.255`
- **Interface interco** — `192.168.100.2 /30`
  - Adresse réseau : `192.168.100.0`
  - Adresse de broadcast : `192.168.100.3`

---

## Configuration des interfaces

### Lien entre Laptop et Routeur 1

```
Router>enable 
Router#conf t
Router(config)#interface gigabitEthernet 0/0
Router(config-if)#ip address 192.168.0.1 255.255.255.0
Router(config-if)#no shutdown 
Router(config-if)#
%LINK-5-CHANGED: Interface GigabitEthernet0/0, changed state to up
%LINEPROTO-5-UPDOWN: Line protocol on Interface GigabitEthernet0/0, changed state to up
```

---

### Lien entre Serveur et Routeur 2

```
Router>enable 
Router#configure terminal 
Router(config)#interface gigabitEthernet 0/1
Router(config-if)#ip address 192.168.1.1 255.255.255.0
Router(config-if)#no shutdown 
%LINK-5-CHANGED: Interface GigabitEthernet0/1, changed state to up
%LINEPROTO-5-UPDOWN: Line protocol on Interface GigabitEthernet0/1, changed state to up
```

---

### Lien entre Routeur 1 et Routeur 2

```
Router>enable
Router#conf t
Router(config)#interface gigabitEthernet 0/1
Router(config-if)#ip address 192.168.100.1 255.255.255.252
Router(config-if)#no shutdown 
Router(config-if)#
%LINK-5-CHANGED: Interface GigabitEthernet0/1, changed state to up
```

---

### Lien entre Routeur 2 et Routeur 1

```
Router>enable 
Router#conf t
Router(config)#interface gigabitEthernet 0/0
Router(config-if)#ip address 192.168.100.2 255.255.255.252
Router(config-if)#no shutdown 
Router(config-if)#
%LINK-5-CHANGED: Interface GigabitEthernet0/0, changed state to up
```

---

## Ping de test (avant ajout des routes)

```
C:\>ping 192.168.1.254

Pinging 192.168.1.254 with 32 bytes of data:

Reply from 192.168.0.1: Destination host unreachable.
Reply from 192.168.0.1: Destination host unreachable.
Request timed out.
Reply from 192.168.0.1: Destination host unreachable.

Ping statistics for 192.168.1.254:
    Packets: Sent = 4, Received = 0, Lost = 4 (100% loss),
```

> **"Destination host unreachable"** signifie que le paquet n'arrive pas à rejoindre le réseau de destination.  
> **Pourquoi ?** Car les routes statiques (`ip route`) n'ont pas encore été ajoutées.

---

## Configuration des routes statiques

### Route statique sur Routeur 1

```
Router(config)#ip route 192.168.1.0 255.255.255.0 192.168.100.2
```

### Route statique sur Routeur 2

```
Router(config)#ip route 192.168.0.0 255.255.255.0 192.168.100.1
```

---

## Nouveau ping de test (après ajout des routes)

```
C:\>ping 192.168.1.254

Pinging 192.168.1.254 with 32 bytes of data:

Reply from 192.168.1.254: bytes=32 time=6ms TTL=126
Reply from 192.168.1.254: bytes=32 time=69ms TTL=126
Reply from 192.168.1.254: bytes=32 time<1ms TTL=126
Reply from 192.168.1.254: bytes=32 time<1ms TTL=126

Ping statistics for 192.168.1.254:
    Packets: Sent = 4, Received = 4, Lost = 0 (0% loss),
Approximate round trip times in milli-seconds:
    Minimum = 0ms, Maximum = 69ms, Average = 18ms
```

> ✅ Le ping est fonctionnel. Les paquets transitent correctement entre le laptop (`192.168.0.10`) et le serveur (`192.168.1.254`) via les deux routeurs.
