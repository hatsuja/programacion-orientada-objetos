package edu.unl.cc.domain;

/**
 * Cuenta Bancaria problem
 * @author Wilson Joel Guevara Moncada
 */

import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private List<String> historial;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.historial = new ArrayList<>();
        this.historial.add("Apertura: +" + saldoInicial);
    }

    public void depositar(double monto) {
        this.saldo += monto;
        this.historial.add("Depósito: +" + monto);
    }

    public boolean retirar(double monto) {
        if (monto > this.saldo) {
            this.historial.add("Retiro rechazado (Sin fondos): " + monto);
            return false;
        }
        this.saldo -= monto;
        this.historial.add("Retiro: -" + monto);
        return true;
    }

    public void mostrarResumen() {
        System.out.println("Titular: " + this.titular);
        System.out.println("Cuenta: " + this.numeroCuenta);
        System.out.printf("Saldo: $%.2f\n", this.saldo);
        System.out.println("Movimientos:");

        if (historial.isEmpty()) {
            System.out.println("Sin movimientos.");
        } else {
            for (String movimiento : historial) {
                System.out.println("  " + movimiento);
            }
        }
    }

    public double getSaldo() {
        return saldo;
    }
}

