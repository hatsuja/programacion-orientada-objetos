package edu.unl.cc.ape.view;

import edu.unl.cc.ape.domain.Planilla;
import java.util.Scanner;

/**
 * Clase ejecutable para interactuar con el usuario a través de consola,
 * registrar los datos de la planilla de luz y gestionar posibles errores de ingreso.
 *
 * @author Willy Ramirez
 */
public class PlanillaExecutor {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean exito = false;

        System.out.println("SISTEMA DE GESTIÓN DE PLANILLAS DE LUZ");

        while (!exito) {
            try {
                System.out.print("\nIngrese el número de medidor: ");
                String medidor = teclado.nextLine();

                System.out.print("Ingrese el nombre del titular: ");
                String titular = teclado.nextLine();

                System.out.print("Ingrese la lectura anterior (kWh): ");
                double lecturaAnterior = Double.parseDouble(teclado.nextLine());

                System.out.print("Ingrese la lectura actual (kWh): ");
                double lecturaActual = Double.parseDouble(teclado.nextLine());

                Planilla planilla = new Planilla(medidor, titular, lecturaAnterior, lecturaActual);

                System.out.println("\nPlanilla registrada con exito!\n");
                System.out.println(planilla);

                exito = true;

            } catch (IllegalArgumentException e) {
                System.out.println("\nERROR DE INGRESO " + e.getMessage());
                System.out.println("Por favor, intente ingresar los datos nuevamente.");
            }
        }

        teclado.close();
        System.out.println("\nPrograma finalizado correctamente.");
    }
}