<!DOCTYPE html>
<html>
<head>
    
</head>
<body>

<h1>API REST  de Foro </h1>

<p>Esta API proporciona endpoints para gestionar tópicos en un foro. Incluye funcionalidades para crear, listar, actualizar y eliminar tópicos.</p>

<h2>Endpoints</h2>

<h3>Crear un Tópico</h3>
<p><strong>URL:</strong> /topicos</p>
<p><strong>Método:</strong> POST</p>
<p><strong>Descripción:</strong> Crea un nuevo tópico en el foro.</p>
<p><strong>Body de la Solicitud:</strong></p>
<pre>
{
  "titulo": "Título del Tópico",
  "mensaje": "Mensaje del Tópico",
  "autor": "Autor del Tópico",
  "curso": "Curso relacionado"
}
</pre>
<p><strong>Ejemplo de Respuesta:</strong></p>
<pre>
{
  "id": 1,
  "titulo": "Título del Tópico",
  "mensaje": "Mensaje del Tópico",
  "fecha": "2024-07-16T12:34:56",
  "autor": "Autor del Tópico",
  "curso": "Curso relacionado",
  "status": true
}
</pre>

<h3>Listar Tópicos</h3>
<p><strong>URL:</strong> /topicos</p>
<p><strong>Método:</strong> GET</p>
<p><strong>Descripción:</strong> Lista los tópicos en el foro, ordenados por fecha de creación en orden ascendente.</p>
<p><strong>Parámetros de Consulta:</strong></p>
<ul>
    <li><strong>page:</strong> Número de la página (por defecto 0)</li>
    <li><strong>size:</strong> Tamaño de la página (por defecto 10)</li>
</ul>
<p><strong>Ejemplo de Respuesta:</strong></p>
<pre>
{
  "content": [
    {
      "id": 1,
      "titulo": "Título del Tópico",
      "mensaje": "Mensaje del Tópico",
      "fecha": "2024-07-16T12:34:56",
      "autor": "Autor del Tópico",
      "curso": "Curso relacionado",
      "status": true
    }
  ],
  "pageable": {...},
  "totalPages": 1,
  "totalElements": 1
}
</pre>

<h3>Obtener Detalles de un Tópico</h3>
<p><strong>URL:</strong> /topicos/{id}</p>
<p><strong>Método:</strong> GET</p>
<p><strong>Descripción:</strong> Obtiene los detalles de un tópico específico.</p>
<p><strong>Ejemplo de Respuesta:</strong></p>
<pre>
{
  "id": 1,
  "titulo": "Título del Tópico",
  "mensaje": "Mensaje del Tópico",
  "fecha": "2024-07-16T12:34:56",
  "autor": "Autor del Tópico",
  "curso": "Curso relacionado",
  "status": true
}
</pre>

<h3>Actualizar un Tópico</h3>
<p><strong>URL:</strong> /topicos</p>
<p><strong>Método:</strong> PUT</p>
<p><strong>Descripción:</strong> Actualiza los detalles de un tópico existente.</p>
<p><strong>Body de la Solicitud:</strong></p>
<pre>
{
  "id": 1,
  "titulo": "Nuevo Título del Tópico",
  "mensaje": "Nuevo Mensaje del Tópico",
  "autor": "Nuevo Autor del Tópico",
  "curso": "Nuevo Curso relacionado"
}
</pre>
<p><strong>Ejemplo de Respuesta:</strong></p>
<pre>
{
  "id": 1,
  "titulo": "Nuevo Título del Tópico",
  "mensaje": "Nuevo Mensaje del Tópico",
  "fecha": "2024-07-16T12:34:56",
  "autor": "Nuevo Autor del Tópico",
  "curso": "Nuevo Curso relacionado",
  "status": true
}
</pre>

<h3>Eliminar un Tópico</h3>
<p><strong>URL:</strong> /topicos/{id}</p>
<p><strong>Método:</strong> DELETE</p>
<p><strong>Descripción:</strong> Desactiva un tópico, marcándolo como inactivo.</p>
<p><strong>Ejemplo de Respuesta:</strong> 204 No Content</p>

</body>
</html>
