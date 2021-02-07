package data;

import typeclass.Applicative;
import typeclass.Gettable;
import typeclass.Monad;

import java.util.function.Function;

public final class Left<T, U> extends Either<T, U> implements Gettable<T> {
    private final T value;

    public Left(T value) { this.value = value; }

    @Override
    public String read() {
        return value.toString();
    }

    @Override
    public String toString() {
        return "Left " + read();
    }

    @Override
    public <V> Either<T, V> fmap(Function<? super U, ? extends V> f) {
        return new Left<>(value);
    }

    @Override
    public <V> Either<T, V> amap(Applicative<Either<T, ?>, Function<? super U, ? extends V>> f) {
        Either<T, Function<? super U, ? extends V>> af = (Either<T, Function<? super U,? extends V>>) f;
        if (af.isLeft()) return new Left<>(af.projectLeft().get());
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
    public Left<T, U> projectLeft() {
        return this;
    }

    @Override
    public boolean isRight() {
        return false;
    }

    @Override
    public Right<T, U> projectRight() {
        return null;
    }

    @Override
    public T get() {
        return value;
    }
}
