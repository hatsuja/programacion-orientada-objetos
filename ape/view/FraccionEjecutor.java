package edu.unl.cc.ape.view;

import edu.unl.cc.ape.domain.Fraccion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FraccionEjecutor {

    public static int ingresarEntero(String mensaje, Scanner sc) {
        System.out.println(mensaje);
        return sc.nextInt();
    }

    private static Fraccion ingresarFraccion(String label, Scanner teclado) {
        Fraccion fraccion = null;

        while (true) {
            try {
                System.out.println("Ingrese la información para la fracción: " + label);
                int numerador = ingresarEntero("Valor del numerador: ", teclado);
                int denominador = ingresarEntero("Valor del denominador: ", teclado);
                fraccion = new Fraccion(numerador, denominador);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Error de entrada");
            } finally {
                if (fraccion == null) {
                    System.out.println("Ingrese nuevamente la fracción...\n\n");
                } else {
                    System.out.println(fraccion + " creada satisfactoriamente!!\n\n");
                }
                teclado.nextLine();
            }
        }
        return fraccion;
    }

    private static void mostrarMenu() {
        System.out.println("===== MENÚ FRACCIÓN MATEMÁTICA =====");
        System.out.println("1. Ingresar numerador y denominador");
        System.out.println("2. Mostrar fracción simplificada");
        System.out.println("3. Mostrar valor aproximado");
        System.out.println("4. Operación (+, -, *, /)");
        System.out.println("5. Salir");
    }

    private static void operar(Fraccion f1, Scanner teclado) {
        Fraccion f2 = ingresarFraccion("con la que desea operar", teclado);
        System.out.println("Operación a realizar (+, -, *, /): ");
        String op = teclado.nextLine().trim();
        Fraccion resultado;

        try {
            switch (op) {
                case "+": resultado = f1.sumar(f2); break;
                case "-": resultado = f1.restar(f2); break;
                case "*": resultado = f1.multiplicar(f2); break;
                case "/": resultado = f1.dividir(f2); break;
                default:
                    System.out.println("Operador no válido.\n");
                    return;
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage() + "\n");
            return;
        }

        Fraccion simplificada = resultado.simplificar();
        System.out.printf("%s %s %s = [%d / %d] = %f \n\n", f1, op, f2,
                simplificada.getNumerador(), simplificada.getDenominador(), simplificada.aDecimal());
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Fraccion fraccion = null;
        int opcion = 0;

        while (opcion != 5) {
            mostrarMenu();
            try {
                opcion = ingresarEntero("Seleccione una opción: ", teclado);
                teclado.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error de entrada\n");
                teclado.nextLine();
                opcion = 0;
                continue;
            }

            if (opcion >= 2 && opcion <= 4 && fraccion == null) {
                System.out.println("Primero debe ingresar una fracción (opción 1).\n");
                continue;
            }

            switch (opcion) {
                case 1:
                    fraccion = ingresarFraccion("A", teclado);
                    break;
                case 2:
                    Fraccion s = fraccion.simplificar();
                    System.out.println("Fracción simplificada: [" + s.getNumerador() + " / " + s.getDenominador() + "]\n");
                    break;
                case 3:
                    System.out.printf("Valor aproximado de %s = %f \n\n", fraccion, fraccion.aDecimal());
                    break;
                case 4:
                    operar(fraccion, teclado);
                    break;
                case 5:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción no válida.\n");
            }
        }

        teclado.close();
    }
}


