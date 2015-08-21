package javado.tailcall;

public class TailCallSample {

  public static void main(String[] args) {
    int n = returning(0, 100).invoke();
    System.out.println(n);
  }

  // n が max になるまでreturningを再起する
  public static TailCall<Integer> returning(int i, int max) {
    return i < max
        ? TailCalls.call(() -> returning(i + 1, max))
        : TailCalls.done(i);
  }

}
