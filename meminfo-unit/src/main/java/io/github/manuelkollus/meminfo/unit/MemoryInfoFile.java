package io.github.manuelkollus.meminfo.unit;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * The {@link MemoryInfoFile} collect all {@link MemoryInfoFileField}.
 *
 * @author Manuel Kollus
 * @version 1.0
 * @see MemoryInfoFileField
 */
public final class MemoryInfoFile {

  private final Map<String, MemoryInfoFileField> fields;

  private MemoryInfoFile(Map<String, MemoryInfoFileField> fields) {
    this.fields = fields;
  }

  public Optional<MemoryInfoFileField> field(MemoryInfoKind kind) {
    Objects.requireNonNull(kind, "memoryInfoKind cannot be null!");

    return Optional.ofNullable(fields.get(kind.name()));
  }

  public static MemoryInfoFile create(Map<String, MemoryInfoFileField> fields) {
    Objects.requireNonNull(fields, "fields cannot be null!");

    return new MemoryInfoFile(new HashMap<>());
  }
}
