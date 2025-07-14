public class TestHashOpened {
    public static void main(String[] args) {
        // Crear tabla hash con tamaño 8
        HashOpened<String> hashTable = new HashOpened<>(8);

        // Insertar elementos
        hashTable.insert(new Register<>(5, "Pepe"));
        hashTable.insert(new Register<>(21, "Jesus"));
        hashTable.insert(new Register<>(19, "Juan"));
        hashTable.insert(new Register<>(16, "Maria"));
        hashTable.insert(new Register<>(21, "DUPLICADO")); // Debe dar error por clave duplicada

        // Mostrar tabla después de inserciones
        hashTable.showTable();

        // Buscar elementos por clave
        Register<String> result1 = hashTable.search(5);
        System.out.println("\nResultado busqueda clave 5: " + (result1 != null ? result1 : "No encontrado"));

        Register<String> result2 = hashTable.search(21);
        System.out.println("Resultado busqueda clave 21: " + (result2 != null ? result2 : "No encontrado"));

        // Eliminar elementos por clave
        hashTable.delete(21);   // Eliminación lógica
        hashTable.delete(100);  // Clave no existe

        // Mostrar tabla después de eliminaciones
        hashTable.showTable();
    }
}
