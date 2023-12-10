package im.tox.tox4j.core.data

import im.tox.core.typesafe.VariableSizeByteArrayCompanion
import im.tox.tox4j.core.ToxCoreConstants

data class ToxFriendMessage internal constructor(val value: ByteArray) {

  override fun toString(): String = String(value)

  companion object : VariableSizeByteArrayCompanion<ToxFriendMessage>(
          ToxCoreConstants.maxMessageLength,
          ToxFriendMessage::value
  ) {

    override fun validate(value: ByteArray): Exception? {
      return super.validate(value) ?: if (value.isEmpty()) {
        IllegalArgumentException("Empty friend message")
      } else {
        null
      }
    }

    override fun unsafeFromValue(value: ByteArray): ToxFriendMessage {
      return ToxFriendMessage(value)
    }

  }
}