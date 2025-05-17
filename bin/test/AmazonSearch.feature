Feature: Probar la Funcionalidad de Búsqueda de Amazon
@cart
Scenario Outline: Como cliente, cuando busco un producto, quiero ver si la tercera opción en la segunda página está disponible para comprar.
  And busca el producto <Producto>
  And navega a la segunda pagina
  And seleccionar el tercer articulo
  # Then el usuario es capaz de agregar al carrito de compra

Examples: 
  | Producto    |
  | Alexa       |
  | PlayStation |
