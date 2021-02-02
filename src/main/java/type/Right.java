package type;

import java.util.function.Function;

public final class Right<T, U> extends Either<T, U>{
    private U value;


    public Right(U value) { this.value = value; }

    @Override
    public <V> Either<T, V> fmap(Function<U, V> func) {
        return new Right<>(func.apply(value));
    }

    @Override
    public <V> Either<T, V> bind(Function<U, Either<T, V>> func) {
        return func.apply(value);
    }

    @Override
    public boolean isLeft() {
        return false;
    }

    @Override
    public boolean isRight() {
        return true;
    }

    @Override
    public String read() { return value.toString(); }

    public U get() { return value; }

    @Override
    public String toString() { return "Right " + value.toString(); }
}
