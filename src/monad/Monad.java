package monad;

import type.Either;
import type.Left;
import type.Right;

import java.util.function.Function;

public class Monad<T> implements Either.AsMonad<T> {
    @Override
    public <U, V> Either<T, V> is(Left<T, U> left, Function<U, Either<T, V>> f) {
        return (Either<T, V>) left;
    }

    @Override
    public <U, V> Either<T, V> is(Right<T, U> right, Function<U, Either<T, V>> f) {
        return f.apply(right.unbox());
    }
}
