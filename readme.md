# Birthday Greeter

## Technologies

Soyez certain d'avoir les dépendances suivantes installées sur votre système:

* [JDK 11.0.2](https://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase11-5116896.html)
* [Maven 3.6.3](https://maven.apache.org/download.cgi)

Les commandes suivantes doivent retourner un résultat cohérent:

`java -version
`
`javac -version
`
`mvn -v
`

## Fonctionnalités

A partir du fichier "humans.txt",
vérifie si une personne fête son
anniversaire aujourd'hui. Si c'est le
cas, un mail est envoyé à la personne
concernée.

A noter que les configurations liées au
compte utilisateur qui enverra les mails
sont déclarées dans "mail_sender.conf.txt".

## Faire tourner le projet

Il faut "builder" le projet avec la commande:

`mvn package
`

La classe à exécuter sera alors App.class.

Pour plus de détails sur Maven, voici [un lien utile](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html).