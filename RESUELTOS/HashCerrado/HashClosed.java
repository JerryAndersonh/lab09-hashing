public class HashClosed<E> {
    private Element<E>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashClosed(int capacity) {
        size = capacity;
        table = new Element[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new Element<>();
        }
    }

    private int hash(int key, int i) {
        return (key + i) % size;
    }

    public void insert(int key, E value) {
        for (int i = 0; i < size; i++) {
            int pos = hash(key, i);
            Element<E> elem = table[pos];

            if (elem.getState() == Element.State.OCCUPIED && elem.getRegister().getKey() == key) {
                System.out.println("Error: Clave duplicada " + key);
                return;
            }

            if (elem.getState() != Element.State.OCCUPIED) {
                elem.setRegister(new Register<>(key, value));
                System.out.println("Insertado: " + key + " -> " + value);
                return;
            }
        }
        System.out.println("Error: Tabla llena. No se pudo insertar " + key);
    }

    public Register<E> search(int key) {
        for (int i = 0; i < size; i++) {
            int pos = hash(key, i);
            Element<E> elem = table[pos];

            if (elem.getState() == Element.State.EMPTY) {
                break;
            }

            if (elem.getState() == Element.State.OCCUPIED &&
                elem.getRegister().getKey() == key) {
                return elem.getRegister();
            }
        }
        return null;
    }

    public void delete(int key) {
        for (int i = 0; i < size; i++) {
            int pos = hash(key, i);
            Element<E> elem = table[pos];

            if (elem.getState() == Element.State.EMPTY) {
                break;
            }

            if (elem.getState() == Element.State.OCCUPIED &&
                elem.getRegister().getKey() == key) {
                elem.delete();
                System.out.println("Eliminado: " + key);
                return;
            }
        }
        System.out.println("No se encontro la clave: " + key);
    }

    public void showTable() {
        System.out.println("Tabla Hash:");
        for (int i = 0; i < size; i++) {
            Element<E> elem = table[i];
            System.out.print("[" + i + "] ");
            if (elem.getState() == Element.State.OCCUPIED) {
                System.out.println(elem.getRegister());
            } else if (elem.getState() == Element.State.DELETED) {
                System.out.println("<<ELIMINADO>>");
            } else {
                System.out.println("<<VACIO>>");
            }
        }
    }
}
