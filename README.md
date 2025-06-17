## SpringbootPruebaTecnica 
#Prueba técnica API REST con Java Spring Boot
Por: Juan Camilo Sierra

Este proyecto implementa una API REST utilizando Java 21 y Spring Boot 3 y permite a los usuarios autenticarse contra la API externa de [DummyJSON](https://dummyjson.com), y registra cada autenticación válida en una base de datos PostgreSQL.

## Requisitos Técnicos

- Java 21+
- Spring Boot 3+
- JPA con PostgreSQL
- Spring OpenFeign
- Principios SOLID aplicados
- Al menos una prueba unitaria del flujo de login

## Arquitectura

La aplicación se organiza en paquetes separados:

com.example.demo
- controller # Controladores REST
- dto # Objetos de transferencia (Login, Usuario)
- model # Entidades JPA
- repository # Interfaces JPA
- service # Lógica de negocio
- client # Feign Client para DummyJSON

## Funcionalidad principal

- `POST /api/auth/login`: autentica al usuario contra DummyJSON.
- Recupera datos del usuario autenticado (`/auth/me`).
- Registra en la base de datos:
  - username
  - accessToken
  - refreshToken
  - login_time

---

##  Base de Datos
### PostgreSQL con Docker
Si **no se tiene PostgreSQL instalado**, se puede usar Docker

## La tabla Login_log se crea automaticamente

## Autenticación
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"emilys","password":"emilyspass"}'

Si es exitoso:
Recibirás los datos del usuario autenticado.
Se insertará un registro en la tabla login_log.

## Pruebas
incluye una prueba unitaria del flujo de login usando mocks:
AuthServiceTest.java: simula autenticación y guarda el log.
Usa JUnit + Spring Boot Test + Mockito.

Asegúrate de tener Java 21 y Maven.

Levanta PostgreSQL con Docker.

Ejecuta el proyecto:

./mvnw spring-boot:run
Prueba el endpoint con el curl provisto.
