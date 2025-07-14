import java.util.Scanner;

public class TestHashOpened {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashOpened<String> hashTable = new HashOpened<>(8);
        int opcion;

        do {
            System.out.println("\n--- MENU HASH ABIERTO ---");
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
                    sc.nextLine(); // limpiar buffer
                    System.out.print("Ingrese valor (String): ");
                    String valor = sc.nextLine();
                    hashTable.insert(new Register<>(clave, valor));
                    break;
                case 2:
                    System.out.print("Ingrese clave a buscar: ");
                    int buscar = sc.nextInt();
                    Register<String> encontrado = hashTable.search(buscar);
                    if (encontrado != null) {
                        System.out.println("Encontrado: " + encontrado);
                    } else {
                        System.out.println("No encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese clave a eliminar: ");
                    int eliminar = sc.nextInt();
                    hashTable.delete(eliminar);
                    break;
                case 4:
                    hashTable.showTable();
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
