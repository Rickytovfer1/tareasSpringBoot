# CRUD MVC con Thymeleaf — RA3

## 1) Datos del alumno/a
- Entidad elegida (ej. Producto, Libro...): Vecino

## 2) Repositorio (fork) y gestión de versiones
- Repositorio base: https://github.com/profeInformatica101/tareasSpringBoot
- Enlace a MI fork: https://github.com/Rickytovfer1/tareasSpringBoot.git
- Rama de entrega del proyecto: dev
- Nombre del commit: Entrega final practica acabada
- Nº de commits realizados: (mínimo 5)

## 3) Arquitectura
Explica brevemente cómo has organizado:
- Controller: En el controlador he hecho los endpoints, es decir, las rutas y he llamado a las funciones del Servicio 
- Service: En el servicio he realix¡zado la funcionalidad de cada método, es decir, el CRUD completo
- Repository: El repositorio lo he utilizado para hacer las consultas y démas hacia la base de datos
- Entity: El la entidad donde yo la he llamado en mi proyecto modelo he realizado la creación de las tablas para mi base de datos de PostgreSQL

## 4) Base de datos elegida (marca una)
- [ ] H2
- [ ] MySQL
- [X] PostgreSQL

## 5) Configuración de la base de datos
### 5.1 Dependencias añadidas
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>com.github.javafaker</groupId>
			<artifactId>javafaker</artifactId>
			<version>1.0.2</version>
		</dependency>
### 5.2 application.properties / application.yml
spring.application.name=Practica
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
logging.level.org.hibernate.SQL=DEBUG
server.port=8080

spring.security.user.name=user
spring.security.user.password=123456


### 5.3 Pasos para crear la BD (si aplica)
- MySQL: CREATE DATABASE ...
- PostgreSQL: He creado un schema de postgre mediante el cliente gráfico de DBeaver, donde las tablas las he creado mediante JPA en Java

## 6) Cómo ejecutar el proyecto
1. Requisitos (Java versión: 21, Maven/Gradle: Maven, DB instalada si aplica: Postgres)
2. Comando de arranque:
   - ./mvnw spring-boot:run   (o equivalente)
3. URL de acceso:
   - http://localhost:8080/listaVecinos => ya que esta es la ruta donde pueden acceder todo el mundo y ya desde esa página si quieres crear/editar/eliminar se tendrá que acceder logueando

## 7) Pantallas / Rutas MVC
- GET /listaVecinos (listar)  //Puede acceder todos los usuarios
- POST /crearVecino (crear)  //Puede acceder solamente el admin
- POST /vecino/editar/{id} (editar) //Puede acceder tanto el manager como el admin
- POST /vecino/eliminar/{id} (eliminar) //Puede acceder solamente el admin


## 8) Mejoras extra (opcional)
- Validaciones
- Estilos Bootstrap
- Búsqueda
- Pruebas
- Paginación
