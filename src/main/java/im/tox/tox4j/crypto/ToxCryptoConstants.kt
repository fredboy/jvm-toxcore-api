package im.tox.tox4j.crypto

object ToxCryptoConstants {

  /**
   * Length of salt in bytes.
   */
  const val saltLength = 32

  /**
   * The number of bytes in a serialised [ToxCrypto.PassKey] without salt.
   * The serialised size is [keyLength] + [saltLength].
   */
  const val keyLength = 32

  /**
   * Number of bytes added to any encrypted data.
   */
  const val encryptionExtraLength = 80

  /**
   * The number of bytes in a hash generated by tox_hash.
   */
  const val hashLength = 32

  const val publicKeyLength = 32
  const val secretKeyLength = 32
  const val sharedKeyLength = 32
  const val nonceLength = 24

  const val zeroBytes = 32
  const val boxZeroBytes = 16

}