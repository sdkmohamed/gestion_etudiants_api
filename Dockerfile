# Utilise une image OpenJDK 21 légère
FROM openjdk:21-jdk-slim

# Installer Maven proprement
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Définit le répertoire de travail
WORKDIR /app

# Copie tous les fichiers du projet dans le conteneur
COPY . .

# Compile et génère le .jar
RUN mvn clean package -DskipTests

# Expose le port 8080
EXPOSE 8080

# Exécute l'application
CMD ["java", "-jar", "target/gestion-etudiants-0.0.1-SNAPSHOT.jar"]
