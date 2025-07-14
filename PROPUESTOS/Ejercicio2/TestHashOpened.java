public class TestHashOpened {
    public static void main(String[] args) {
        // Crear tabla hash abierta con capacidad 8
        HashOpened<String> hashTable = new HashOpened<>(8);

        // Insertar elementos
        hashTable.insert(new Register<>(5, "Pepe"));
        hashTable.insert(new Register<>(21, "Jesus"));  // Colision con 5 (21 % 8 = 5)
        hashTable.insert(new Register<>(19, "Juan"));   // 19 % 8 = 3
        hashTable.insert(new Register<>(16, "Maria"));  // 16 % 8 = 0
        hashTable.insert(new Register<>(21, "DUPLICADO")); // Debe ser ignorado

        // Mostrar tabla hash
        hashTable.showTable();

        // Buscar claves
        System.out.println("\nBuscar clave 5: " + hashTable.search(5));
        System.out.println("Buscar clave 21: " + hashTable.search(21));

        // Eliminar claves
        hashTable.delete(21);  // Eliminacion logica
        hashTable.delete(100); // No existe

        // Mostrar tabla despues de eliminar
        hashTable.showTable();
    }
}
