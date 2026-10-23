package edu.unl.cc.view;

import edu.unl.cc.domain.CuentaBancaria;
import java.util.Scanner;

public class CuentaExecutor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el numero de cuenta: ");
        String nro = scanner.nextLine();
        System.out.print("Ingrese el nombre del titular: ");
        String titular = scanner.nextLine();
        System.out.print("Ingrese el saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        CuentaBancaria cuenta = new CuentaBancaria(nro, titular, saldoInicial);
        int opcion;

        do {
            System.out.println("\n--- MENÚ BANCARIO ---");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Ver Resumen e Historial");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Monto a depositar: ");
                    double dep = scanner.nextDouble();
                    cuenta.depositar(dep);
                    System.out.println("Depósito exitoso.");
                    break;

                case 2:
                    System.out.print("Monto a retirar: ");
                    double ret = scanner.nextDouble();
                    if (cuenta.retirar(ret)) {
                        System.out.println("Retiro exitoso.");
                    } else {
                        System.out.println("Error: Fondos insuficientes.");
                    }
                    break;

                case 3:
                    cuenta.mostrarResumen();
                    break;

                case 4:
                    System.out.println("Gracias por usar el sistema.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
