package io.github.manuelkollus.meminfo.parser;

import io.github.manuelkollus.meminfo.unit.MemoryInfoFileField;
import io.github.manuelkollus.meminfo.unit.MemoryInfoUnit;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@link MemoryInfoParser} parse the line to {@link MemoryInfoFileField}.
 *
 * @author Manuel Kollus
 * @version 1.0
 * @see MemoryInfoFileField
 */
final class MemoryInfoParser {

  private static final Pattern MATCH_FIELD_WITH_UNIT = Pattern
    .compile("^([\\w()]+):+\\s+(.*) ([\\w]+)");

  private static final Pattern MATCH_FIELD_WITHOUT_UNIT = Pattern
    .compile("^([\\w()]+):+\\s+(.*)");


  MemoryInfoFileField parseWithUnit(String line) {
    Objects.requireNonNull(line, "line cannot be null!");

    Matcher matcher = MATCH_FIELD_WITH_UNIT.matcher(line);

    if (!matcher.find()) {
      return MemoryInfoFileField.empty();
    }

    return MemoryInfoFileField.create(
      matcher.group(1), matcher.group(2), MemoryInfoUnit.KILO_BYTES);
  }

  MemoryInfoFileField parseWithoutUnit(String line) {
    Objects.requireNonNull(line, "line cannot be null!");

    Matcher matcher = MATCH_FIELD_WITHOUT_UNIT.matcher(line);

    if (!matcher.find()) {
      return MemoryInfoFileField.empty();
    }

    return MemoryInfoFileField.create(
      matcher.group(1), matcher.group(2), MemoryInfoUnit.AMOUNT);
  }
}
