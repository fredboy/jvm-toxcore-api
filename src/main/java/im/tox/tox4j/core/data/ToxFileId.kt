package im.tox.tox4j.core.data

import im.tox.core.typesafe.KeyCompanion
import im.tox.core.typesafe.Security
import im.tox.tox4j.core.ToxCoreConstants

data class ToxFileId internal constructor(val value: ByteArray) {

  fun toHexString() = ToxFileId.toHexString(this)

  override fun toString(): String {
    return "(${toHexString()})"
  }

  companion object : KeyCompanion<ToxFileId, Security.Sensitive>(
          ToxCoreConstants.fileIdLength,
          ToxFileId::value
  ) {

    val empty = ToxFileId(ByteArray(0))

    override fun unsafeFromValue(value: ByteArray): ToxFileId {
      return ToxFileId(value)
    }

  }
}