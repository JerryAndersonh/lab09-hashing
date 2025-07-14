public class TestHashClosed {
    public static void main(String[] args) {
        HashClosed<String> hash = new HashClosed<>(8);

        // Inserciones
        hash.insert(5, "Pepe");
        hash.insert(21, "Jesús");
        hash.insert(19, "Juan");
        hash.insert(16, "María");
        hash.insert(21, "DUPLICADO");

        // Mostrar
        hash.showTable();

        // Búsqueda
        System.out.println("\nBúsqueda clave 5: " + hash.search(5));
        System.out.println("Búsqueda clave 21: " + hash.search(21));

        // Eliminación
        hash.delete(21);
        hash.delete(100);

        // Mostrar tabla actualizada
        hash.showTable();
    }
}
