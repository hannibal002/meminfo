package io.github.manuelkollus.meminfo.unit;

import java.util.Objects;

/**
 * Represents a field in the "/proc/meminfo" file.
 *
 * @author Manuel Kollus
 * @version 1.0
 * @see MemoryInfoUnit
 */
public final class MemoryInfoFileField {

  private static final class Lazy {

    private static final MemoryInfoFileField EMPTY =
      create("", "", MemoryInfoUnit.NONE);
  }

  private final String key;
  private final String value;
  private final MemoryInfoUnit memoryInfoUnit;

  private MemoryInfoFileField(
    String key,
    String value,
    MemoryInfoUnit memoryInfoUnit) {
    this.key = key;
    this.value = value;
    this.memoryInfoUnit = memoryInfoUnit;
  }

  public String key() {
    return key;
  }

  public String value() {
    return value;
  }

  public MemoryInfoUnit memoryInfoUnit() {
    return memoryInfoUnit;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }

    if (!(other instanceof MemoryInfoFileField)) {
      return false;
    }

    MemoryInfoFileField that = (MemoryInfoFileField) other;

    return key.equals(that.key) &&
      value.equals(that.value) &&
      memoryInfoUnit == that.memoryInfoUnit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      key,
      value,
      memoryInfoUnit);
  }

  @Override
  public String toString() {
    return "MemoryInfoFileField{" +
      "key='" + key + '\'' +
      ", value='" + value + '\'' +
      ", memoryInfoUnit=" + memoryInfoUnit +
      '}';
  }

  public static MemoryInfoFileField empty() {
    return Lazy.EMPTY;
  }

  public static MemoryInfoFileField create(
    String key,
    String value,
    MemoryInfoUnit memoryInfoUnit) {
    Objects.requireNonNull(key, "key cannot be null!");
    Objects.requireNonNull(value, "value cannot be null!");
    Objects.requireNonNull(memoryInfoUnit, "memoryInfoUnit cannot be null!");

    return new MemoryInfoFileField(key, value, memoryInfoUnit);
  }
}
