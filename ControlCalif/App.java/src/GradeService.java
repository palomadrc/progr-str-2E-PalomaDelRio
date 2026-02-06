public class GradeService {

    public double calcularPromedio(double a, double b, double c) {
        return (a + b + c) / 3;
    }

    public double calcularFinal(double promedio, int asistencia) {
        return (promedio * 0.7) + (asistencia * 0.3);
    }

    public String determinarEstado(double finalCalif, int asistencia, boolean entregoProyecto) {

        if (asistencia < 80) {
            return "REPROBADO por ASISTENCIA";
        }

        if (!entregoProyecto) {
            return "REPROBADO por PROYECTO";
        }

        if (finalCalif >= 70) {
            return "APROBADO";
        } else {
            return "REPROBADO por CALIFICACIÓN";
        }
    }
}
