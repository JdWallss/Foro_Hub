# Foro Hub 

Foro Hub es una aplicación de foro diseñada para facilitar la comunicación y discusión entre usuarios. Esta aplicación permite a los usuarios crear tópicos, responder a los mismos y participar en discusiones.

## Funcionalidades  

- Registro y autenticación de usuarios
- Creación, edición y eliminación de tópicos
- Respuesta a tópicos existentes
- Listado de usuarios y tópicos
- Autenticación mediante JWT

## Tecnologías utilizadas 

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- JPA (Java Persistence API)
- MySQL
- Insomnia (para pruebas de API)
- Swagger (para documentación de API)

## Estructura del proyecto 

- `Entities`: Clases de entidad que representan las tablas de la base de datos
- `Dto`: Clases de Data Transfer Object utilizadas para transferir datos entre el cliente y el servidor
- `Repository`: Interfaces que extienden JpaRepository para realizar operaciones CRUD en las entidades
- `Service`: Clases de servicio que contienen la lógica de negocio
- `Controller`: Clases de controlador que manejan las solicitudes HTTP
- `Security`: Clases relacionadas con la configuración de seguridad y la autenticación

## Instalación 

1. Clona este repositorio:

```bash
git clone https://github.com/Orliluq/ForoHub.git
```

2. Navega al directorio del proyecto:

```bash
cd ForoHub
```

3. Abre el proyecto en tu IDE .

## Configuración

### Base de datos: MySQL 

Este proyecto está configurado para usar una base de datos MySQL. Puedes cambiar la configuración de la base de datos en el archivo `application.properties`.

### Swagger 

Swagger está configurado para generar documentación de la API automáticamente. Puedes acceder a la interfaz de Swagger en la siguiente URL cuando el servidor esté en funcionamiento:

## Ejecución

Para ejecutar la aplicación, utiliza el siguiente comando en la raíz del proyecto:

```bash
La aplicación estará disponible en `http://localhost:8080`.
```

## Endpoints principales

- `/login`: Endpoint para autenticación de usuarios. Envía una solicitud POST con un JSON que contiene username y password.
- `/usuarios`: Endpoint para listar usuarios. Requiere autenticación mediante un token JWT.
- `/topicos`: Endpoint para manejar la creación, actualización y eliminación de tópicos.

## Ejemplos de solicitudes 

### Autenticación 

Solicitud:

```bash
POST http://localhost:8080/login
```
```json

Body:
{
"username": "nombre_usuario",
"password": "contraseña"
}
```

Respuesta:
```json
{
    "token": "jwt_token_generado"
}
```

### Crear un tópico 

Solicitud:

```bash
POST http://localhost:8080/topicos
```
```json
Headers:
Authorization: Bearer jwt_token_generado
Content-Type: application/json
```
```json
Body:
{
  "titulo": "Nuevo tópico",
  "mensaje": "Contenido del tópico",
  "autor": "Nombre del autor",
  "curso": "Nombre del curso"
}
```


## Contribución

Si deseas contribuir a este proyecto, puedes enviar pull requests con mejoras o correcciones.

## Agradecimientos

Agradezco al Programa ONE de [Alura Latam](https://www.linkedin.com/company/alura-latam/) y [Oracle](https://www.linkedin.com/company/oracle/) por proporcionar el material y el contexto para desarrollar este proyecto.

## Autor

Este proyecto fue creado por [YD](https://www.linkedin.com/company/oracle/).
I
[LinkedIn](www.linkedin.com/in/jddalvarez)
