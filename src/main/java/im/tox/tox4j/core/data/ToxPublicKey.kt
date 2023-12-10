package im.tox.tox4j.core.data

import im.tox.core.typesafe.KeyCompanion
import im.tox.core.typesafe.Security
import im.tox.tox4j.crypto.ToxCryptoConstants

data class ToxPublicKey internal constructor(val value: ByteArray) {

  fun toHexString() = ToxPublicKey.toHexString(this)

  override fun toString(): String {
    return "(${toHexString()})"
  }

  companion object : KeyCompanion<ToxPublicKey, Security.Sensitive>(
          ToxCryptoConstants.publicKeyLength,
          ToxPublicKey::value
  ) {

    override fun unsafeFromValue(value: ByteArray): ToxPublicKey {
      return ToxPublicKey(value)
    }

  }
}
