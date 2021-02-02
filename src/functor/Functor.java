package functor;

import type.Either;
import type.Left;
import type.Right;

import java.util.function.Function;

public class Functor<T> implements Either.AsFunctor<T> {
    @Override
    public <U, V> Either<T, V> is(Left<T, U> left, Function<U, V> f) {
        return (Left<T, V>) left;
    }

    @Override
    public <U, V> Either<T, V> is(Right<T, U> right, Function<U, V> f) {
        return new Right<T, V>(f.apply(right.unbox()));
    }
}
