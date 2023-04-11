# Docker

Instal·lació, configuració i funcionament de Docker y Docker-Compose.

## Instal·lació

```
sudo pacman -Syu docker docker-compose
```

Després de instal·lar el docker i les seves dependències hem de iniciar el servei per a que sigui disponible:

```
sudo systemctl start docker
```

I per acabar asignem el group `docker` a l'usuari que fem servir.

```
sudo gpasswd -a $USER docker
```

\**Per a que el canvis facin efecte cal tancar la sessió i tornar a iniciar-la.*
