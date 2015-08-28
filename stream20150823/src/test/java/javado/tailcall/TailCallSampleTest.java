package javado.tailcall;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TailCallSampleTest {

  @Test
  public void test1() {
    int n = TailCallSample.returning(2, 4).invoke();
    assertThat(n, is(4));
  }

  @Test
  public void test2() {
    int n = TailCallSample.returning(4, 2).invoke();
    assertThat(n, is(4));
  }

}
