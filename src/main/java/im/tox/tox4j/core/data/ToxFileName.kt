package im.tox.tox4j.core.data

import im.tox.core.typesafe.KeyCompanion
import im.tox.core.typesafe.Security
import im.tox.tox4j.core.ToxCoreConstants

data class ToxFileName internal constructor(val value: ByteArray) {

  fun toHexString() = ToxFileName.toHexString(this)

  override fun toString(): String = String(value)

  companion object : KeyCompanion<ToxFileName, Security.Sensitive>(
          ToxCoreConstants.maxFileNameLength,
          ToxFileName::value
  ) {

    override fun unsafeFromValue(value: ByteArray): ToxFileName {
      return ToxFileName(value)
    }

  }
}