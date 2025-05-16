package steps;

import io.cucumber.java.en.*;
import pages.AmazonSearchPages;

public class AmazonSearchSteps {
    private AmazonSearchPages Amazonpage = new AmazonSearchPages();

   @Given ("^el usuario navega a https://www.amazon.com/$")
    public void navegateToAmazon(){
        Amazonpage.navegateTo();
        Amazonpage.espera();
    }

    @And ("^busca el producto (.*)$") 
    public void buscarProductoLista(String producto){
        Amazonpage.buscarProducto(producto);
    }
    
    @And ("^navega a la segunda pagina$")
    public void navegarPagina2(){
        Amazonpage.irPagina();
    }

    @And ("^seleccionar el tercer articulo$")
    public void seleccionarArticulo3(){
        Amazonpage.Seleccionarproducto3();
    }

}
