import type.Either;
import type.Left;
import type.Right;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Either<String, Integer> e1 = new Left<>("Error");
        Either<String, Integer> e2 = new Right<>(6);
        Function<Integer, String> q = (Integer i) -> ((Integer)(i*i)).toString();
        Function<Integer, String> f = (Integer i) -> ((Integer)(i*i)).toString() + " fmapable";
        Function<Integer, Either<String, String>> g = (Integer i) -> new Right<>(((Integer)(i*i)).toString() + " bindable");
        System.out.println(e1.fmap(f).get());
        System.out.println(e2.fmap(f).get());
        System.out.println(e1.bind(g).get());
        System.out.println(e2.bind(g).get());
        System.out.println(e2.fmap((Integer i) -> i.toString() + "lowercase").bind((String s) -> new Right<>(s.toUpperCase())).get());
    }
}
