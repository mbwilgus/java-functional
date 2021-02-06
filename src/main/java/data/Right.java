package data;

import typeclass.Functor;
import typeclass.Gettable;
import typeclass.Monad;

import java.util.function.Function;

public final class Right<T, U> extends Either<T, U> implements Gettable<U> {
    private final U value;

    public Right(U value) { this.value = value; }

    @Override
    public String read() {
        return value.toString();
    }

    @Override
    public String toString() {
        return "R " +  read();
    }

    @Override
    public <V> Either<T, V> fmap(Function<U, V> f) {
        return new Right<>(f.apply(value));
    }

    @Override
    public <V> Either<T, V> bind(Function<U, ? extends Monad<Either<T, ?>, V>> f) {
        return (Either<T, V>) f.apply(value);
    }

    @Override
    public boolean isLeft() {
        return false;
    }

    @Override
    public Left<T, U> projectLeft() {
        return null;
    }

    @Override
    public boolean isRight() {
        return true;
    }

    @Override
    public Right<T, U> projectRight() {
        return this;
    }

    @Override
    public U get() {
        return value;
    }
}
