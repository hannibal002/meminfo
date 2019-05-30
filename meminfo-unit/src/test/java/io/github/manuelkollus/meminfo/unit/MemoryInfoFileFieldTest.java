package io.github.manuelkollus.meminfo.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public final class MemoryInfoFileFieldTest {

  @Test
  public void buildEmptyMemoryInfoFileField() {
    MemoryInfoFileField fileField = MemoryInfoFileField.empty();

    assertEquals(fileField.key(), "");
    assertEquals(fileField.value(), "");
    assertEquals(fileField.memoryInfoUnit(), MemoryInfoUnit.NONE);
  }
}
