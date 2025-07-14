public class Element<T> {
    private Register<T> register;
    private State state;

    public enum State {
        EMPTY,
        OCCUPIED,
        DELETED
    }

    public Element() {
        this.state = State.EMPTY;
    }

    public Register<T> getRegister() {
        return register;
    }

    public void setRegister(Register<T> register) {
        this.register = register;
        this.state = State.OCCUPIED;
    }

    public State getState() {
        return state;
    }

    public void delete() {
        this.register = null;
        this.state = State.DELETED;
    }

    public void clear() {
        this.register = null;
        this.state = State.EMPTY;
    }
}
