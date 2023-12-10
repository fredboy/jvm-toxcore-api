package im.tox.tox4j.core.data

import im.tox.core.typesafe.VariableSizeByteArrayCompanion
import im.tox.tox4j.core.ToxCoreConstants

data class ToxNickname internal constructor(val value: ByteArray) {

  override fun toString(): String = String(value)

  companion object : VariableSizeByteArrayCompanion<ToxNickname>(
          ToxCoreConstants.maxNameLength,
          ToxNickname::value
  ) {

    override fun unsafeFromValue(value: ByteArray): ToxNickname {
      return ToxNickname(value)
    }

  }
}