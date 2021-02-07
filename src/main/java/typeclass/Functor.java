package typeclass;

import java.util.function.Function;

public interface Functor<F extends Functor<F, ?>, U> {
    <V> Functor<F, V> fmap(Function<? super U, ? extends V> f);
}
