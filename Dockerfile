# Utilise l'image officielle de Java
FROM openjdk:21-jdk-slim

# Définit le répertoire de travail
WORKDIR /app

# Copie le fichier JAR généré dans l'image
COPY target/gestion-etudiants-0.0.1-SNAPSHOT.jar app.jar

# Expose le port 8080
EXPOSE 8080

# Commande pour exécuter l'application
CMD ["java", "-jar", "app.jar"]
