package data;

import typeclass.Applicative;
import typeclass.Monad;

import java.util.function.Function;

public class Nothing<T> extends Maybe<T> {
    @Override
    public <V> Maybe<V> fmap(Function<? super T, ? extends V> f) {
        return new Nothing<>();
    }

    @Override
    public <V> Maybe<V> amap(Applicative<Maybe<?>, Function<? super T, ? extends V>> f) {
        return new Nothing<>();
    }

    @Override
    public <V> Maybe<V> bind(Function<? super T, ? extends Monad<Maybe<?>, ? extends V>> f) {
        return new Nothing<>();
    }

    @Override
    public boolean isNothing() {
        return true;
    }

    @Override
    public Nothing<T> projectNothing() {
        return this;
    }

    @Override
    public boolean isJust() {
        return false;
    }

    @Override
    public Just<T> projectJust() {
        return null;
    }

    @Override
    public String read() {
        return "Nothing";
    }
}
