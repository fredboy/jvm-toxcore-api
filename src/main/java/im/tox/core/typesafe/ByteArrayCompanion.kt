package im.tox.core.typesafe

import com.fernandocejas.sample.core.functional.Either

abstract class ByteArrayCompanion<T : Any, S : Security>(
        override val toValue: (T) -> ByteArray
) : WrappedValueCompanion<ByteArray, T, S>() {

  override fun equals(a: T, b: T): Boolean {
    return toValue(a).contentEquals(toValue(b))
  }

  fun fromString(value: String): Either<Exception, T> {
    return fromValue(value.toByteArray())
  }

  fun toHexString(self: T): String {
    return toValue(self).joinToString("") { "%02X".format(it) }
  }


  fun fromHexString(string: String): Either<Exception, T> {
    val bytes = string
            .chunked(2)
            .map { it.toInt(16).toByte() }
            .toByteArray()

    return fromValue(bytes)
  }

}