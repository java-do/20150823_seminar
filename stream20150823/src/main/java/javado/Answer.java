package javado;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Answer {

  private Service service;

  public static void main(String[] args) {
    Answer app = new Answer();
    app.practice();
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
    app.example11();
    app.example12();
  }

  public Answer() {
    service = new Service();
  }

  public void view(Object object) {
    System.out.println(object.toString());
  }

  // 練習1:まずは写経
  public void practice() {
    System.out.println("------------ practice ----------");
    int[] ages = new int[] { 22, 10, 19, 38 };
    Arrays.stream(ages)
        .filter(n -> n >= 20)
        .forEach(n -> System.out.println(n));
  }

  // 練習2用
  public void example0() {
    System.out.println("------------ example0 ----------");
    List<Profile> choiced = service.fetchProfiles();
    view(choiced);
  }

  // 練習2: forEachを使ってリストの内容を表示する
  public void view(List<?> list) {
    list.stream()
        .forEach(i -> System.out.println(i));
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

  // 演習3: 女性(sex==1)で、二十歳以上の人の名前だけを抜き出す
  public void example3() {
    System.out.println("------------ example3 ----------");
    List<Profile> profiles = service.fetchProfiles();
    List<String> choiced = profiles.stream()
        .filter(p -> p.isFamale())
        .filter(p -> p.isAdult())
        .map(p -> p.getName())
        .collect(Collectors.toList());
    view(choiced);
  }

  // 演習4: 演習2の内容を、年齢順に昇順ソートする
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

  // 演習5: 男性(sex==0)で、未成年人を抜き出し、年齢順に昇順ソートする
  public void example5() {
    System.out.println("------------ example5 ----------");
    List<Profile> profiles = service.fetchProfiles();
    List<Profile> choiced = profiles.stream()
        .filter(Profile::isMale)
        .filter(Profile::isUnderage)
        .sorted(Comparator.comparing(Profile::getAge))
        .collect(Collectors.toList());
    view(choiced);
  }

  // 演習6: 演習5を降順ソートにする
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
        .filter(p -> p.getPolicy().matches(".*せき止め派.*"))
        .findFirst().get();
    view(choiced);
  }

  // 演習8: 演習7をパラレル処理にする
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

  // 演習10: 都道府県をキーにして、グルーピングする
  public void example10() {
    System.out.println("------------ example10 ----------");
    List<Profile> profiles = service.fetchProfiles();
    Map<String, List<Profile>> choiced = profiles.stream()
        .collect(Collectors.groupingBy(Profile::getState));
    view(choiced);
  }

  // 演習11: 都道府県をキーにして、名前だけをグルーピングする
  // 長いので、Collectors.*をstatic importすると楽
  public void example11() {
    System.out.println("------------ example11 ----------");
    List<Profile> profiles = service.fetchProfiles();
    Map<String, List<String>> choiced = profiles.stream()
        .collect(Collectors.groupingBy(Profile::getState, Collectors.mapping(Profile::getName, Collectors.toList())));
    view(choiced);
  }

  // 演習12: リストに存在するカレーの食べ方の要素を全てリストアップする
  public void example12() {
    System.out.println("------------ example12 ----------");
    List<Profile> profiles = service.fetchProfiles();
    List<String> choiced = profiles.stream()
        .map(Profile::getPolicy)
        .map(s -> s.split("・"))
        // 上の2行は .map(p -> p.getPolicy().split("・")) にまとめてもよい
        .flatMap(strs -> Arrays.stream(strs))
        .distinct()
        .collect(Collectors.toList());
    view(choiced);
  }

}
