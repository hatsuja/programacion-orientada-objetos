package ec.edu.unl.cc.ape.view;
import ec.edu.unl.cc.ape.domain.Ecuacion;
import java.util.Scanner;
public class EcuacionExecutor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ecuacion ecuacion = null;
        String opcion = "";
        while (!opcion.equals("3")) {
            System.out.println("\n--- MENÚ ECUACIÓN CUADRÁTICA ---");
            System.out.println("1. Ingresar coeficientes (a, b, c)");
            System.out.println("2. Calcular y mostrar las raíces");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.next();
            switch (opcion) {
                case "1":
                    System.out.print("Ingrese a: ");
                    Double a = scanner.nextDouble();
                    System.out.print("Ingrese b: ");
                    Double b = scanner.nextDouble();
                    System.out.print("Ingrese c: ");
                    Double c = scanner.nextDouble();
                    if (a == 0) {
                        System.out.println("Error: 'a' no puede ser 0 en una ecuación cuadrática.");
                    } else {
                        ecuacion = new Ecuacion(a, b, c);
                        System.out.println("Ecuación creada: " + ecuacion);
                    }
                    break;

                case "2":
                    if (ecuacion == null) {
                        System.out.println("Aviso: Primero debe ingresar los coeficientes en la opción 1.");
                    } else {
                        System.out.println("Ecuación: " + ecuacion);
                        System.out.println("Discriminante: " + ecuacion.calcularDiscriminante());
                        System.out.println("Resultado: " + ecuacion.resolverRaices());
                    }
                    break;
                case "3":
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción incorrecta. Ingrese 1, 2 o 3.");
            }
        }
        scanner.close();
    }
}