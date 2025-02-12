package im.tox.tox4j.crypto.exceptions;

import im.tox.tox4j.exceptions.ToxException;
import org.jetbrains.annotations.NotNull;

public final class ToxGetSaltException extends ToxException {

  public enum Code {
    /**
     * The input data is missing the magic number (i.e. wasn't created by this
     * module, or is corrupted)
     */
    BAD_FORMAT,
    /**
     * The data or salt were null.
     */
    NULL,
  }

  public ToxGetSaltException(@NotNull Code code) {
    this(code, "");
  }

  public ToxGetSaltException(@NotNull Code code, String message) {
    super(code, message);
  }

}
