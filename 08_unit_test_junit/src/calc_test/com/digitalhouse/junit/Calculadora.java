package calc_test.com.digitalhouse.junit;

public class Calculadora {
    public double sum(double... numbers) {
        double sum = 0;
        if(numbers.length > 0) {
            for(double number : numbers){
                sum += number;
            }
        }
        return sum;
    }
}
