# Utilisation de l'image officielle OpenJDK 11 en tant qu'image de base
FROM openjdk:17

# Définition du répertoire de travail dans le conteneur
WORKDIR /app

EXPOSE 8080

# Copie du jar de l'application dans le conteneur
COPY ./target/demo-0.0.1-SNAPSHOT.war .

# Commande à exécuter lors du démarrage du conteneur pour lancer l'application
CMD ["java", "-jar", "/app/demo-0.0.1-SNAPSHOT.war"]

