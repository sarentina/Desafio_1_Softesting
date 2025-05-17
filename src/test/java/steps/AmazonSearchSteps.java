package steps;

import io.cucumber.java.en.*;
import pages.AmazonSearchPages;

public class AmazonSearchSteps {

    private AmazonSearchPages amazonPage = new AmazonSearchPages();

    @And("^cambia la categoria a (.*)$")
    public void cambia_la_categoria(String categoria) {
        amazonPage.seleccionarCategoria(categoria);
    }

    @And ("^busca el producto (.*)$") 
    public void buscarProductoLista(String producto){
        amazonPage.buscarProducto(producto);
    }

    @And ("^navega a la segunda pagina$")
    public void navega_a_la_segunda_pagina() {
        amazonPage.navegarASegundaPagina();
    }

    @And("^selecciona el primer producto disponible con botón de carrito desde la posición (\\d+)$")
    public void seleccionar_producto_disponible_con_carrito(int posicionInicial) {
        amazonPage.seleccionarProductoValidandoCarrito(posicionInicial);
    }
       

    @And("^agrega el producto al carrito$")
    public void agrega_el_producto_al_carrito() {
        amazonPage.agregarAlCarrito();
    }
                  

}


