package io.github.manuelkollus.meminfo.unit;

/**
 * The {@link MemoryInfoUnit} represents an list of memory units. Every field
 * has an unit to the end.
 *
 * @author Manuel Kollus
 * @version 1.0
 */
public enum MemoryInfoUnit {

  KILO_BYTES("kb"),
  AMOUNT(""),
  NONE("");

  private String unit;

  MemoryInfoUnit(String unit) {
    this.unit = unit;
  }

  public String unit() {
    return unit;
  }
}
