package io.github.manuelkollus.meminfo.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.manuelkollus.meminfo.unit.MemoryInfoFileField;
import io.github.manuelkollus.meminfo.unit.MemoryInfoUnit;
import org.junit.jupiter.api.Test;

public final class MemoryInfoParserTest {

  @Test
  public void parseToMemoryInfoWithUnit() {
    MemoryInfoParser memoryInfoParser = new MemoryInfoParser();

    MemoryInfoFileField fileField = memoryInfoParser
      .parseWithUnit("MemTotal:      5997568 kB");

    assertEquals("MemTotal", fileField.key());
    assertEquals("5997568", fileField.value());
    assertEquals(MemoryInfoUnit.KILO_BYTES, fileField.memoryInfoUnit());
  }

  @Test
  public void parseToMemoryInfoWithoutUnit() {
    MemoryInfoParser memoryInfoParser = new MemoryInfoParser();

    MemoryInfoFileField fileField = memoryInfoParser
      .parseWithoutUnit("HugePages_Total:     0");

    assertEquals("HugePages_Total", fileField.key());
    assertEquals("0", fileField.value());
    assertEquals(MemoryInfoUnit.AMOUNT, fileField.memoryInfoUnit());
  }
}
