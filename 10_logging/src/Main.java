import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        Integer[] lista = {1, 2, 3, 4, 4};
        Media media = new Media(lista);
        media.setMedia(media.calcularMedia());

        if(media.getListaDeNumeros().length > 10) {
            logger.info("Lista de numero é maior que 10");

        } else if (media.getListaDeNumeros().length >= 5) {
            logger.info("Lista de numero é maior que 5");

        } else if (media.getListaDeNumeros().length > 0) {
            logger.info("Lista de numero é menor que 5");

        } else {
            logger.info("Lista esta vazia");
            return;
        }
        logger.info("A media é igual a: " + media.getMedia());

//        logger.info("Nosso Logger esta funcionando");
//        logger.warn("Nosso Logger esta funcionando");
//        logger.debug("Nosso Logger esta funcionando");
//        logger.error("Nosso Logger esta funcionando");
//        logger.fatal("Nosso Logger esta funcionando");
    }
}
