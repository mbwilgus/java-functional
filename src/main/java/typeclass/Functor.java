package typeclass;

import java.util.function.Function;

/**
 * A functor is any data type that provides context to other data types and supports mapping functions over the
 * contextualized data in a way that preserves the structure of the functor. All functors must satisfy laws regarding
 * their operation. In particular, given a functor {@code f} that contextualizes data of type {@code U} and functions
 * {@code id}, {@code g} and {@code h}, where {@code id} is the identity function and {@code g}, {@code h} are arbitrary
 * functions, the following two properties must be satisfied
 *
 * <ol>
 * <li><pre>id f = f.fmap(id)                   (Identity Law)</pre></li>
 * <li><pre>f.fmap(h ∘ g) = f.fmap(g).fmap(h)   (Composition Law)</pre></li>
 * </ol>
 *
 * Note: if {@code f} contextualizes a value {@code u} of type {@code U} then {@code (h ∘ g)(u) = h(g(u))}
 *
 * @param <F> An implementation of the typeclass {@code Functor} (i.e., {@code F} implements this interface)
 * @param <U> The data type that the functor encapsulates and can map functions over
 */
public interface Functor<F extends Functor<F, ?>, U> {

    /**
     * Maps the function {@code f} over the data encapsulated by a functor.
     *
     * @param f   The function to map inside the functor. Since the functor contains {@code U} values, the
     *            domain of {@code f} must be a super type {@code U} (note that every type is a super type of itself)
     * @param <V> The output type of the function {@code f}
     * @return A new instance of functor type {@code F} encapsulating the result of mapping {@code f} to the value
     *         encapsulated in the calling functor
     */
    <V> Functor<F, V> fmap(Function<? super U, ? extends V> f);
}
