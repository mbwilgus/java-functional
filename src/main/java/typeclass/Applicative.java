package typeclass;

import data.Either;
import data.Right;

import java.util.function.Function;

public interface Applicative<A extends Applicative<A, ?>, U> extends Functor<A, U> {
    static <T, U> Either<T, U> pure(U value) {
        return new Right<>(value);
    }

    <V> Applicative<A, V> amap(Applicative<A, Function<U, V>> f);
}
