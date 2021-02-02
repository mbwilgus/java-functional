package type;

import java.util.function.Function;

public final class Left<T, U> extends Either<T, U> {
    private T value;

    public Left(T value) { this.value = value; }

    @Override
    public <V> Either<T, V> fmap(Function<U, V> func) {
        return (Left<T, V>) this;
    }

    @Override
    public <V> Either<T, V> bind(Function<U, Either<T, V>> func) {
        return (Left<T, V>) this;
    }

    @Override
    public boolean isLeft() {
        return true;
    }

    @Override
    public boolean isRight() {
        return false;
    }

    @Override
    public String read() { return value.toString(); }

    public T get() { return value; }

    @Override
    public String toString() { return "Left " + value.toString(); }
}
