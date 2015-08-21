package javado;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ServiceTest {

  @Test
  public void test() {
    List<Profile> profiles = new Service().fetchProfiles();
    assertThat(profiles.size(), is(10));
  }

}
