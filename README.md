Pour lancer l'application Backend : il faut suivre les étapes suivantes : 

Dans ce projet, il y a un fichier qui s'appelle application.properties , ce fichier contient toutes les informations nécessaire pour configurer le démmarage de la l'application.
Il y deux scénario de configuration : 

[+] configuration avec pour l'utilisation avec vpn 

- il faut enlever ou commenter cette ligne ssh.forward.enabled, pour dectiver l'utilisation d'un tunnnel avec le serveur SSH de l'IM2AG.

- il faut enlever ou commenter cette ligne ssh.forward.enabled, pour dectiver l'utilisation d'un tunellle avec le serveur SSH de l'IM2AG.

- il faut enlever #spring.datasource.url=jdbc:oracle:thin:@localhost:1521/IM2AG et remplacer par 

spring.datasource.url=jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521/IM2AG

[+] configuration avec pour l'utilisation avec SSH , il faut mettre ces deux parametres
#ssh.forward.enabled
#spring.datasource.url=jdbc:oracle:thin:@localhost:1521/IM2AG

[+] Parametres en commun entre configuration SSH et VPN 


#SSHUsername
ssh.forward.username=elasrim
#SSHPassword
ssh.forward.password= votre password crypté
spring.datasource.username=elasrim
spring.datasource.password= vous mot de passe pou la base de donnée
server.port=8085

Notez bien que 


