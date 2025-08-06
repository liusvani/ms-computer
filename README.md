# Microservicio Computer 

El microservicio Computer se encarga de gestionar las entidades informáticas, en concreto, ordenadores de escritorio y portátiles poniéndose de manifiesto la herencia y polimorfismo . Proporciona una API robusta y extensible para gestionar operaciones CRUD, respetando los principios de diseño orientados al dominio y aprovechando la arquitectura hexagonal. 
---

## Funcionalidades Principales

- Crear computadoras de escritorio o portátiles.
- Recuperar, listar y eliminar computadoras por ID.
- Validar datos de entrada para su posteriro persistencia.
---

## Tecnologías Utilizadas

- **Java 17** + **Spring Boot** 
- **Spring Data JPA**
- **PostgreSQL / MySQL** (configurable)
- **Lombok** reduce código repetitivo mediante anotaciones que lo generan automáticamente en tiempo de compilación.
- **Mockito** framework utilizado para realizar pruebas unitarias mediante la creación de objetos simulados (mocks).
- **Junit-jupiter** roporciona el modelo de programación y el modelo de extensión para escribir pruebas unitarias modernas en Java
- **Mockito-junit-jupiter** extensión para integrarse con JUnit 5 que facilita el uso de anotaciones como @Mock y la inyección automática de dependencias simuladas.

---

---

## API REST - Endpoints Claves

| Método | Endpoint                   | Descripción                            |
|--------|----------------------------|----------------------------------------|
| POST   | `/computer`                | Crear computadora.                     |
| GET    | `/computer`                | Listar todas las computadoras.         |
| GET    | `/computer/{id}`           | Obtener computadora por ID.            |
| DELETE | `/reports/{id}`            | Eliminar computadora por ID.           |
| UPDATE | `/reports/{id}`            | Actualizar computadora por ID.         |
--------------------------------------------------------------------------------
##  Ejecución

```bash
# Compilar proyecto
mvn clean install

# Ejecutar microservicio
mvn spring-boot:run
```
---
##  Documentación: Pruebas Unitarias en Casos de Uso y Adaptadores.
Estructura de clases probadas:
- ComputerService: Lógica de negocio para crear, obtener, eliminar y listar computadoras.
- ComputerRepository: Interfaz simulada para acceso a datos.
- Computer: Modelo de dominio.
- BusinessException: Excepción personalizada para reglas de negocio.
  
ComputerService Test Test:
EN este módulo se imlementaron pruebas unitarias para el servicio `ComputerService`, encargado de gestionar operaciones CRUD sobre objetos `Computer`. Las pruebas están escritas con      **JUnit Jupiter (JUnit 5)** y **Mockito**, utilizando buenas prácticas de aislamiento y simulación de dependencias.
  

Pruebas incluidas:
---------------------------------------------------------------------------------------------------------------------
| Método de prueba                              | Propósito                                                         |
|-----------------------------------------------|-------------------------------------------------------------------|
| debeCrearComputadora()                        | Verifica que se puede crear una computadora si no hay conflictos. |
| noDebeCrearComputadoraSiInventarioYaExiste()  | Lanza excepción si el inventario ya existe.                       |
| noDebeCrearComputadoraSiNumeroSerieYaExiste() | Lanza excepción si el número de serie ya existe.                  |
| debeObtenerComputadoraPorId()                 | Verifica que se puede obtener una computadora por su ID.          |
| noDebeObtenerComputadoraSiIdNoExiste()        | Retorna vacío si el ID no existe.                                 |
| debeEliminarComputadoraSiExiste()             | Elimina una computadora existente.                                |
| noDebeEliminarComputadoraSiNoExiste()         | No elimina si la computadora no existe.                           |                          
| noDebeObtenerComputadoraSiIdNoExiste()        | Retorna vacío si el ID no existe.                                 |                          
| debeListarTodasLasComputadoras()              | Verifica que se listan todas las computadoras correctamente.      |                          
---------------------------------------------------------------------------------------------------------------------

## Notas importantes
- Las pruebas usan @ExtendWith(MockitoExtension.class) para integrar Mockito con JUnit 5.
- Se emplea @Mock para simular el repositorio y @InjectMocks para inyectar el servicio.
- Las excepciones de negocio se validan con assertThrows.
- Las interacciones con el repositorio se verifican con verify().
---
##  ComputerRepositoryAdapter Test
Este módulo contiene pruebas unitarias para el adaptador de persistencia `ComputerRepositoryAdapter`, el cual implementa la interfaz `ComputerRepository` y delega operaciones a `JpaComputerRepository`. Las pruebas están escritas con **JUnit Jupiter (JUnit 5)** y **Mockito**, simulando el comportamiento del repositorio JPA para validar la lógica de persistencia.

Clases involucradas:
---------------------------------------------------------------------------------------------------
| Clase                       | Rol                                                               |
|-----------------------------------------------|-------------------------------------------------|
| ComputerRepositoryAdapter   | Adaptador que implementa ComputerRepository usando JPA.           |
| JpaComputerRepository	      | Repositorio JPA simulado con @Mock.                               |
| Computer                    |Entidad del dominio que representa una computadora.                |
---------------------------------------------------------------------------------------------------

Pruebas incluidas:
----------------------------------------------------------------------------------------------------------
| Método de prueba                       | Propósito                                                     |
|----------------------------------------|---------------------------------------------------------------|
| debeGuardarComputer()                  | Verifica que se guarda correctamente una computadora.         |
| debeListarComputadoras()               | Verifica que se listan todas las computadoras..               |
| debeEncontrarPorId()                   | Verifica que se puede obtener una computadora por su ID.      |
| debeEliminarPorId()                    | Verifica que se elimina una computadora por su ID.            |
| debeVerificarInventarioExistente()     | Verifica si un inventario ya existe en la base de datos..     |
| debeVerificarNumeroSerieExistente()    | Verifica si un número de serie ya existe en la base de datos. |                          
---------------------------------------------------------------------------------------------------------------------
Cómo ejecutar las pruebas
Usando Maven

```bash
mvn test
```
Buenas prácticas
- Mantienen las pruebas unitarias aisladas de la base de datos real.
- Simula dependencias externas para validar solo la lógica del adaptador.
- Usa nombres descriptivos en los métodos de prueba para facilitar la lectura.


