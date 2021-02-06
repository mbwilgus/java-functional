package typeclass;

import java.util.function.Function;

public interface Functor<F extends Functor<F, ?>, U> {
    <V> F fmap(Function<U, V> f);
}
