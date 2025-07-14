public class Element<T> {
    private int key;
    private T value;
    private boolean deleted;

    public Element(int key, T value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }

    public int getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void delete() {
        this.deleted = true;
    }

    @Override
    public String toString() {
        return (deleted ? "[ELIMINADO] " : "") + key + ": " + value;
    }
}
