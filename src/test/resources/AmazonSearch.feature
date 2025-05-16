Feature:Probar la Funcionalidad de Busqueda de Amazon

@cart
Scenario Outline: Como cliente, cuando busco en Alexa, quiero ver si la tercera opción en la segunda página está disponible para comprar y se puede agregar al carrito.
Given el usuario navega a https://www.amazon.com/
And busca el producto <Producto>
And navega a la segunda pagina
And seleccionar el tercer articulo
# Then el usuario es capaz agrega al carrito de compra

Examples: 
        |Producto   |
        |Alexa      |
        |PlayStation|