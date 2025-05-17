Feature: Probar la Funcionalidad de Búsqueda de Amazon
@cart
Scenario Outline: Como cliente, cuando busco un producto, quiero ver si la tercera opción en la segunda página está disponible para comprar.
  And cambia la categoria a <Categoria>
  And busca el producto <Producto>
  And navega a la segunda pagina
  And selecciona el primer producto disponible con botón de carrito desde la posición 3
  And agrega el producto al carrito

Examples: 
  | Categoria    | Producto    |
  | electronics-intl-ship | alexa      |
  | videogames-intl-ship  | PlayStation |
