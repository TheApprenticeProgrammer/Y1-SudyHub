# Synthèse — Configuration Cisco Packet Tracer
## Topologie : Laptop → R1 → R2 → Serveur Web (`http://intranet.bnet.be`)

---

## 1. Configuration du serveur hébergeant DHCP + DNS

### Adresse IP du serveur

**Server0 >> Config >> FastEthernet0 :**
- IPv4 Address : `192.168.0.254`
- Subnet Mask : `255.255.255.0`

**Server0 >> Settings :**
- Default Gateway : `192.168.0.1` *(adresse du routeur vers d'autres réseaux)*
- DNS Server : `192.168.0.254` *(le serveur se désigne lui-même)*

---

### Service DHCP

**Server0 >> Services >> DHCP :**
- Service : **On**
- Default Gateway : `192.168.0.1` *(passerelle transmise aux clients pour sortir du réseau)*
- DNS Server : `192.168.0.254` *(adresse du serveur DNS transmise aux clients)*
- Start IP Address : `192.168.0.10`
- Subnet Mask : `255.255.255.0`
- Cliquer sur **Save**

---

### Service DNS

**Server0 >> Services >> DNS :**
- Service : **On**
- Name : `intranet.bnet.be`
- Type : `A Record`
- Address : `192.168.1.254` *(adresse du serveur hébergeant la page web)*
- Cliquer sur **Add**

---

## 2. Configuration du Laptop

**Laptop0 >> Desktop >> IP Configuration :**
- Sélectionner **DHCP**
- Vérifier le message : *DHCP request successful*
- Contrôler via `ipconfig /all` que les valeurs reçues sont :
  - IPv4 Address : `192.168.0.x`
  - Default Gateway : `192.168.0.1`
  - DNS Server : `192.168.0.254`

---

## 3. Configuration du serveur hébergeant le service Web

### Adresse IP du serveur

**Server1 >> Config >> FastEthernet0 :**
- IPv4 Address : `192.168.1.254`
- Subnet Mask : `255.255.255.0`

**Server1 >> Settings :**
- Default Gateway : `192.168.1.1` *(adresse du Routeur 2)*
- DNS Server : `192.168.0.254` *(adresse du serveur DNS)*

---

### Service HTTP

**Server1 >> Services >> HTTP :**
- Service HTTP : **On**
- Service HTTPS : **On**

> Le fichier `index.html` peut être modifié pour afficher le contenu de la page intranet.

---

## 4. Configuration des routeurs

### Routeur 1 (Router0)

**Interface vers le réseau 192.168.0.0/24 (Laptop + Serveur DHCP/DNS) :**

```
enable
configure terminal
interface gigabitEthernet 0/0/0
 ip address 192.168.0.1 255.255.255.0
 no shutdown
```

**Interface vers le réseau d'interconnexion 192.168.2.0/24 :**

```
interface gigabitEthernet 0/0/1
 ip address 192.168.2.1 255.255.255.0
 no shutdown
```

---

### Routeur 2 (Router1)

**Interface vers le réseau 192.168.1.0/24 (Serveur Web) :**

```
enable
configure terminal
interface gigabitEthernet 0/0/0
 ip address 192.168.1.1 255.255.255.0
 no shutdown
```

**Interface vers le réseau d'interconnexion 192.168.2.0/24 :**

```
interface gigabitEthernet 0/0/1
 ip address 192.168.2.2 255.255.255.0
 no shutdown
```

---

## 5. Configuration des routes statiques

### Sur Routeur 1 (Router0)

```
enable
configure terminal
ip route 192.168.1.0 255.255.255.0 192.168.2.2
```
> Pour joindre le réseau `192.168.1.0`, passer par `192.168.2.2` (Routeur 2).

---

### Sur Routeur 2 (Router1)

```
enable
configure terminal
ip route 192.168.0.0 255.255.255.0 192.168.2.1
```
> Pour joindre le réseau `192.168.0.0`, passer par `192.168.2.1` (Routeur 1).

---

## 6. Plan d'adressage récapitulatif

| Équipement       | Interface          | Adresse IP        | Rôle                        |
|------------------|--------------------|-------------------|-----------------------------|
| Server0          | FastEthernet0      | 192.168.0.254/24  | DHCP + DNS                  |
| Laptop0          | FastEthernet0      | via DHCP          | Client                      |
| Router0 (R1)     | GigabitEthernet0/0/0 | 192.168.0.1/24  | Passerelle réseau 0         |
| Router0 (R1)     | GigabitEthernet0/0/1 | 192.168.2.1/24  | Lien inter-routeurs         |
| Router1 (R2)     | GigabitEthernet0/0/1 | 192.168.2.2/24  | Lien inter-routeurs         |
| Router1 (R2)     | GigabitEthernet0/0/0 | 192.168.1.1/24  | Passerelle réseau 1         |
| Server1          | FastEthernet0      | 192.168.1.254/24  | Serveur Web                 |

---

## 7. Test final

Sur **Laptop0 >> Desktop >> Web Browser**, saisir :

```
http://intranet.bnet.be
```

**Flux complet :**
1. Le laptop interroge le DNS `192.168.0.254` → résout `intranet.bnet.be` en `192.168.1.254`
2. Le laptop envoie la requête HTTP vers `192.168.1.254` via la passerelle `192.168.0.1`
3. R1 transfère vers R2 via le réseau `192.168.2.0/24`
4. R2 délivre la requête au serveur web `192.168.1.254`
5. La page s'affiche ✓
