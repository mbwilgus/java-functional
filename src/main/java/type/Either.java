package type;

import java.util.function.Function;

public abstract class Either<T, U> {
    public abstract <V> Either<T, V> fmap(Function<U, V> func);
    public abstract <V> Either<T, V> bind(Function<U, Either<T, V>> func);

    public abstract boolean isLeft();
    public abstract boolean isRight();

    public abstract String read();
}
