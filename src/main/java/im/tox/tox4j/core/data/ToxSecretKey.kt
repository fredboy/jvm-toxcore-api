package im.tox.tox4j.core.data

import im.tox.core.typesafe.KeyCompanion
import im.tox.core.typesafe.Security
import im.tox.tox4j.crypto.ToxCryptoConstants

data class ToxSecretKey internal constructor(val value: ByteArray) {

  fun toHexString() = ToxSecretKey.toHexString(this)

  override fun toString(): String {
    return "(${toHexString()})"
  }

  companion object : KeyCompanion<ToxSecretKey, Security.Sensitive>(
          ToxCryptoConstants.secretKeyLength,
          ToxSecretKey::value
  ) {

    override fun unsafeFromValue(value: ByteArray): ToxSecretKey {
      return ToxSecretKey(value)
    }

  }
}
