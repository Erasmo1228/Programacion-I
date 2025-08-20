DOCUMENTACIÓN DEL SISTEMA DE GESTIÓN DE LIBROS

1. INTRODUCCIÓN
El Sistema de Gestión de Libros es una aplicación diseñada para administrar de manera eficiente libros, lectores y préstamos dentro de una biblioteca o colección. Permite registrar, consultar, actualizar y eliminar información relevante de cada módulo, garantizando un control organizado y fácil de usar.

2. MÓDULOS DE LA APLICACIÓN

2.1. Módulo de Lectores
Este módulo permite gestionar la información de los lectores que pueden tomar libros prestados.

Campos a llenar al agregar un lector:
- Nombre: Nombre completo del lector.
- Dirección: Domicilio del lector.
- Teléfono: Número de contacto.
- Ciudad: Ciudad de residencia.
- Correo: Dirección de correo electrónico.

Cómo usarlo:
1. Ingrese al módulo de Lectores.
2. Seleccione "Agregar lector".
3. Complete todos los campos requeridos.
4. Confirme la operación para registrar al lector en la base de datos.

2.2. Módulo de Préstamos
Este módulo controla los libros prestados a los lectores y su devolución.

Campos a llenar al agregar un préstamo:
- Fecha de préstamo: Día en que se entrega el libro al lector.
- Fecha de regreso: Día en que el lector debe devolver el libro.
- Observaciones: Estado del libro al momento del préstamo (por ejemplo, "buenas condiciones").
- FK_Libro: Identificador del libro que se prestará (ejemplo: si "Harry Potter" tiene FK = 1, se coloca 1).
- FK_Usuario: Identificador del lector que recibe el libro (ejemplo: si "Martín" tiene FK = 4, se coloca 4).

Cómo usarlo:
1. Ingrese al módulo de Préstamos.
2. Seleccione "Registrar préstamo".
3. Complete todos los campos obligatorios.
4. Confirme la operación para guardar el préstamo en el sistema.

2.3. Módulo de Libros
Este módulo permite administrar los libros disponibles en la biblioteca.

Campos a llenar al agregar un libro:
- Título: Nombre del libro.
- Editorial: Editorial que publicó el libro.
- Año: Año de publicación.
- Cantidad: Número de copias disponibles del libro.

Cómo usarlo:
1. Ingrese al módulo de Libros.
2. Seleccione "Agregar libro".
3. Complete los campos requeridos.
4. Confirme la operación para registrar el libro en la base de datos.

3. FUNCIONAMIENTO GENERAL
1. Al iniciar la aplicación, se muestra un menú principal con los tres módulos: Lectores, Libros y Préstamos.
2. Cada módulo permite realizar operaciones de crear, consultar, actualizar y eliminar (CRUD).
3. Los campos deben llenarse correctamente para que la información se registre sin errores.
4. La información se almacena de forma organizada, permitiendo consultar y gestionar los datos en cualquier momento.

4. RECOMENDACIONES DE USO
- Completar todos los campos obligatorios al registrar lectores, libros o préstamos.
- Verificar las FK de libros y usuarios para que los préstamos se registren correctamente.
- Mantener actualizada la información de lectores y libros.
- Registrar la devolución de los libros en la fecha indicada para mantener la base de datos correcta.



Sistema de Gestión de Libros

Sistema de escritorio para administrar lectores, libros y préstamos.

Características

-   Lectores: alta, baja, edición, búsqueda.
-   Libros: registro, inventario, categorías, disponibilidad.
-   Préstamos: crear/devolver, fechas, estado, historial.

Stack

-   Java (JDK 17+)
-   Swing (interfaz)
-   MySQL 8.x

Requisitos

-   JDK 17 o superior
-   MySQL 8.x
-   Variables de conexión a BD

Instalación

    # 1) Clonar
    git clone https://github.com/<usuario>/<repo>.git
    cd <repo>

    # 2) Crear BD
    # Importa el script en /sql/schema.sql (tablas: lectores, libros, prestamos, etc.)

Configuración

Crea un archivo .env o config.properties (según usen) con:

    DB_URL=jdbc:mysql://localhost:3306/biblioteca?useSSL=false&serverTimezone=UTC
    DB_USER=tu_usuario
    DB_PASS=tu_password

Ejecución

-   Con IDE (IntelliJ/Eclipse/NetBeans): abrir el proyecto y ejecutar
    Main.
-   Concompilación simple:

    javac -cp lib/mysql-connector-j.jar -d out src/**/*.java
    java  -cp "out;lib/mysql-connector-j.jar" Main

Estructura del proyecto (resumen)

    src/
      main/
        java/
          app/Main.java
          domain/        # entidades: Lector, Libro, Prestamo
          dao/           # DAO + JDBC
          service/       # lógica de negocio
          ui/            # pantallas Swing
    sql/
      schema.sql
      seed.sql
    lib/
      mysql-connector-j.jar

Uso

1.  Inicia sesión / conecta a la BD.
2.  Gestiona Lectores y Libros.
3.  Crea Préstamos y registra devoluciones.
4.  Consulta historial y disponibilidad.

Roadmap

-   Reportes (PDF/Excel)
-   Búsqueda avanzada
-   Validaciones y manejo de errores mejorado

Contribución

-   Issues y PRs bienvenidos.
-   Estándar de código: Java conventions.
-   Commits claros y descriptivos.

Autores

-   Juan Celedonio
-   Gilbert Perdomo
-   Erasmo Ortega

Licencia

.

