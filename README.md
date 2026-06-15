# LlanquihueTourApp

Aplicacion Java de consola para cargar, representar y listar tours turisticos de la zona de Llanquihue desde un archivo de texto. El proyecto organiza la logica en capas simples: modelo de dominio, gestion de datos y punto de entrada de interfaz por consola.

## Que hace el proyecto

LlanquihueTourApp lee un listado de tours desde `resources/tours.txt`, convierte cada linea en un objeto `Tour` y muestra la informacion por consola. Luego aplica un filtro basico para listar solo los tours cuyo precio es mayor a `$10000`.

El flujo principal se encuentra en `src/ui/Main.java`:

1. Crea una instancia de `GestorDatos`.
2. Carga los tours desde el archivo `resources/tours.txt`.
3. Imprime todos los tours disponibles.
4. Filtra e imprime los tours con precio superior a `$10000`.

## Caracteristicas

- Lectura de datos desde archivo plano.
- Separacion basica por paquetes:
  - `model`: entidades del dominio.
  - `data`: carga y transformacion de datos.
  - `ui`: ejecucion principal por consola.
- Representacion de tours con nombre, tipo y precio.
- Filtro de tours por precio.
- Sin dependencias externas.

## Estructura del proyecto

```text
LlanquihueTourApp/
+-- resources/
|   +-- tours.txt
+-- src/
|   +-- data/
|   |   +-- GestorDatos.java
|   +-- model/
|   |   +-- Tour.java
|   +-- ui/
|       +-- Main.java
+-- .gitignore
+-- LlanquihueTourApp.iml
```

## Componentes principales

### `Tour`

Clase del paquete `model` que representa un tour turistico.

Atributos:

- `nombre`: nombre del tour.
- `tipo`: categoria o tipo de experiencia.
- `precio`: valor del tour.

Tambien incluye metodos getters, setters y una implementacion de `toString()` para mostrar el tour en formato legible:

```text
Nombre del tour - tipo - $precio
```

### `GestorDatos`

Clase del paquete `data` encargada de cargar la informacion desde `resources/tours.txt`.

El metodo `cargarTours()`:

- Abre el archivo de datos.
- Lee cada linea.
- Divide los campos usando `;`.
- Crea objetos `Tour`.
- Devuelve una lista `ArrayList<Tour>`.

### `Main`

Clase del paquete `ui` que ejecuta la aplicacion. Es el punto de entrada del programa y contiene la logica de presentacion por consola.

## Formato del archivo de datos

El archivo `resources/tours.txt` usa un formato separado por punto y coma:

```text
nombre;tipo;precio
```

Ejemplo:

```text
Volcan Osorno;aventura;18000
Puerto Varas Nocturno;cultural;8000
```

Cada linea debe contener exactamente tres valores:

- Nombre del tour.
- Tipo de tour.
- Precio como numero entero.

## Requisitos

- JDK instalado.
- IntelliJ IDEA o una terminal con `javac` y `java` disponibles en el `PATH`.

El proyecto esta configurado como modulo Java de IntelliJ y no utiliza Maven ni Gradle.

## Ejecucion en IntelliJ IDEA

1. Abrir el proyecto en IntelliJ IDEA.
2. Verificar que el SDK del proyecto este configurado.
3. Abrir `src/ui/Main.java`.
4. Ejecutar el metodo `main`.

## Ejecucion desde terminal

Desde la raiz del proyecto:

```powershell
javac -d out\production\LlanquihueTourApp src\model\Tour.java src\data\GestorDatos.java src\ui\Main.java
java -cp out\production\LlanquihueTourApp ui.Main
```

Importante: el programa espera encontrar el archivo de datos en `resources/tours.txt`, por lo que debe ejecutarse desde la raiz del proyecto.

## Salida esperada

La aplicacion imprime primero todos los tours cargados y luego solo los tours con precio mayor a `$10000`.

Ejemplo:

```text
TODOS LOS TOURS:
Lago Todos Los Santos - lacustre - $12000
Ruta del Kuchen - gastronomico - $10000
Volcan Osorno - aventura - $18000
Puerto Varas Nocturno - cultural - $8000
Isla de Chiloe - cultural - $15000

TOURS SOBRE $10000:
Lago Todos Los Santos - lacustre - $12000
Volcan Osorno - aventura - $18000
Isla de Chiloe - cultural - $15000
```

## Posibles mejoras

- Validar el formato de cada linea antes de crear un `Tour`.
- Manejar errores de archivo con mensajes mas especificos.
- Permitir filtros dinamicos por tipo, precio minimo o precio maximo.
- Agregar una interfaz de menu por consola.
- Incorporar pruebas unitarias para `GestorDatos` y `Tour`.
- Migrar la carga de archivos a `java.nio.file` para mejorar legibilidad y manejo de rutas.
