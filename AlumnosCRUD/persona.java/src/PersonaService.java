import java.util.Scanner;

public class PersonaService {

    InputValidator input = new InputValidator();

    public void alta(Persona[] personas, Scanner sc) {

        int id = input.getValidInt(sc, "Ingresa el ID del nuevo usuario -> ");

        if (id <= 0) {
            System.out.println("Número inválido: No se admiten valores menores que 1");
            return;
        }

        // Verificar si el ID ya existe en el arreglo”

        if (verificarId(id, personas)) {
            System.out.println("El ID existe");
            return;
        }

        System.out.println("Ingrese el NOMBRE del usuario  -> ");
        String name = sc.nextLine();

        // Validar que no se quede en blanco
        if (name.isBlank()) {
            System.out.println("Debe de ingresar un nombre");
            return;
        }

        int indiceInsercion = obtenerIndice(personas);

        if (indiceInsercion == -1) {
            System.out.println("El arreglo está lleno");
            return;
        }

        Persona persona1 = new Persona(id, name);
        personas[indiceInsercion] = persona1;

        System.out.println("La persona fue agregada correctamente");
    }

    public void buscar(Persona[] personas, Scanner sc) {

        int id = input.getValidInt(sc, "Ingrese el ID a buscar -> ");

        for (Persona persona : personas) {
            if (persona != null && persona.getId() == id && persona.isActiva()) {
                System.out.println(persona);
                return;
            }
        }

        System.out.println("Persona NO encontrada o INACTIVA");
    }

    public void bajaLogica(Persona[] personas, Scanner sc) {

        int id = input.getValidInt(sc, "Ingrese el ID para dar de BAJA -> ");

        for (Persona persona : personas) {
            if (persona != null && persona.getId() == id && persona.isActiva()) {
                persona.setActiva(false);
                System.out.println("Baja realizada correctamente");
                return;
            }
        }

        System.out.println("Persona NO encontrada o ya INACTIVA");
    }

    public void listarActivas(Persona[] personas) {

        boolean hayActivas = false;

        for (Persona persona : personas) {
            if (persona != null && persona.isActiva()) {
                System.out.println(persona);
                hayActivas = true;
            }
        }

        if (!hayActivas) {
            System.out.println("No hay personas ACTIVAS");
        }
    }

    public void actualizarNombre(Persona[] personas, Scanner sc) {

        int id = input.getValidInt(sc, "Ingrese el ID que quiere actualizar -> ");

        for (Persona persona : personas) {
            if (persona != null && persona.getId() == id && persona.isActiva()) {

                System.out.println("Ingresa el nuevo nombre -> ");
                String nuevoNombre = sc.nextLine();

                // Validación de que se ingresa un dato
                if (nuevoNombre.isBlank()) {
                    System.out.println("Debe ingresar un nombre");
                    return;
                }

                persona.setNombre(nuevoNombre);
                System.out.println("Nombre ACTUALIZADO correctamente");
                return;
            }
        }

        System.out.println("Persona NO encontrada o ya INACTIVA");
    }

    public boolean verificarId(int id, Persona[] personas) {
        for (Persona persona : personas) {
            if (persona != null && persona.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public int obtenerIndice(Persona[] personas) {
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
