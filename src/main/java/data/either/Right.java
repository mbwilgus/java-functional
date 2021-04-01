package data.either;

import typeclass.Applicative;
import typeclass.Monad;

import java.util.function.Function;

public final class Right<T, U> extends Either<T, U> {
    private final U value;

    public Right(U value) {
        this.value = value;
    }

    @Override
    public <V> Either<T, V> fmap(Function<? super U, ? extends V> f) {
        return new Right<>(f.apply(value));
    }

    @Override
    public <V> Either<T, V> apply(Applicative<Either<T, ?>, Function<? super U, ? extends V>> f) {
        Either<T, Function<? super U, ? extends V>> af = (Either<T, Function<? super U, ? extends V>>) f;
        if (af.isLeft()) return new Left<>(af.projectLeft());
        return this.fmap(af.projectRight());
    }

    @Override
    public <V> Either<T, V> bind(Function<? super U, ? extends Monad<Either<T, ?>, ? extends V>> f) {
        @SuppressWarnings("unchecked")
        Either<T, V> r = (Either<T, V>) f.apply(value);
        return r;
    }

    @Override
    public boolean isLeft() {
        return false;
    }

    @Override
    public T projectLeft() {
        return null;
    }

    @Override
    public boolean isRight() {
        return true;
    }

    @Override
    public U projectRight() {
        return value;
    }

    @Override
    public String read() {
        return value.toString();
    }

    @Override
    public String toString() {
        return "Right " + read();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Right<?, ?>) {
            return ((Right<?, ?>) other).value.equals(value);
        }

        return false;
    }
}
