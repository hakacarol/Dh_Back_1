package mesa_de_trabalho;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiguraTest {

    @Test
    void perimetroQuadrado() {
        Quadrado quadrado01 = new Quadrado(5.0);
        Double perimetro = quadrado01.calcularPerimetro();
        assertEquals(20.0, perimetro);
    }

    @Test
    void perimetroCirculo() {
//        Locale.setDefault(Locale.US);
        DecimalFormat df = new DecimalFormat("#.##");
        Circulo circulo01 = new Circulo(5.0);
        Double perimetro = circulo01.calcularPerimetro();
        perimetro = Double.valueOf(df.format(perimetro));
        assertEquals(31.42, perimetro);
    }

}
