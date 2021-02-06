package typeclass;

import java.util.function.Function;

public interface Monad<M extends Monad<M, ?>, U> extends Functor<M, U> {
    <V> M bind(Function<U, ? extends Monad<M, V>> f);
}
