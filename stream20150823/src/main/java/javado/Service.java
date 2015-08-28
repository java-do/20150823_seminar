package javado;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Service {

  private final File file;

  public Service() {
    file = new File(getClass().getResource("/profile.txt").getFile());
  }

  // 例： テキストファイルを読み込み、1行目（ヘッダ）をスキップし、要素（2行目以降）をProfileオブジェクトに置き換えて、Listに集めて返す
  public List<Profile> fetchProfiles() {
    try (Stream<String> lines = Files.lines(file.toPath())) {
      return lines
          .skip(1L)
          .map(l -> new Profile(l.split(",")))
          .collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return Collections.emptyList();
  }

}
