package data;

import typeclass.Functor;
import typeclass.Monad;

import java.util.function.Function;

public abstract class Either<T, U> implements Monad<Either<T, ?>, U> {
    @Override
    public abstract <V> Either<T, V> fmap(Function<U, V> f);

    @Override
    public abstract <V> Either<T, V> bind(Function<U, ? extends Monad<Either<T, ?>, V>> f);

    public abstract boolean isLeft();
    public abstract Left<T, U> projectLeft();
    public abstract boolean isRight();
    public abstract Right<T, U> projectRight();

    public abstract String read();
}
