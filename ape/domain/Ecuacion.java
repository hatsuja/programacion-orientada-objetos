package ec.edu.unl.cc.ape.domain;
/**
 * @author Juan Jumbo
 * Resolver ecuacion cuadratica
 */
public class Ecuacion {
    private Double a;
    private Double b;
    private Double c;

    public Ecuacion(Double a, Double b, Double c) {
        if (a==null||a==0.0){
            throw new IllegalArgumentException("No puede ser 0");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Double calcularDiscriminante() {
        return Math.pow(this.b, 2) - (4 * this.a * this.c);
    }

    public String resolverRaices() {
        Double d = calcularDiscriminante();
        if (d > 0) {
            Double x1 = (-this.b + Math.sqrt(d)) / (2 * this.a);
            Double x2 = (-this.b - Math.sqrt(d)) / (2 * this.a);
            return "Raíces reales distintas: x1 = " + x1 + ", x2 = " + x2;
        } else if (d == 0) {
            Double x = -this.b / (2 * this.a);
            return "Raíz real doble: x = " + x;
        } else {
            Double real = -this.b / (2 * this.a);
            Double imag = Math.sqrt(-d) / (2 * this.a);
            return "Raíces complejas: " + real + " ± " + imag + "i";
        }
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Ecuacion{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
