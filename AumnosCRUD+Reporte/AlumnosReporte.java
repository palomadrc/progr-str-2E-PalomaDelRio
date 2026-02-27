import java.util.Scanner;

class Alumno {
    int id;
    String nombre;
    double promedio;
    boolean activo;

    public Alumno(int id, String nombre, double promedio) {
        this.id = id;
        this.nombre = nombre;
        this.promedio = promedio;
        this.activo = true;
    }
}

public class AlumnosReporte {

    public static void main(String[] args) {

        Alumno[] alumnos = new Alumno[25];
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menu");
            System.out.println("1) Alta alumno");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Actualizar promedio");
            System.out.println("4) Baja logica");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            if (opcion == 1) {

                System.out.print("ID (no se admite 0): ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Promedio (0-10): ");
                double promedio = sc.nextDouble();

                boolean guardado = false;

                for (int i = 0; i < alumnos.length; i++) {
                    if (alumnos[i] == null) {
                        alumnos[i] = new Alumno(id, nombre, promedio);
                        System.out.println("Alumno registrado");
                        guardado = true;
                        break;
                    }
                }

                if (!guardado) {
                    System.out.println("Arreglo lleno");
                }

            } else if (opcion == 2) {

                System.out.print("ID a buscar: ");
                int id = sc.nextInt();

                for (int i = 0; i < alumnos.length; i++) {
                    if (alumnos[i] != null && alumnos[i].id == id && alumnos[i].activo) {
                        System.out.println("ID: " + alumnos[i].id);
                        System.out.println("Nombre: " + alumnos[i].nombre);
                        System.out.println("Promedio: " + alumnos[i].promedio);
                    }
                }

            } else if (opcion == 3) {

                System.out.print("ID: ");
                int id = sc.nextInt();

                for (int i = 0; i < alumnos.length; i++) {
                    if (alumnos[i] != null && alumnos[i].id == id && alumnos[i].activo) {
                        System.out.print("Nuevo promedio (0-10): ");
                        alumnos[i].promedio = sc.nextDouble();
                        System.out.println("Actualizado");
                    }
                }

            } else if (opcion == 4) {

                System.out.print("ID: ");
                int id = sc.nextInt();

                for (int i = 0; i < alumnos.length; i++) {
                    if (alumnos[i] != null && alumnos[i].id == id && alumnos[i].activo) {
                        alumnos[i].activo = false;
                        System.out.println("Baja realizada");
                    }
                }

            } else if (opcion == 5) {

                for (int i = 0; i < alumnos.length; i++) {
                    if (alumnos[i] != null && alumnos[i].activo) {
                        System.out.println(alumnos[i].id + " - " + alumnos[i].nombre + " - " + alumnos[i].promedio);
                    }
                }

            } else if (opcion == 6) {

                double suma = 0;
                int contador = 0;
                Alumno mayor = null;
                Alumno menor = null;
                int mayores8 = 0;

                for (int i = 0; i < alumnos.length; i++) {

                    Alumno a = alumnos[i];

                    if (a != null && a.activo) {

                        suma += a.promedio;
                        contador++;

                        if (mayor == null || a.promedio > mayor.promedio) {
                            mayor = a;
                        }

                        if (menor == null || a.promedio < menor.promedio) {
                            menor = a;
                        }

                        if (a.promedio >= 8.0) {
                            mayores8++;
                        }
                    }
                }

                if (contador == 0) {

                    System.out.println("No hay alumnos activos");

                } else {

                    double promedioGeneral = suma / contador;

                    System.out.println("Promedio general: " + promedioGeneral);

                    String datosMayor = mayor.id + " - " + mayor.nombre + " - " + mayor.promedio;
                    System.out.println("Mayor promedio: " + datosMayor);

                    String datosMenor = menor.id + " - " + menor.nombre + " - " + menor.promedio;
                    System.out.println("Menor promedio: " + datosMenor);

                    System.out.println("Alumnos con promedio >= 8: " + mayores8);
                }

            } else if (opcion == 0) {

                System.out.println("Saliendo...");
            }

        } while (opcion != 0);
    }
}
