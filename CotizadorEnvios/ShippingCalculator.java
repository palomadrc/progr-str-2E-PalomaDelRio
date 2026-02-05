package CotizadorEnvios;

public class ShippingCalculator {

    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota) {

        double subtotal = 0;

        //Asignación Tipo de servicio
        if (tipoServicio == 1) {

            subtotal = 50;
        }else if (tipoServicio == 2) {
            subtotal = 90;
        }

        subtotal = subtotal + (pesoKg*12);

        //Validación Distancia
        if (distanciaKm <= 50) {
            subtotal = subtotal + 20;

        }else if (distanciaKm >= 51 && distanciaKm <= 200) {
            subtotal = subtotal + 60;
        }else {
            subtotal = subtotal + 120;
        }

        //Validación Zona remota
        if (zonaRemota == true) {
            subtotal = subtotal + (subtotal * 0.10);
        }

        return subtotal;
    }

        //Cáñculo del IVA
        public double calcularIVA(double subtotal){
            return subtotal * .16;
        }

        //Cálculo Total con IVA
        public double calcularTotal(double subtotal, double iva) {
            return subtotal + iva;
        }

        //Validación Tipo de Servicio
        public String obtenerNombreServicio(int tipoServicio) {
        if (tipoServicio == 1) {
            return "Estándar";
        } else {
            return "Express";
        }
    }

}

