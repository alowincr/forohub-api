# ForoHub API 🚀

API REST desarrollada con **Spring Boot** para la gestión de tópicos de un foro.
El sistema permite crear, consultar, actualizar y eliminar tópicos, además de contar con **autenticación segura mediante JWT**.

---

# Tecnologías utilizadas

* Java 21
* Spring Boot 4
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA
* Hibernate
* MySQL
* Maven

---

# Arquitectura del proyecto

El proyecto sigue una arquitectura en capas:

src/main/java/com/alonso/forohub

* controller → Controladores REST
* domain → Entidades del sistema
* dto → Objetos de transferencia de datos
* repository → Acceso a la base de datos
* service → Lógica de negocio
* security → Configuración de seguridad y filtros JWT

---

# Autenticación

La API utiliza **JWT (JSON Web Token)** para proteger los endpoints.

### Obtener token

POST /login

Body:

```json
{
  "username": "admin",
  "password": "123456"
}
```

Respuesta:

```
TOKEN JWT
```

---

# Uso del token

Para acceder a los endpoints protegidos se debe enviar el token en el header:

```
Authorization: Bearer TU_TOKEN
```

---

# Endpoints disponibles

### Listar tópicos

GET /topicos

---

### Buscar tópico por ID

GET /topicos/{id}

---

### Crear tópico

POST /topicos

Body:

```json
{
  "titulo": "Problema con Spring Boot",
  "mensaje": "No me conecta a MySQL",
  "autor": "Alonso",
  "curso": "Spring Boot"
}
```

---

### Actualizar tópico

PUT /topicos/{id}

---

### Eliminar tópico

DELETE /topicos/{id}

---

# Base de datos

El proyecto utiliza **MySQL** como sistema de gestión de base de datos.

Configuración en `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/forohub
spring.datasource.username=root
spring.datasource.password=admin
```

---

# Ejecución del proyecto

1. Clonar el repositorio

```
git clone https://github.com/TUUSUARIO/forohub-api.git
```

2. Entrar al proyecto

```
cd forohub-api
```

3. Ejecutar la aplicación

```
./mvnw spring-boot:run
```

La API se ejecutará en:

```
http://localhost:8080
```

---

# Autor

Proyecto desarrollado por **Alonso** como práctica de backend utilizando **Spring Boot y JWT**.
