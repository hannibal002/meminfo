package io.github.manuelkollus.meminfo.unit;

import java.util.regex.Pattern;

/**
 * The {@link MemoryInfoUnit} represents an list of memory units. Every field
 * has an unit to the end.
 *
 * @author Manuel Kollus
 * @version 1.0
 */
public enum MemoryInfoUnit {

  KILO_BYTES("kb", Pattern.compile("^%s:[\\t ]+([0-9]+)([\\t ]+%s)?$")),
  AMOUNT("", Pattern.compile("^%s:[\\t ]+([0-9]+)$")),
  NONE("", Pattern.compile("^%s:[\\t ]+([0-9]+)$"));

  private String unit;
  private Pattern pattern;

  MemoryInfoUnit(String unit, Pattern pattern) {
    this.unit = unit;
    this.pattern = pattern;
  }

  public String unit() {
    return unit;
  }
}
