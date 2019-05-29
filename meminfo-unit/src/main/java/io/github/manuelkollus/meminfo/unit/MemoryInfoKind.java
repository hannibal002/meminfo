package io.github.manuelkollus.meminfo.unit;

/**
 * Represents a key in the "/proc/meminfo" file.
 *
 * @author Manuel Kollus
 * @version 1.0
 * @see MemoryInfoFileField
 */
public enum MemoryInfoKind {

  MEM_TOTAL("MemTotal", MemoryInfoUnit.KILO_BYTES),
  MEM_FREE("MemFree", MemoryInfoUnit.KILO_BYTES),
  MEM_AVAILABLE("MemAvailable", MemoryInfoUnit.KILO_BYTES),
  BUFFERS("Buffers", MemoryInfoUnit.KILO_BYTES),
  CACHED("Cached", MemoryInfoUnit.KILO_BYTES),
  SWAP_CACHED("SwapCached", MemoryInfoUnit.KILO_BYTES),
  ACTIVE("Active", MemoryInfoUnit.KILO_BYTES),
  INACTIVE("Inactive", MemoryInfoUnit.KILO_BYTES);

  private final String key;
  private final MemoryInfoUnit memoryInfoUnit;

  MemoryInfoKind(
    String key,
    MemoryInfoUnit memoryInfoUnit) {
    this.key = key;
    this.memoryInfoUnit = memoryInfoUnit;
  }

  public String key() {
    return key;
  }

  public MemoryInfoUnit memoryInfoUnit() {
    return memoryInfoUnit;
  }
}
