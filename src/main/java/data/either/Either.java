package data.either;

import typeclass.Applicative;
import typeclass.Monad;

import java.util.function.Function;

public abstract class Either<T, U> implements Monad<Either<T, ?>, U> {
    public static <T, U> Right<T, U> pure(U value) {
        return new Right<>(value);
    }

    public static <T, U> Right<T, U> unit(U value) {
        return pure(value);
    }

    @Override
    public abstract <V> Either<T, V> fmap(Function<? super U, ? extends V> f);

    @Override
    public abstract <V> Either<T, V> apply(Applicative<Either<T, ?>, Function<? super U, ? extends V>> f);

    @Override
    public abstract <V> Either<T, V> bind(Function<? super U, ? extends Monad<Either<T, ?>, ? extends V>> f);

    public abstract boolean isLeft();
    public abstract T projectLeft();
    public abstract boolean isRight();
    public abstract U projectRight();

    public abstract String read();
}
