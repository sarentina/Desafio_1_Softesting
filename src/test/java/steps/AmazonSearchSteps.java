package steps;

import io.cucumber.java.en.*;
import pages.AmazonSearchPages;

public class AmazonSearchSteps {

    private AmazonSearchPages amazonPage = new AmazonSearchPages();

    @And ("^busca el producto (.*)$") 
    public void buscarProductoLista(String producto){
        amazonPage.buscarProducto(producto);
    }

    @And ("^navega a la segunda pagina$")
    public void navega_a_la_segunda_pagina() {
        amazonPage.navegarASegundaPagina();
    }

    @And ("^seleccionar el tercer articulo$")
    public void seleccionar_el_tercer_articulo() {
        amazonPage.seleccionarTercerProducto();
    }
    
    // Aquí podrías agregar el paso para agregar al carrito cuando quieras
}


