package im.tox.tox4j.core.data

import im.tox.core.typesafe.KeyCompanion
import im.tox.core.typesafe.Security
import im.tox.tox4j.core.ToxCoreConstants

data class ToxFriendAddress internal constructor(val value: ByteArray) {

  fun toHexString() = ToxFriendAddress.toHexString(this)

  override fun toString(): String = "(${toHexString()})"

  companion object : KeyCompanion<ToxFriendAddress, Security.Sensitive>(
          ToxCoreConstants.addressSize,
          ToxFriendAddress::value
  ) {

    override fun unsafeFromValue(value: ByteArray): ToxFriendAddress {
      return ToxFriendAddress(value)
    }

  }
}
