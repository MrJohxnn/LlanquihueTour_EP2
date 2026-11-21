![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 🧠 Evaluación Parcial 2 – Desarrollo Orientado a Objetos I

## 👤 Autor del proyecto
- **Nombre completo:** Johann Bernardo Gómez Norambuena
- **Sección:** 24684441
- **Carrera:** Desarrollo de Aplicaciones
- **Sede:** Online

---

## 📘 Descripción general del sistema

**Llanquihue Tour** es una aplicación desarrollada en Java para representar información de clientes y empleados de una empresa de turismo mediante programación orientada a objetos.

El proyecto aplica los conceptos de **encapsulamiento, herencia y composición**, utilizando clases relacionadas para organizar los datos de personas, direcciones y RUT.

La clase `Persona` contiene los atributos comunes de clientes y empleados. Las clases `Cliente` y `Empleado` heredan de `Persona` e incorporan sus propios atributos. A su vez, los objetos de tipo `Persona` se relacionan con objetos `Direccion` y `Rut` mediante composición.

En esta segunda evaluación, el sistema incorpora colecciones `ArrayList`, lectura de archivos TXT, validación de RUT, prevención de registros duplicados, búsquedas, filtros y manejo de excepciones. Estas funcionalidades permiten cargar, administrar y consultar información de clientes y empleados desde la consola.

---

## 🧱 Estructura general del proyecto

```plaintext
📁 src/
├── app/         # AppLlanquihueTour: clase principal
├── model/       # Persona, Cliente, Empleado y Direccion
├── utiles/      # Rut: representación y validación del RUT
├── service/     # GestionPersonas: administración de registros
└── data/        # CargarPersonas: lectura de archivos TXT
```

El proyecto también incluye el archivo `personas.txt` en su directorio raíz, utilizado como fuente de datos para cargar los registros.

### Clases principales

- **Persona:** clase base que contiene los atributos comunes de clientes y empleados.
- **Cliente:** hereda de `Persona` y agrega código de cliente y condición de cliente frecuente.
- **Empleado:** hereda de `Persona` y agrega código de empleado, cargo y sueldo.
- **Direccion:** representa los datos de ubicación asociados a una persona.
- **Rut:** representa el RUT e incorpora su validación mediante el algoritmo Módulo 11.
- **GestionPersonas:** administra una colección `ArrayList<Persona>`, permitiendo agregar, buscar, filtrar y mostrar registros.
- **CargarPersonas:** lee el archivo `personas.txt`, interpreta sus registros y construye los objetos correspondientes.
- **AppLlanquihueTour:** contiene el método `main` y ejecuta las funcionalidades y pruebas del sistema.

---

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

### Requisitos previos

Para compilar y ejecutar el proyecto se necesita:

- **Java Development Kit (JDK):** versión 26 o superior.
- **Entorno de desarrollo:** Apache NetBeans.
- **Git:** para clonar el repositorio (opcional si se descarga como ZIP).

### Pasos para ejecutar

1. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/MrJohxnn/LlanquihueTour_EP2.git
```

2. Abre el proyecto **LlanquihueTour_EP2** en Apache NetBeans.
3. Verifica que el proyecto tenga configurado un JDK compatible.
4. Comprueba que el archivo `personas.txt` se encuentre en el directorio raíz del proyecto.
5. Ubica la clase `AppLlanquihueTour` dentro del paquete `app`.
6. Ejecuta el proyecto mediante el método `main` o presionando **F6** en NetBeans.
7. Revisa en la consola los resultados de la carga de datos, validaciones, búsquedas y filtros.

### Archivo de datos

El sistema utiliza el archivo `personas.txt` para cargar los registros de clientes y empleados.

Cada línea contiene los datos de una persona, separados mediante punto y coma (`;`).

El primer campo identifica el tipo de registro:

- `CLIENTE`: contiene los datos personales, dirección, código de cliente y condición de cliente frecuente.
- `EMPLEADO`: contiene los datos personales, dirección, código de empleado, cargo y sueldo.

Durante la ejecución, la clase `CargarPersonas` lee el archivo y construye los objetos correspondientes, que posteriormente son almacenados mediante `GestionPersonas`.

**Importante:** el archivo `personas.txt` debe mantenerse en la raíz del proyecto para que la aplicación pueda encontrarlo utilizando la ruta relativa configurada.

---

## 🧪 Pruebas adicionales

El proyecto permite comprobar el funcionamiento de sus principales características mediante diferentes pruebas.

### 1. Carga de registros

Al ejecutar el programa, se leen los datos de `personas.txt` y se incorporan a una colección `ArrayList<Persona>`.

Los registros cargados pueden visualizarse en consola.

### 2. Búsqueda por RUT

El sistema permite buscar personas utilizando su RUT.

La búsqueda admite diferentes formatos, por ejemplo:

- `12345678-5`
- `12.345.678-5`
- `123456785`

Los tres formatos corresponden al mismo RUT y permiten encontrar el mismo registro.

Si el RUT no existe, el sistema informa que no se encontró la persona.

### 3. Filtros de personas

El programa permite mostrar por separado:

- Todos los registros.
- Solamente los clientes.
- Solamente los empleados.

Los filtros utilizan `instanceof` para identificar el tipo de objeto almacenado.

### 4. Validación de registros

La clase `GestionPersonas` comprueba que los RUT sean válidos y evita incorporar registros duplicados.

### 5. Manejo de errores del archivo TXT

Para comprobar el manejo de excepciones, se puede agregar temporalmente una línea con un valor numérico incorrecto en `personas.txt`.

Ejemplo:

```plaintext
CLIENTE;Prueba;Error;12345678;5;Calle Falsa;ABC;Puerto Varas;Puerto Varas;C999;false
```

El valor `ABC` no puede convertirse a número entero, por lo que se genera una excepción `NumberFormatException`.

El programa informa el error y continúa procesando los demás registros.

**Nota:** después de realizar la prueba, se recomienda eliminar el registro incorrecto para conservar el archivo original.

---
**Repositorio GitHub:** [https://github.com/MrJohxnn/LlanquihueTour_EP2](https://github.com/MrJohxnn/LlanquihueTour_EP2)

**Fecha de entrega:** 21/11/2026

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Evaluación Parcial 2