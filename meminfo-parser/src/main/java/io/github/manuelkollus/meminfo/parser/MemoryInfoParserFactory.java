package io.github.manuelkollus.meminfo.parser;

import io.github.manuelkollus.meminfo.unit.MemoryInfoFileField;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * The {@link MemoryInfoParserFactory} iterate all lines from the target memory
 * info file to build the {@link MemoryInfoFileField}.
 *
 * @author Manuel Kollus
 * @version 1.0
 * @see MemoryInfoFileField
 */
public final class MemoryInfoParserFactory {

  private static final Path PATH = Paths.get("proc/meminfo");

  private Path path;
  private MemoryInfoParser memoryInfoParser;

  private MemoryInfoParserFactory(Path path) {
    this.path = path;
    this.memoryInfoParser = new MemoryInfoParser();
  }

  public List<MemoryInfoFileField> getFieldsFromFile() throws IOException {
    Objects.requireNonNull(path, "path cannot be null!");

    return Files.readAllLines(path)
      .stream()
      .map(validateString())
      .collect(Collectors.toList());
  }

  private Function<String, MemoryInfoFileField> validateString() {
    return line -> line.contains("kB") ? memoryInfoParser.parseWithUnit(line) :
      memoryInfoParser.parseWithoutUnit(line);
  }

  public static MemoryInfoParserFactory create() {
    return new MemoryInfoParserFactory(PATH);
  }

  public static MemoryInfoParserFactory create(Path path) {
    Objects.requireNonNull(path, "path cannot be null!");

    return new MemoryInfoParserFactory(path);
  }
}
