package org.adligo.i_io.shared;

import java.io.Closeable;

/**
 * The purpose of a RuntimeIOException is almost the same as a regualr {@link RuntimeException},
 * However, the main reason for it is so that code that MAY or MAY NOT be doing
 * I/O (for example, file parsing) can execute with an appropriate exception methodology.
 * This allows the users of these APIs to optimize I/O And the respective exception handling
 * appropriately depending on the Use-Case.
 *
 * @author scott<br/>
 *         <br/>
 *
 * <pre><code>
 * ---------------- Apache ICENSE-2.0 --------------------------
 *
 * Copyright 2022 Adligo Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </code><pre>
 */

public class RuntimeIOException extends RuntimeException {
  private final Object _origin;

  public RuntimeIOException(String message, Throwable cause) {
    super(message, cause);
    _origin = null;
  }

  public RuntimeIOException(String message, Throwable cause, Object origin) {
    super(message, cause);
    _origin = origin;
  }

  public RuntimeIOException(String message, Throwable cause, Closeable origin) {
    super(message, cause);
    _origin = origin;
  }

  public boolean hasOrigin() {
    return _origin != null;
  }

  public Object getOrigin() {
    return _origin;
  }
}

