# LlanquihueTourApp

Aplicacion Java de consola para cargar, representar, listar y buscar tours turisticos de la zona de Llanquihue. El proyecto organiza la logica en capas simples: modelo de dominio, gestion de datos, servicios de busqueda y punto de entrada por consola.

## Que hace el proyecto

LlanquihueTourApp combina dos formas de representar servicios turisticos:

- Crea servicios especializados en memoria, como rutas gastronomicas, paseos lacustres y excursiones culturales.
- Lee un listado de tours desde `resources/tours.txt`, convierte cada linea en un objeto `Tour` y muestra la informacion por consola.

El flujo principal se encuentra en `src/ui/Main.java`:

1. Crea una instancia de `GestorServicios`.
2. Crea una instancia de `ServicioBusqueda`.
3. Genera y muestra servicios turisticos especializados con `crearServicios()`.
4. Carga los tours desde `resources/tours.txt`.
5. Busca e imprime los tours de tipo `cultural`.
6. Imprime todos los tours disponibles.
7. Filtra e imprime los tours con tarifa superior a `$10000`.

## Caracteristicas

- Lectura de datos desde archivo plano.
- Separacion basica por paquetes:
  - `model`: entidades del dominio.
  - `data`: creacion y carga de servicios.
  - `service`: operaciones de busqueda.
  - `ui`: ejecucion principal por consola.
- Representacion de tours con nombre, tipo y tarifa.
- Modelo base `ServicioTuristico` con clases especializadas:
  - `RutaGastronomica`
  - `PaseoLacustre`
  - `ExcursionCultural`
- Busqueda de tours por tipo.
- Filtro de tours por tarifa.
- Sin dependencias externas.

## Estructura del proyecto

```text
LlanquihueTourApp/
+-- resources/
|   +-- tours.txt
+-- src/
|   +-- data/
|   |   +-- GestorServicios.java
|   +-- model/
|   |   +-- ExcursionCultural.java
|   |   +-- PaseoLacustre.java
|   |   +-- RutaGastronomica.java
|   |   +-- ServicioTuristico.java
|   |   +-- Tour.java
|   +-- service/
|   |   +-- ServicioBusqueda.java
|   +-- ui/
|       +-- Main.java
+-- .gitignore
+-- LlanquihueTourApp.iml
```

## Componentes principales

### `Tour`

Clase del paquete `model` que representa un tour cargado desde archivo.

Atributos:

- `nombre`: nombre del tour.
- `tipo`: categoria o tipo de experiencia.
- `tarifa`: valor del tour.

Incluye getters, setters y una implementacion de `toString()` para mostrar el tour en formato legible:

```text
nombre | tipo | $tarifa
```

### `ServicioTuristico`

Clase base del paquete `model` para representar servicios turisticos creados en memoria.

Atributos:

- `nombre`: nombre del servicio turistico.
- `duracionHoras`: duracion estimada del servicio.

### `RutaGastronomica`

Subclase de `ServicioTuristico` que agrega:

- `numeroDeParadas`: cantidad de paradas incluidas en la ruta.

### `PaseoLacustre`

Subclase de `ServicioTuristico` que agrega:

- `tipoEmbarcacion`: embarcacion utilizada en el paseo.

### `ExcursionCultural`

Subclase de `ServicioTuristico` que agrega:

- `lugarHistorico`: lugar historico asociado a la excursion.

### `GestorServicios`

Clase del paquete `data` encargada de gestionar servicios y cargar tours.

Metodos principales:

- `crearServicios()`: crea servicios turisticos especializados en memoria y los imprime por consola.
- `cargarTours()`: lee `resources/tours.txt`, separa cada linea por `;`, crea objetos `Tour` y devuelve un `ArrayList<Tour>`.

### `ServicioBusqueda`

Clase del paquete `service` que contiene operaciones de busqueda sobre tours.

El metodo `buscarPorTipo(ArrayList<Tour> tours, String tipo)` recorre la lista e imprime los tours cuyo tipo coincide, ignorando mayusculas y minusculas.

### `Main`

Clase del paquete `ui` que ejecuta la aplicacion. Es el punto de entrada del programa y coordina la creacion de servicios, la carga de datos, la busqueda por tipo y los filtros por tarifa.

## Formato del archivo de datos

El archivo `resources/tours.txt` usa un formato separado por punto y coma:

```text
nombre;tipo;tarifa
```

Ejemplo:

```text
Volcan Osorno;aventura;18000
Puerto Varas Nocturno;cultural;8000
```

Cada linea debe contener exactamente tres valores:

- Nombre del tour.
- Tipo de tour.
- Tarifa como numero entero.

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
javac -d out\production\LlanquihueTourApp src\model\*.java src\data\*.java src\service\*.java src\ui\*.java
java -cp out\production\LlanquihueTourApp ui.Main
```

Importante: el programa espera encontrar el archivo de datos en `resources/tours.txt`, por lo que debe ejecutarse desde la raiz del proyecto.

## Salida esperada

La aplicacion imprime primero los servicios turisticos creados en memoria. Luego muestra los tours culturales, todos los tours cargados desde archivo y finalmente los tours con tarifa mayor a `$10000`.

Ejemplo:

```text
Servicio TuristicoNombre: 'Ruta del Salmon', Duracion de Horas: 4, Numero de paradas: 5
Servicio TuristicoNombre: 'Ruta del Queso', Duracion de Horas: 3, Numero de paradas: 4
Servicio TuristicoNombre: 'Lago Llanquihue', Duracion de Horas: 2, Tipo de Embarcacion: Catamaran
Servicio TuristicoNombre: 'Lago Todos los Santos', Duracion de Horas: 3, Tipo de Embarcacion: Lancha
Servicio TuristicoNombre: 'Museo Colonial', Duracion de Horas: 5, lugarHistorico: Fuerte Historico
Servicio TuristicoNombre: 'Puerto Varas', Duracion de Horas: 4, lugarHistorico: Iglesia del Sagrado Corazon

TOURS CULTURALES:
Puerto Varas Nocturno | cultural | $8000
Isla de Chiloe | cultural | $15000
TODOS LOS TOURS:
Lago Todos Los Santos | lacustre | $12000
Ruta del Kuchen | gastronomico | $10000
Volcan Osorno | aventura | $18000
Puerto Varas Nocturno | cultural | $8000
Isla de Chiloe | cultural | $15000

TOURS SOBRE $10000:
Lago Todos Los Santos | lacustre | $12000
Volcan Osorno | aventura | $18000
Isla de Chiloe | cultural | $15000
```

## Posibles mejoras

- Validar el formato de cada linea antes de crear un `Tour`.
- Manejar errores de archivo con mensajes mas especificos.
- Devolver listas desde `crearServicios()` y `buscarPorTipo()` en vez de imprimir directamente.
- Permitir filtros dinamicos por tipo, tarifa minima o tarifa maxima.
- Agregar una interfaz de menu por consola.
- Incorporar pruebas unitarias para `GestorServicios`, `ServicioBusqueda` y las clases de `model`.
- Migrar la carga de archivos a `java.nio.file` para mejorar legibilidad y manejo de rutas.
