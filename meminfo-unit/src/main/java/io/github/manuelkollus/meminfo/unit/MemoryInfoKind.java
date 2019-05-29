package io.github.manuelkollus.meminfo.unit;

/**
 * Represents a key in the "/proc/meminfo" file.
 *
 * @author Manuel Kollus
 * @version 1.0
 * @see MemoryInfoFileField
 */
public final class MemoryInfoKind {

  private String name;

  private MemoryInfoKind(String name) {
    this.name = name;
  }

  public String name() {
    return name;
  }
}
