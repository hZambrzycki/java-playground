# Java Playground

A curated collection of Java example projects and exercises showcasing different facets of backend development, algorithms, and web programming.

---

This repository is organized into modules by topic. Each module is self-contained and demonstrates a particular concept or stack.

| Module / Folder | Description | How to Run / Notes |
|-----------------|-------------|---------------------|
| `algorithms/quicksort` | Implementation and tests for the Quicksort algorithm | Run via `mvn test` or `java -cp target/... QuicksortMain` |
| `web/login-jdbc` | Simple login app using Servlets + JDBC | Deploy on a servlet container (Tomcat) or run via embedded server |
| `web/sessions-cookies` | Examples of session management and cookies | Use browser + web container |
| `web/messages-servlet` | Servlet example reading/forming responses | Same as above |
| `bbdd/jdbc-register` | JDBC registration / user persistence demo | Requires a database (e.g. H2, MySQL) |

## 🛠 Technology Stack

- Java 17+ (or specify your version)  
- Servlet API / Jakarta Servlet  
- JDBC (using a relational DB)  
- JUnit 5 for testing  
- Build tool: Maven (or Gradle, as per your setup)  
- Web container: Apache Tomcat, Jetty, or embedded container  

---

This project is licensed under the MIT License
