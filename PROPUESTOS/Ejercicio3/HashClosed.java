public class HashClosed<T> {
    private Element<T>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashClosed(int capacity) {
        table = new Element[capacity];
        size = 0;
    }

    private int hash(int key) {
        return key % table.length;
    }

    public void insert(int key, T value) {
        int index = hash(key);
        int startIndex = index;
        while (table[index] != null && !table[index].isDeleted()) {
            if (table[index].getKey() == key) {
                System.out.println("Clave duplicada: " + key);
                return;
            }
            index = (index + 1) % table.length;
            if (index == startIndex) {
                System.out.println("La tabla esta llena.");
                return;
            }
        }
        table[index] = new Element<>(key, value);
        size++;
        System.out.println("Insertado: " + key + " -> " + value + " (indice " + index + ")");
    }

    public Element<T> search(int key) {
        int index = hash(key);
        int startIndex = index;
        while (table[index] != null) {
            if (!table[index].isDeleted() && table[index].getKey() == key) {
                return table[index];
            }
            index = (index + 1) % table.length;
            if (index == startIndex) break;
        }
        return null;
    }

    public void delete(int key) {
        int index = hash(key);
        int startIndex = index;
        while (table[index] != null) {
            if (!table[index].isDeleted() && table[index].getKey() == key) {
                table[index].delete();
                size--;
                System.out.println("Eliminado logicamente: " + key);
                return;
            }
            index = (index + 1) % table.length;
            if (index == startIndex) break;
        }
        System.out.println("Clave no encontrada: " + key);
    }

    public void showTable() {
        System.out.println("\n--- Estado de la Tabla Hash (Cerrado) ---");
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + ": ");
            if (table[i] == null) {
                System.out.println("[VACIO]");
            } else {
                System.out.println(table[i]);
            }
        }
    }
}
