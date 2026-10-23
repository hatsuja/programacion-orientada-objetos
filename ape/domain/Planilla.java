package edu.unl.cc.ape.domain;

    public class Planilla {
        // Atributos
        private String numeroMedidor;
        private String nombreTitular;
        private double lecturaAnterior;
        private double lecturaActual;

        // Constructor
        public Planilla(String numeroMedidor, String nombreTitular, double lecturaAnterior, double lecturaActual) {
            this.numeroMedidor = numeroMedidor;
            this.nombreTitular = nombreTitular;
            this.lecturaAnterior = lecturaAnterior;

            // El setter se encarga de validar y asignar la lectura actual.
            setLecturaActual(lecturaActual);
        }

        // GETTERS
        public String getNumeroMedidor() {
            return numeroMedidor;
        }

        public String getNombreTitular() {
            return nombreTitular;
        }

        public double getLecturaAnterior() {
            return lecturaAnterior;
        }

        public double getLecturaActual() {
            return lecturaActual;
        }

        // SETTERS
        public void setNumeroMedidor(String numeroMedidor) {
            this.numeroMedidor = numeroMedidor;
        }

        public void setNombreTitular(String nombreTitular) {
            this.nombreTitular = nombreTitular;
        }

        public void setLecturaAnterior(double lecturaAnterior) {
            this.lecturaAnterior = lecturaAnterior;
        }

        public void setLecturaActual(double lecturaActual) {
            if (lecturaActual < this.lecturaAnterior) {
                throw new IllegalArgumentException("Error: La lectura actual (" + lecturaActual
                        + " kWh) no puede ser menor a la lectura anterior (" + this.lecturaAnterior + " kWh).");
            }
            this.lecturaActual = lecturaActual;
        }

        public double calcularConsumo() {
            return this.lecturaActual - this.lecturaAnterior;
        }
        public double calcularSubtotal() {
            double consumo = calcularConsumo();
            double subtotal = 0;

            if (consumo <= 100) {
                subtotal = consumo * 0.1;
            } else if (consumo <= 200) {
                subtotal = (100 * 0.1) + ((consumo - 100) * 0.15);
            } else {
                subtotal = (100 * 0.1) + (100 * 0.15) + ((consumo - 200) * 0.2);
            }

            return subtotal;
        }

        public double calcularIVA() {
            return calcularSubtotal() * 0.15;
        }

        public double calcularTotal() {
            return calcularSubtotal() + calcularIVA();
        }

        @Override
        public String toString() {
            return "PLANILLA DE LUZ" +
                    "\nTitular: " + nombreTitular +
                    "\nMedidor: " + numeroMedidor +
                    "\nConsumo: " + calcularConsumo() + " kWh" +
                    "\nSubtotal: $" + String.format("%.2f", calcularSubtotal()) +
                    "\nIVA (15%): $" + String.format("%.2f", calcularIVA()) +
                    "\nTotal a Pagar: $" + String.format("%.2f", calcularTotal());
        }






    }
