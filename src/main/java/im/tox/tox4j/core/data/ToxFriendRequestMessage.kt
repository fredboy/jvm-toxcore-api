package im.tox.tox4j.core.data

import im.tox.core.typesafe.VariableSizeByteArrayCompanion
import im.tox.tox4j.core.ToxCoreConstants

data class ToxFriendRequestMessage internal constructor(val value: ByteArray) {

  override fun toString(): String = String(value)

  companion object : VariableSizeByteArrayCompanion<ToxFriendRequestMessage>(
          ToxCoreConstants.maxFriendRequestLength,
          ToxFriendRequestMessage::value
  ) {

    override fun unsafeFromValue(value: ByteArray): ToxFriendRequestMessage {
      return ToxFriendRequestMessage(value)
    }

  }
}