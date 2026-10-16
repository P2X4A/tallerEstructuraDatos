# Estructuras de Datos Basicas

Implementacion propia de estructuras de datos lineales usadas en algoritmos.

## Detalle

| | |
|---|---|
| Tipo | Consola (MVC) |
| Archivos Java | 6 |
| Version de Java | 19 |
| Patron | Implementaciones propias sin usar las colecciones de java.util |

## Funcionalidades

- Arreglo con insercion y busqueda secuencial
- Pila (Stack)
- Cola circular con avance circular
- Menu de operaciones por estructura

## Estructura del proyecto

```
tallerEstructuraDatos/
|-- pom.xml       configuracion de Maven, importable desde cualquier IDE
|-- src/          codigo fuente
`-- README.md
```

## Como ejecutarlo

### Con Maven

```bash
mvn clean compile
mvn exec:java
```

### Con javac directamente

```bash
# Linux / macOS
javac -d bin $(find src -name "*.java")

# Windows (PowerShell)
javac -d bin (Get-ChildItem -Recurse -Filter *.java src).FullName
```

```bash
java -cp bin co.edu.unbosque.controller.AplMain
```

### Desde un IDE

Cualquier IDE con soporte de Java (Eclipse, IntelliJ IDEA, VS Code o NetBeans)
puede importar el proyecto directamente como **proyecto Maven**. Basta con abrir
o importar la carpeta: el IDE detecta el `pom.xml`, resuelve las dependencias y
compila sin configuracion adicional.

## Autor

Desarrollado por [Sergio Parra](https://github.com/P2X4A) como parte de su
formacion en Java.

## Licencia

Ver el archivo [LICENSE](LICENSE).