package tech.itpark.reader;

import com.google.gson.Gson;
import tech.itpark.container.Definition;
import tech.itpark.exception.DefinitionReadException;

import java.nio.file.Files;
import java.nio.file.Path;

public class JsonDefinitionReader {
  private final Gson gson = new Gson();

  public Definition[] read(Path path) {
    try (
        final var reader = Files.newBufferedReader(path);
    ) {
      return gson.fromJson(reader, Definition[].class);
    } catch (Exception e) {
      throw new DefinitionReadException(e);
    }
  }
}
