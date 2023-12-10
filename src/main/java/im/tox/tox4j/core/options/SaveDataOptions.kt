package im.tox.tox4j.core.options

import im.tox.tox4j.core.data.ToxSecretKey
import im.tox.tox4j.core.enums.ToxSavedataType

/**
 * Base type for all save data kinds.
 */
sealed interface SaveDataOptions {

  /**
   * The low level [[ToxSavedataType]] enum to pass to [[ToxCore.load]].
   */
  val kind: ToxSavedataType

  /**
   * Serialised save data. The format depends on [[kind]].
   */
  val data: ByteArray

  /**
   * No save data.
   */
  data object None : SaveDataOptions {

    override val kind = ToxSavedataType.NONE

    override val data = ByteArray(0)

  }

  /**
   * Full save data containing friend list, last seen DHT nodes, name, and all other information
   * contained within a Tox instance.
   */
  data class ToxSave(
          override val data: ByteArray
  ) : SaveDataOptions {

    override val kind = ToxSavedataType.TOX_SAVE

    override fun equals(other: Any?): Boolean {
      if (this === other) return true
      if (javaClass != other?.javaClass) return false

      other as ToxSave

      if (!data.contentEquals(other.data)) return false
      if (kind != other.kind) return false

      return true
    }

    override fun hashCode(): Int {
      var result = data.contentHashCode()
      result = 31 * result + kind.hashCode()
      return result
    }

  }

  /**
   * Minimal save data with just the secret key. The public key can be derived from it. Saving this
   * secret key, the friend list, name, and noSpam value is sufficient to restore the observable
   * behaviour of a Tox instance without the full save data in [[ToxSave]].
   */
  data class SecretKey internal constructor(
          override val data: ByteArray
  ) : SaveDataOptions {

    constructor(key: ToxSecretKey) : this(key.value)

    override val kind = ToxSavedataType.SECRET_KEY

    override fun equals(other: Any?): Boolean {
      if (this === other) return true
      if (javaClass != other?.javaClass) return false

      other as SecretKey

      if (!data.contentEquals(other.data)) return false
      if (kind != other.kind) return false

      return true
    }

    override fun hashCode(): Int {
      var result = data.contentHashCode()
      result = 31 * result + kind.hashCode()
      return result
    }
  }

}
