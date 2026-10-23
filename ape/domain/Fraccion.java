package edu.unl.cc.ape.domain;

/**
 * @author Josselin Nero F.
 * Fracción Matemática
 */

public class Fraccion {
    private final int numerador;
    private final int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0)
            throw new IllegalArgumentException("El denominador no puede ser cero.");
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public double aDecimal() {
        return (double) numerador / denominador;
    }

    public Fraccion sumar(Fraccion o) {
        return new Fraccion(numerador * o.denominador + o.numerador * denominador,
                denominador * o.denominador);
    }

    public Fraccion restar(Fraccion o) {
        return new Fraccion(numerador * o.denominador - o.numerador * denominador,
                denominador * o.denominador);
    }

    public Fraccion multiplicar(Fraccion o) {
        return new Fraccion(numerador * o.numerador, denominador * o.denominador);
    }

    public Fraccion dividir(Fraccion o) {
        return multiplicar(o.inversa()); // lanza error si o.numerador == 0
    }

    public Fraccion inversa() {
        if (numerador == 0)
            throw new ArithmeticException("No se puede calcular la inversa: el numerador es cero.");
        return new Fraccion(denominador, numerador);
    }

    public Fraccion simplificar() {
        int mcd = mcd(Math.abs(numerador), Math.abs(denominador));
        int signo = denominador < 0 ? -1 : 1; // deja el signo en el numerador
        return new Fraccion(signo * numerador / mcd, signo * denominador / mcd);
    }

    private static int mcd(int a, int b) {
        return b == 0 ? (a == 0 ? 1 : a) : mcd(b, a % b);
    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }
}



