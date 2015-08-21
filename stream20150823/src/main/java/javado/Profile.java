package javado;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class Profile {

  private String name;
  private Integer sex; // 0:男性, 1:女性
  private Integer age;
  private String state;
  private String policy;

  public Profile(String[] line) {
    if (line == null) {
      throw new IllegalArgumentException("line is null");
    }
    if (line.length < 5) {
      throw new IllegalArgumentException("line lengths is under 5.");
    }
    name = line[0];
    sex = Integer.valueOf(line[1]);
    age = Integer.valueOf(line[2]);
    state = line[3];
    policy = line[4];
  }

  public String getName() {
    return name;
  }

  public Integer getSex() {
    return sex;
  }

  public Integer getAge() {
    return age;
  }

  public String getState() {
    return state;
  }

  public String getPolicy() {
    return policy;
  }

  public boolean isMale() {
    return sex == 0;
  }

  public boolean isFamale() {
    return sex == 1;
  }

  public boolean isAdult() {
    return age >= 20;
  }

  public boolean isUnderage() {
    return age < 20;
  }

  @Override
  public String toString() {
    StringJoiner joiner = new StringJoiner(",", "Profile{", "}");
    Stream.of(name, sex.toString(), age.toString(), state, policy)
        .forEach(joiner::add);
    return joiner.toString();
  }

}
