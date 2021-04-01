package typeclass;

import java.util.function.Function;

/**
 * An applicative functor is like a regular functor but it supports mapping a function encapsulated by a functor over a
 * value it encapsulates.
 *
 * @param <A> An implementation of the typeclass {@code Applicative} (i.e, {@code A} implements this interface)
 * @param <U> The data type that the applicative encapsulates and encapsulated functions can be mapped over
 */
public interface Applicative<A extends Applicative<A, ?>, U> extends Functor<A, U> {
    @Override
    <V> Applicative<A, V> fmap(Function<? super U, ? extends V> f);

    <V> Applicative<A, V> apply(Applicative<A, Function<? super U, ? extends V>> f);
}
