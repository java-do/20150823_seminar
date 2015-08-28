package javado;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HandsOn {

  private Service service;

  public static void main(String[] args) {
    HandsOn app = new HandsOn();
    app.practice();
    // app.example0();
    // app.example1();
    // app.example2();
    // app.example3();
    // app.example4();
    // app.example5();
    // app.example6();
    // app.example7();
    // app.example8();
    // app.example9();
    // app.example10();
    // app.example11();
    // app.example12();
  }

  public HandsOn() {
    service = new Service();
  }

  public void view(Object object) {
    System.out.println(object.toString());
  }

  // 練習1:まずは写経
  public void practice() {
    System.out.println("------------ practice ----------");
    int[] ages = new int[] { 22, 10, 19, 38 };
    // ヒント：教科書10ページ目の例に沿って、20以上をfilterしてforEachで表示しましょう
  }

  // 練習2用
  public void example0() {
    System.out.println("------------ example0 ----------");
    List<Profile> choiced = service.fetchProfiles();
    view(choiced);
  }

  // 練習2: forEachを使ってリストの内容を表示する
  public void view(List<?> list) {
    // ヒント：引数をstreamに変換し、forEachで表示しましょう
  }

  // 演習1: 女性(sex==1)の人を抜き出す
  public void example1() {
    System.out.println("------------ example1 ----------");
    List<Profile> profiles = service.fetchProfiles();
    // ヒント：filter中間操作を使い、profile.getSex() が 1 であるprofileのstreamにしましょう
    // Streamの要素をListに集めて返す終端操作は collect(Collectors.toList()) です
    List<Profile> choiced = profiles.stream()
        .collect(Collectors.toList());
    view(choiced);
  }

  // 演習2: 女性(sex==1)で、二十歳以上の人を抜き出す
  public void example2() {
    System.out.println("------------ example2 ----------");
    List<Profile> profiles = service.fetchProfiles();
    // ヒント：filterを使い、条件に当てはまるprofileのstreamにしましょう
    // 終端操作も作ってみましょう
    List<Profile> choiced = null;
    view(choiced);
  }

  // 演習3: 女性(sex==1)で、二十歳以上の人の名前だけを抜き出す
  public void example3() {
    System.out.println("------------ example3 ----------");
    List<Profile> profiles = service.fetchProfiles();
    // ヒント：返値がStringのリストであることに注意
    // streamの要素を置き換える中間操作は map（ラムダ式）です
    List<String> choiced = null;
    view(choiced);
  }

  // 演習4: 演習2の内容を、年齢順に昇順ソートする
  public void example4() {
    System.out.println("------------ example4 ----------");
    List<Profile> profiles = service.fetchProfiles();
    // ヒント：ソートには、sortedを使います
    // ヒント：sortedの引数はコンパレータで、昇順のコンパレータは(Comparator.comparing(ラムダ式)) です
    List<Profile> choiced = null;
    view(choiced);
  }

  // 演習5: 男性(sex==0)で、未成年人を抜き出し、年齢順に昇順ソートする
  public void example5() {
    System.out.println("------------ example5 ----------");
    List<Profile> profiles = service.fetchProfiles();
    // ノーヒントでチャレンジしてみましょう
    List<Profile> choiced = null;
    view(choiced);
  }

  // 演習6: 演習5を降順ソートにする
  public void example6() {
    System.out.println("------------ example6 ----------");
    List<Profile> profiles = service.fetchProfiles();
    // ヒント：降順ソートのコンパレータはComparator.comparing(ラムダ式).reversed() です
    List<Profile> choiced = null;
    view(choiced);
  }

  // 演習7: カレーの食べ方"せき止め派"のうち、最初の一人を取り出す
  public void example7() {
    System.out.println("------------ example7 ----------");
    List<Profile> profiles = service.fetchProfiles();
    // ヒント：返値が Profile であることに注意
    // filterの条件にString#matches(正規表現)を使います
    // 正規表現は ".*せき止め派.*" です
    // 最初の一つを取り出す終端操作は findFirst().get() です
    Profile choiced = null;
    view(choiced);
  }

  // 演習8: 演習7をパラレル処理にする
  public void example8() {
    System.out.println("------------ example8 ----------");
    List<Profile> profiles = service.fetchProfiles();
    Profile choiced = null;
    // ヒント：返値が Profile であることに注意
    // stream に parallel() を実行すると並列処理になります
    // 最初に見つかったどれか１つを取り出す終端操作は findAny().get() です
    view(choiced);
  }

  // 演習9: カレーの食べ方"せき止め派"の人数を出す
  public void example9() {
    System.out.println("------------ example9 ----------");
    List<Profile> profiles = service.fetchProfiles();
    // ヒント：返値がLongであることに注意
    // streamの要素数を取り出す終端処理は count() です
    Long choiced = null;
    view(choiced);
  }

  // 演習10: 都道府県をキーにして、グルーピングする
  public void example10() {
    System.out.println("------------ example10 ----------");
    List<Profile> profiles = service.fetchProfiles();
    // ヒント：返値がMap<String, List>であることに注意
    // streamをmapにグルーピングする終端操作は
    // collect(Collectors.groupingBy(キーを決めるラムダ式))
    // です
    Map<String, List<Profile>> choiced = null;
    view(choiced);
  }

  // 演習11: 都道府県をキーにして、名前だけをグルーピングする
  // 長いので、Collectors.*をstatic importすると楽
  public void example11() {
    System.out.println("------------ example11 ----------");
    List<Profile> profiles = service.fetchProfiles();
    // ヒント：返値がMap<String, List>であることに注意
    // streamをmapにグルーピングする終端操作は
    // collect(Collectors.groupingBy(キーを決めるラムダ式, Collectors.mapping(値を決めるラムダ式,
    // Collectors.toList())))
    // です
    Map<String, List<String>> choiced = null;
    view(choiced);
  }

  // 演習12: リストに存在するカレーの食べ方の要素を全てリストアップする
  public void example12() {
    System.out.println("------------ example12 ----------");
    List<Profile> profiles = service.fetchProfiles();
    // ヒント：Streamの要素を、カレーの食べ方を"・"で切り分けたString配列で置き換えます
    // このstream要素を、string配列から作った複数のstreamに置き換えます...flatMap(ラムダ式）
    // stream要素から重複を取り除く中間操作は distinct() です
    List<Profile> choiced = null;
    view(choiced);
  }

}
