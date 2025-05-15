package pages;

public class AmazonSearchPages extends BasePages{
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
}
