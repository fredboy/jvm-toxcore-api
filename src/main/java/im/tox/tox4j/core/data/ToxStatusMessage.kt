package im.tox.tox4j.core.data

import im.tox.core.typesafe.VariableSizeByteArrayCompanion
import im.tox.tox4j.core.ToxCoreConstants

data class ToxStatusMessage internal constructor(val value: ByteArray) {

  override fun toString(): String = String(value)

  companion object : VariableSizeByteArrayCompanion<ToxStatusMessage>(
          ToxCoreConstants.maxStatusMessageLength,
          ToxStatusMessage::value
  ) {

    override fun unsafeFromValue(value: ByteArray): ToxStatusMessage {
      return ToxStatusMessage(value)
    }

  }
}
