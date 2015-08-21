package javado.tailcall;

import java.util.stream.Stream;

/**
 * @see Javaによる関数型プログラミング 7章 再帰の最適化
 */
@FunctionalInterface
public interface TailCall<T> {

  public TailCall<T> apply();

  public default boolean isComplete() {
    return false;
  }

  public default T result() {
    throw new Error("Not implemented!");
  }

  public default T invoke() {
    return Stream.iterate(this, TailCall::apply)
        .filter(TailCall::isComplete)
        .findFirst()
        .get()
        .result();
  }

}
