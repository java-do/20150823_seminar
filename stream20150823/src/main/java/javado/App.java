package javado;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {

  private Service service;

  public static void main(String[] args) {
    App app = new App();
    app.example0();
    app.example1();
    app.example2();
    app.example3();
    app.example4();
    app.example5();
    app.example6();
    app.example7();
    app.example8();
    app.example9();
    app.example10();
  }

  public App() {
    service = new Service();
  }

  public void view(Object object) {
    System.out.println(object.toString());
  }

  // 練習: forEachを使ってリストの内容を表示する
  public void view(List<?> list) {
    list.stream()
        .forEach(System.out::println);
  }

  public void example0() {
    System.out.println("------------ example0 ----------");
    List<Profile> profiles = service.fetchProfiles();
    view(profiles);
  }

  // 演習1: 女性(sex==1)の人を抜き出す
  public void example1() {
    System.out.println("------------ example1 ----------");
    List<Profile> profiles = service.fetchProfiles();
    List<Profile> choiced = profiles.stream()
        .filter(p -> p.getSex() == 1)
        .collect(Collectors.toList());
    view(choiced);
  }

  // 演習2: 女性(sex==1)で、二十歳以上の人を抜き出す
  public void example2() {
    System.out.println("------------ example2 ----------");
    List<Profile> profiles = service.fetchProfiles();
    List<Profile> choiced = profiles.stream()
        .filter(p -> p.getSex() == 1)
        .filter(p -> p.getAge() >= 20)
        .collect(Collectors.toList());
    view(choiced);
  }

  // 演習3: 女性(sex==1)で、二十歳以上の人の名前を抜き出す
  public void example3() {
    System.out.println("------------ example3 ----------");
    List<Profile> profiles = service.fetchProfiles();
    List<String> mapped = profiles.stream()
        .filter(p -> p.getSex() == 1)
        .filter(p -> p.getAge() >= 20)
        .map(p -> p.getName())
        .collect(Collectors.toList());
    view(mapped);
  }

  // 演習4: 女性(sex==1)で、二十歳以上を抜き出し、年齢順にソートする
  public void example4() {
    System.out.println("------------ example4 ----------");
    List<Profile> profiles = service.fetchProfiles();
    List<Profile> choiced = profiles.stream()
        .filter(Profile::isFamale)
        .filter(Profile::isAdult)
        .sorted(Comparator.comparing(Profile::getAge))
        .collect(Collectors.toList());
    view(choiced);
  }

  // 演習5: 男性(sex==0)で、未成年人を抜き出し、年齢順にソートする
  public void example5() {
    System.out.println("------------ example5 ----------");
    List<Profile> profiles = service.fetchProfiles();
    List<Profile> choiced = profiles.stream()
        .filter(Profile::isMale)
        .filter(Profile::isUnderage)
        .sorted(Comparator.comparing(Profile::getAge).reversed())
        .collect(Collectors.toList());
    view(choiced);
  }

  // 演習6: 男性(sex==0)で、未成年人を抜き出し、年齢順にソートする
  public void example6() {
    System.out.println("------------ example6 ----------");
    List<Profile> profiles = service.fetchProfiles();
    List<Profile> choiced = profiles.stream()
        .filter(Profile::isMale)
        .filter(Profile::isUnderage)
        .sorted(Comparator.comparing(Profile::getAge).reversed())
        .collect(Collectors.toList());
    view(choiced);
  }

  // 演習7: カレーの食べ方"せき止め派"のうち、最初の一人を取り出す
  public void example7() {
    System.out.println("------------ example7 ----------");
    List<Profile> profiles = service.fetchProfiles();
    Profile choiced = profiles.stream()
        .parallel()
        .filter(p -> p.getPolicy().matches(".*せき止め派.*"))
        .findFirst().get();
    view(choiced);
  }

  // 演習8: カレーの食べ方"せき止め派"の人数を出す
  public void example8() {
    System.out.println("------------ example8 ----------");
    List<Profile> profiles = service.fetchProfiles();
    Profile choiced = profiles.stream()
        .parallel()
        .filter(p -> p.getPolicy().matches(".*せき止め派.*"))
        .findAny().get();
    view(choiced);
  }

  // 演習9: カレーの食べ方"せき止め派"の人数を出す
  public void example9() {
    System.out.println("------------ example9 ----------");
    List<Profile> profiles = service.fetchProfiles();
    Long choiced = profiles.stream()
        .filter(p -> p.getPolicy().matches(".*せき止め派.*"))
        .count();
    view(choiced);
  }

  // 演習10: flatMapで九九の計算
  public void example10() {
    System.out.println("------------ example10 ----------");
    IntStream.rangeClosed(1, 9)
        .flatMap(i -> IntStream.rangeClosed(1, 9)
            .map(j -> i * j))
        .forEach(System.out::println);
    ;
  }
}
