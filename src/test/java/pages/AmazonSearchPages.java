package pages;

public class AmazonSearchPages extends BasePages{

    private String barraBusqueda = "field-keywords"; //Selector por Nombre
    private String btnBuscar = "nav-search-submit-button"; //Selector por ID
    private String btnPagina2 = "//a[@aria-label='Ir a la página 2']";// Selector XPath

    public AmazonSearchPages(){
        super(driver);

    }
    
    public void navegateTo(){
        navegateTo("https://www.amazon.com/");
    }

    public void espera() {
        try {
            Thread.sleep(15000); //pausa de 15 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Metodo para buscar producto 
       public void buscarProducto(String busqueda){
        escribirCampo(barraBusqueda, busqueda);
        clicarElementoId(btnBuscar);
    }

      // Metodo para ir a una pagina 
    public void irPagina(){
        clicarPagina(btnPagina2);
    }

}
