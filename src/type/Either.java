package type;

import functor.Functor;
import monad.Monad;

import java.util.function.Function;

public abstract class Either<T, U> {
    protected Functor<T> f = new Functor<>();
    protected Monad<T> m = new Monad<>();

    public abstract <V> Either<T, V> fmap(Function<U, V> func);
    public abstract <V> Either<T, V> bind(Function<U, Either<T, V>> func);

    public interface AsFunctor<T> {
        <U, V> Either<T, V> is(Left<T, U> left, Function<U, V> f);
        <U, V> Either<T, V> is(Right<T, U> right, Function<U, V> f);
    }

    public interface AsMonad<T> {
        <U, V> Either<T, V> is(Left<T, U> left, Function<U, Either<T, V>> f);
        <U, V> Either<T, V> is(Right<T, U> right, Function<U, Either<T, V>> f);
    }
    public abstract String get();
}
