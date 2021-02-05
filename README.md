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
ssh.forward.username= votre username
#SSHPassword
ssh.forward.password= ENC(clé public)
spring.datasource.username=elasrim
spring.datasource.password= vous mot de passe pou la base de donnée
server.port=8085

Je vous recommende de mettre une configuration au debut avec un VPN pour une premiere utilisation.

Car quand on utiliser une configuration SSH, il faut crypter votre mot de passe, ssh.forward.password 
pour faire ça, vous pouvez aller sur https://www.devglan.com/online-tools/jasypt-online-encryption-decryption 
vous devez generer un mote passe public et privé 

on met la clé publique ssh.forward.password= ENC(clé public)

et ensuite on peut compiler avec notre clé privé

java -Djasypt.encryptor.password=**VOTRE_CLé_PRIVé** -jar target/stillca
re-1.0.jar


