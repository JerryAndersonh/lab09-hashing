public class TestHashClosed {
    public static void main(String[] args) {
        HashClosed<String> hash = new HashClosed<>(11);

        int[] claves = {100, 5, 14, 15, 22, 16, 17, 32, 13, 32, 100};
        for (int clave : claves) {
            hash.insert(clave, "Valor" + clave);
        }

        System.out.println("\n--- Tabla después de insertar ---");
        hash.showTable();

        System.out.println("\n--- Busqueda ---");
        buscar(hash, 32);
        buscar(hash, 200);

        System.out.println("\n--- Eliminaciones ---");
        hash.delete(17);
        hash.delete(100);

        System.out.println("\n--- Tabla despues de eliminar ---");
        hash.showTable();
    }

    public static void buscar(HashClosed<String> hash, int clave) {
        Register<String> resultado = hash.search(clave);
        if (resultado != null) {
            System.out.println("Encontrado: " + resultado);
        } else {
            System.out.println("Clave " + clave + " no encontrada.");
        }
    }
}
