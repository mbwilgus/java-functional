package typeclass;

import java.util.function.Function;

public interface Monad<M extends Monad<M, ?>, U> extends Applicative<M, U> {
    @Override
    <V> Monad<M, V> fmap(Function<? super U, ? extends V> f);

    @Override
    <V> Monad<M, V> apply(Applicative<M, Function<? super U, ? extends V>> f);

    <V> Monad<M, V> bind(Function<? super U, ? extends Monad<M, ? extends V>> f);
}
