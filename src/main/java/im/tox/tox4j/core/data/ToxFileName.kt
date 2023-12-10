package im.tox.tox4j.core.data

import im.tox.core.typesafe.VariableSizeByteArrayCompanion
import im.tox.tox4j.core.ToxCoreConstants

data class ToxFileName internal constructor(val value: ByteArray) {

  fun toHexString() = ToxFileName.toHexString(this)

  override fun toString(): String = String(value)

  companion object : VariableSizeByteArrayCompanion<ToxFileName>(
          ToxCoreConstants.maxFileNameLength,
          ToxFileName::value
  ) {

    override fun unsafeFromValue(value: ByteArray): ToxFileName {
      return ToxFileName(value)
    }

  }
}