# Contributing to Alpha Solutions – Project Calculator

Dette dokument beskriver, hvad et nyt teammedlem skal vide for at kunne arbejde videre på applikationen og bidrage til koden.

---

## Projektstruktur

Projektet er et Spring Boot-projekt opbygget efter MVC-principper:

- `controller` – håndterer HTTP-requests og applikationsflow  
- `model` – indeholder domæneklasser som Project og Task  
- `resources/templates` – Thymeleaf HTML-skabeloner  

---

## Forudsætninger

For at kunne arbejde på projektet skal følgende være installeret:

- Java 17 eller nyere  
- Maven  
- Git  
- IntelliJ IDEA (anbefalet IDE)

---

## Opsætning lokalt

1. Klon repository:
   ```bash
   git clone <repository-url>
Åbn projektet i IntelliJ IDEA

Sørg for, at Spring Boot dev-profilen er aktiv

Start applikationen:

bash
Kopier kode
mvn spring-boot:run
Applikationen kan tilgås i browseren på:

arduino
Kopier kode
http://localhost:8080
Miljøer og profiler
Projektet anvender Spring Boot profiles:

dev
Bruges lokalt og anvender H2 in-memory database.

prod
Bruges i produktion og er konfigureret til MySQL samt deployment til Azure.

Profiler styres via:

application-dev.properties

application-prod.properties

Git workflow
Projektet anvender følgende Git-principper:

main branch indeholder stabil og deploybar kode

Nye features udvikles i feature-branches

Ændringer integreres via pull requests

Eksempel på workflow:

bash
Kopier kode
git checkout -b feature/ny-funktion
git add .
git commit -m "feat: tilføj ny funktion"
git push origin feature/ny-funktion
Commit-konventioner
Commit-beskeder skal være korte og beskrivende og følge disse konventioner:

feat: ny funktionalitet

fix: fejlrettelser

docs: dokumentation

refactor: kodeomstrukturering

Eksempel:

csharp
Kopier kode
feat: add project creation form
CI/CD og kvalitetssikring
Projektet anvender GitHub Actions til Continuous Integration:

Automatisk build og test ved push og pull requests

Kun fungerende kode merges til main

Deployment til Azure håndteres via GitHub Actions (Continuous Delivery).

Samarbejde i gruppen
Projektet er udviklet i gruppe, og samarbejdet følger disse principper:

Små, overskuelige commits

Klar kommunikation om ændringer

Ingen direkte commits til main uden forudgående arbejde
