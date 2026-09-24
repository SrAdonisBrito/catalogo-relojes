# Catálogo de Relojes API

API REST para gestionar un catálogo de relojes. Proyecto de práctica para reforzar fundamentos de backend con Spring Boot.

## Tecnologías

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL (Neon)
- Maven

## Endpoints

| Verbo  | Ruta                | Descripción           |
|--------|---------------------|------------------------|
| GET    | /api/relojes         | Lista todos los relojes |
| GET    | /api/relojes/{id}    | Busca un reloj por id  |
| POST   | /api/relojes         | Crea un reloj nuevo    |
| PUT    | /api/relojes/{id}    | Actualiza un reloj     |
| DELETE | /api/relojes/{id}    | Elimina un reloj       |

## Cómo levantarlo localmente

1. Clonar el repositorio
2. Configurar las variables de entorno: `DB_URL`, `DB_USER`, `DB_PASSWORD` (conexión a PostgreSQL)
3. Ejecutar `CatalogoRelojesApplication`
4. La API queda disponible en `http://localhost:8080`

## Ejemplo de body para crear un reloj (POST)

\`\`\`json
{
"marca": "Casio",
"modelo": "MTP-1374",
"precio": 45.99,
"stock": 10
}
\`\`\`

## Qué aprendí construyendo esto

- Arquitectura en capas: Controller, Service, Repository, Model
- Inyección de dependencias por constructor
- Validaciones con Bean Validation (`@Valid`, `@NotBlank`, `@Positive`)
- Manejo de códigos de estado HTTP según la operación (200, 201, 204, 400)
- Conexión a PostgreSQL con variables de entorno en vez de credenciales expuestas
- Relaciones JPA `@OneToMany`/`@ManyToOne` y el rol de `mappedBy`
- Manejo de referencias circulares en JSON con `@JsonManagedReference`/`@JsonBackReference`
- Riesgos de `ddl-auto=update` al modificar un esquema con datos existentes