# Alpha Solutions – Project Calculator

Dette projekt er udviklet som en del af **KEA Datamatikeruddannelsens 2. semester eksamensprojekt**.

Applikationen er en webbaseret projektkalkulator, der hjælper konsulentvirksomheden *Alpha Solutions* med at planlægge, estimere og få overblik over tidsforbrug på projekter og opgaver.

---

## Formål

Formålet med applikationen er at give et samlet overblik over:

- Projekter og deres deadlines
- Opgaver og estimeret tidsforbrug
- Samlet tidsforbrug pr. projekt
- Fordeling af arbejdstimer pr. arbejdsdag, så projekter kan færdiggøres til tiden

Applikationen understøtter oprettelse og vedligeholdelse af projekter via en brugergrænseflade.

---

## Funktionalitet

Applikationen tilbyder følgende funktioner:

- Oprettelse af projekter med navn, kunde og deadline
- Oprettelse af opgaver tilknyttet projekter
- Estimering af tidsforbrug på opgaver
- Automatisk summering af samlet tidsforbrug pr. projekt
- Beregning af nødvendige arbejdstimer pr. dag baseret på deadline

---

## Arkitektur (MVC)

Projektet er opbygget efter **Model–View–Controller (MVC)** arkitekturen:

- **Model**  
  Indeholder domænemodeller som `Project` og `Task`, der repræsenterer projektdata og forretningslogik.

- **View**  
  Implementeret med Thymeleaf templates, som præsenterer data for brugeren i browseren.

- **Controller**  
  Håndterer HTTP-requests, forbinder Model og View og indeholder applikationens flow.

---

## Teknologier

Projektet er udviklet med følgende teknologier:

- Java 17
- Spring Boot
- Spring MVC
- Thymeleaf
- JPA (Hibernate)
- H2 Database (udviklingsmiljø)
- MySQL (produktionsmiljø)
- Maven
- GitHub Actions (CI/CD)

---

## Miljøer og profiler

Applikationen anvender **Spring Boot profiles** til at adskille miljøer:

- **dev**  
  Lokalt udviklingsmiljø med H2 in-memory database.

- **prod**  
  Produktionsmiljø med MySQL database og deployment til Azure.

Profilerne styres via `application-dev.properties` og `application-prod.properties`.

---

## CI/CD

Projektet anvender **GitHub Actions** til Continuous Integration og Continuous Delivery:

- Automatisk build og test ved push og pull requests
- Deployment til Azure Web App ved ændringer på `main` branch

Workflow-filen findes i:
.github/workflows/

yaml
Kopier kode

---

## Deployment

Applikationen er deployet som en **Azure Web App (PaaS)** og er offentligt tilgængelig.

🔗 **Link til kørende applikation:**  
*(indsæt jeres Azure URL her)*

---

## Krav for at køre projektet lokalt

For at køre projektet lokalt kræves:

- Java 17 eller nyere
- Maven
- Git

Projektet startes lokalt med:
```bash
mvn spring-boot:run
GitHub Repository
Dette repository indeholder:

Kildekode til webapplikationen

CI/CD workflow

Dokumentation til eksamensprojektet

Contributing
Se CONTRIBUTING.md for information om, hvordan nye teammedlemmer kan bidrage til projektet.

Gruppe
Projektet er udviklet af:

Bassim Benarab

Lamal Huseynova


