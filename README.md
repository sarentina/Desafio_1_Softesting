# Desafío 1 - Automatización de Pruebas con Cucumber y Selenium

Este proyecto es parte del semillero de **Softesting** y representa un ejercicio práctico de automatización de pruebas funcionales utilizando **Cucumber**, **Selenium WebDriver**, **Java 17** y herramientas complementarias.

## Objetivo

Automatizar el escenario de búsqueda de productos en (https://www.amazon.com/) y verificar que se puede agregar un producto específico al carrito, de acuerdo a los siguientes pasos definidos en lenguaje Gherkin.

## Escenario Automatizado

gherkin
Feature: Probar la Funcionalidad de Búsqueda de Amazon

@cart
Scenario Outline: Como cliente, cuando busco un producto, quiero ver si la tercera opción en la segunda página está disponible para comprar.
  And cambia la categoria a <Categoria>
  And busca el producto <Producto>
  And navega a la segunda pagina
  And selecciona el primer producto disponible con botón de carrito desde la posición 3
  And agrega el producto al carrito

## Examples: 
  | Categoria              | Producto    |
  | electronics-intl-ship | alexa       |
  | videogames-intl-ship  | PlayStation |

## Estructura del Proyecto

src/test/
├── java/
│   ├── pages/
│   │   ├── AmazonSearchPages.java
│   │   └── BasePages.java
│   ├── runner/
│   │   └── Runner.java
│   ├── steps/
│   │   ├── AmazonSearchSteps.java
│   │   └── Hooks.java
├── resources/
│   └── AmazonSearch.feature
target/
├── cucumber-reports/
└── cucumber.json


## Dependencias Principales
El proyecto utiliza las siguientes dependencias:
dependencies {
    implementation 'org.seleniumhq.selenium:selenium-java:4.21.0'
    implementation 'io.github.bonigarcia:webdrivermanager:5.7.0'
    implementation 'io.cucumber:cucumber-java:7.22.0'
    testImplementation 'org.junit.jupiter:junit-jupiter:5.9.3'
    testImplementation 'io.cucumber:cucumber-junit:7.22.0'
    testImplementation 'org.testng:testng:7.11.0'
}

## Cómo ejecutar
1. git clone https://github.com/sarentina/Desafio_1_Softesting.git
cd Desafio_1_Softesting

2. Asegúrate de tener Java 17 y Gradle configurado.

3. Ejecuta las pruebas usando tu IDE o vía línea de comandos

4. Los reportes se generarán en la carpeta target/cucumber-reports.

## Buenas prácticas aplicadas
Uso de Page Object Model (POM) para desacoplar la lógica de las páginas.

Separación de responsabilidades en steps, pages, runner y hooks.

Escenarios escritos en lenguaje natural (Gherkin) para fácil entendimiento.

## Autora
Sarentina
GitHub: @sarentina
