package type;

import java.util.function.Function;

public final class Right<T, U> extends Either<T, U>{
    private U value;


    public Right(U value) { this.value = value; }

    @Override
    public <V> Either<T, V> fmap(Function<U, V> func) {
        return f.is(this, func);
    }

    @Override
    public <V> Either<T, V> bind(Function<U, Either<T, V>> func) {
        return m.is(this, func);
    }

    @Override
    public String get() { return value.toString(); }

    public U unbox() { return value; }

    @Override
    public String toString() { return "Right " + value.toString(); }
}
