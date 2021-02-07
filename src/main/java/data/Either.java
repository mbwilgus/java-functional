package data;

import typeclass.Applicative;
import typeclass.Monad;

import java.util.function.Function;

public abstract class Either<T, U> implements Monad<Either<T, ?>, U> {
    @Override
    public abstract <V> Either<T, V> fmap(Function<? super U, ? extends V> f);

    @Override
    public abstract <V> Either<T, V> amap(Applicative<Either<T, ?>, Function<? super U, ? extends V>> f);

    @Override
    public abstract <V> Either<T, V> bind(Function<? super U, ? extends Monad<Either<T, ?>, ? extends V>> f);

    public abstract boolean isLeft();
    public abstract Left<T, U> projectLeft();
    public abstract boolean isRight();
    public abstract Right<T, U> projectRight();

    public abstract String read();
}
