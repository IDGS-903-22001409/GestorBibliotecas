Api Rick and Morty

Ejemplo de consumo de la api de Rick and Morty con React, JavaScript, incluyendo paginacion de las 42 paginas que ofrece la api publica.

Rick and Morty API Reference

La API permite obtener información sobre los personajes, ubicaciones y episodios de la serie Rick and Morty.
En este proyecto solo se usa el endpoint de personajes (/character).

### Get All characters

```http
Get all characters
 GET https://rickandmortyapi.com/api/character

```
 test
| Parameter | Type     | Description                                                         |
| :-------- | :------- | :------------------------------------------------------------------ |
| `pagina`  | `number` | (opcional) Número de página de resultados. Por defecto inicia en 1. |

### Ejemplo de respuesta

{
"info": {
"count": 826,
"pages": 42,
"next": "https://rickandmortyapi.com/api/character/?page=2",
"prev": null
},
"results": [
{
"id": 1,
"name": "Rick Sanchez",
"status": "Alive",
"species": "Human",
"image": "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
"episode": ["https://rickandmortyapi.com/api/episode/1", "..."]
}
]
}

#### Filtrar personajes

```http
  GET /api/character/?name={name}

```

| Parameter | Type     | Description                                           |
| :-------- | :------- | :---------------------------------------------------- |
| `nombre`  | `string` | Requerido. Nombre (o parte del nombre) del personaje. |

#### Ejemplo de respuesta

{
"info": {
"count": 107,
"pages": 6,
"next": "https://rickandmortyapi.com/api/character/?page=2&name=rick",
"prev": null
},
"results": [
{
"id": 1,
"name": "Rick Sanchez",
"status": "Alive",
"species": "Human",
"image": "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
}
]
}

test
