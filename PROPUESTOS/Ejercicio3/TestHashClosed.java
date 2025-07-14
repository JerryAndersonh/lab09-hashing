import java.util.Scanner;

public class TestHashClosed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashClosed<String> hash = new HashClosed<>(8);
        int opcion;

        do {
            System.out.println("\n--- MENU HASH CERRADO ---");
            System.out.println("1. Insertar");
            System.out.println("2. Buscar");
            System.out.println("3. Eliminar");
            System.out.println("4. Mostrar tabla");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese clave (int): ");
                    int clave = sc.nextInt();
                    sc.nextLine(); // Limpiar buffer
                    System.out.print("Ingrese valor (String): ");
                    String valor = sc.nextLine();
                    hash.insert(clave, valor);
                    break;
                case 2:
                    System.out.print("Ingrese clave a buscar: ");
                    int claveBuscar = sc.nextInt();
                    Element<String> encontrado = hash.search(claveBuscar);
                    if (encontrado != null) {
                        System.out.println("Encontrado: " + encontrado);
                    } else {
                        System.out.println("No encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese clave a eliminar: ");
                    int claveEliminar = sc.nextInt();
                    hash.delete(claveEliminar);
                    break;
                case 4:
                    hash.showTable();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
