package org.james.guava.c9;

import com.google.common.base.Charsets;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class IODemo {

  public static void main(String... args) throws IOException {
    System.out.println(new IODemo().operateFile());
  }

  private List<String> operateFile() throws IOException {
    CharSource charSource = Files
        .asCharSource(new File(System.getProperty("user.dir") + "/src/main/resources/test.txt"),
            Charsets.UTF_8);
    charSource.copyTo(Files
        .asCharSink(new File(System.getProperty("user.dir") + "/src/main/resources/target.txt"),
            Charsets.UTF_8));
    return charSource.readLines();
  }


}
