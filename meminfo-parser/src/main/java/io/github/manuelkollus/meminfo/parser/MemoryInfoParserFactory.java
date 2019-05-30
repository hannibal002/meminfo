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

  private final Path path;
  private final MemoryInfoParser memoryInfoParser;

  /**
   * Private constructor of the {@link MemoryInfoFileField} class.
   *
   * @param path memoryinfo file to build the {@link MemoryInfoFileField}
   */
  private MemoryInfoParserFactory(Path path) {
    this.path = path;
    this.memoryInfoParser = new MemoryInfoParser();
  }

  /**
   * Returns an list of {@link MemoryInfoFileField}. Their are iterate all lines
   * from the target memory info file to build the {@link MemoryInfoFileField}.
   *
   * @return an list of {@link MemoryInfoFileField}.
   */
  public List<MemoryInfoFileField> getFieldsFromFile() throws IOException {
    Objects.requireNonNull(path, "path cannot be null!");

    return Files.readAllLines(path)
      .stream()
      .map(parseLine())
      .collect(Collectors.toList());
  }

  /**
   * Return an parsed line to {@link MemoryInfoFileField}.
   *
   * @return an parsed line to {@link MemoryInfoFileField}.
   */
  private Function<String, MemoryInfoFileField> parseLine() {
    return line -> line.contains("kB") ? memoryInfoParser.parseWithUnit(line) :
      memoryInfoParser.parseWithoutUnit(line);
  }

  /**
   * Creates a new instance of the {@code MemoryInfoParserFactory} class.
   *
   * @return a new instance of the {@code MemoryInfoParserFactory} class.
   */
  public static MemoryInfoParserFactory create() {
    return new MemoryInfoParserFactory(PATH);
  }

  /**
   * Creates a new instance of the {@code MemoryInfoParserFactory} class.
   *
   * @param path memoryinfo file to build the {@link MemoryInfoFileField}
   * @return a new instance of the {@code MemoryInfoParserFactory} class.
   */
  public static MemoryInfoParserFactory create(Path path) {
    Objects.requireNonNull(path, "path cannot be null!");

    return new MemoryInfoParserFactory(path);
  }
}
