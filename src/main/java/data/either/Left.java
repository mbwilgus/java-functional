package data.either;

import typeclass.Applicative;
import typeclass.Monad;

import java.util.function.Function;

public final class Left<T, U> extends Either<T, U> {
    private final T value;

    public Left(T value) {
        this.value = value;
    }

    @Override
    public <V> Either<T, V> fmap(Function<? super U, ? extends V> f) {
        return new Left<>(value);
    }

    @Override
    public <V> Either<T, V> apply(Applicative<Either<T, ?>, Function<? super U, ? extends V>> f) {
        Either<T, Function<? super U, ? extends V>> af = (Either<T, Function<? super U, ? extends V>>) f;
        if (af.isLeft()) return new Left<>(af.projectLeft());
        return new Left<>(value);
    }

    @Override
    public <V> Either<T, V> bind(Function<? super U, ? extends Monad<Either<T, ?>, ? extends V>> f) {
        return new Left<>(value);
    }

    @Override
    public boolean isLeft() {
        return true;
    }

    @Override
    public T projectLeft() {
        return value;
    }

    @Override
    public boolean isRight() {
        return false;
    }

    @Override
    public U projectRight() {
        return null;
    }

    @Override
    public String read() {
        return value.toString();
    }

    @Override
    public String toString() {
        return "Left " + read();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Left<?, ?>) {
            return ((Left<?, ?>) other).value.equals(value);
        }

        return false;
    }
}
