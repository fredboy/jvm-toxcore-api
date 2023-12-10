package im.tox.tox4j.core

import im.tox.tox4j.crypto.ToxCryptoConstants

object ToxCoreConstants {

  /**
   * The size of a Tox Public Key in bytes.
   */
  const val publicKeySize = ToxCryptoConstants.publicKeyLength

  /**
   * The size of a Tox Secret Key in bytes.
   */
  const val secretKeySize = ToxCryptoConstants.secretKeyLength

  /**
   * The size of a Tox address in bytes. Tox addresses are in the format
   * [Public Key ([PublicKeySize] bytes)][nospam (4 bytes)][checksum (2 bytes)].
   *
   * The checksum is computed over the Public Key and the nospam value. The first
   * byte is an XOR of all the odd bytes, the second byte is an XOR of all the
   * even bytes of the Public Key and nospam.
   */
  const val addressSize = publicKeySize + 4 + 2

  /**
   * Maximum length of a nickname in bytes.
   */
  const val maxNameLength = 128

  /**
   * Maximum length of a status message in bytes.
   */
  const val maxStatusMessageLength = 1007

  /**
   * Maximum length of a friend request message in bytes.
   */
  const val maxFriendRequestLength = 1016

  /**
   * Maximum length of a single message after which it should be split.
   */
  const val maxMessageLength = 1372

  /**
   * Maximum size of custom packets.
   */
  const val maxCustomPacketLength = 1373

  /**
   * Maximum file name length for file transfers.
   */
  const val maxFileNameLength = 255

  /**
   * Maximum hostname length. This is determined by calling `getconf HOST_NAME_MAX` on the console. The value
   * presented here is valid for most systems.
   */
  const val maxHostNameLength = 255

  /**
   * The number of bytes in a file id.
   */
  const val fileIdLength = ToxCryptoConstants.hashLength

  /**
   * Default port for HTTP proxies.
   */
  const val defaultProxyPort = 8080

  /**
   * Default start port for Tox UDP sockets.
   */
  const val defaultStartPort = 33445

  /**
   * Default end port for Tox UDP sockets.
   */
  const val defaultEndPort = defaultStartPort + 100

  /**
   * Default port for Tox TCP relays. A value of 0 means disabled.
   */
  const val defaultTcpPort = 0

}
