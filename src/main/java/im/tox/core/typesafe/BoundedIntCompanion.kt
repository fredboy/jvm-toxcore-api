package im.tox.core.typesafe

abstract class BoundedIntCompanion<T : Any>(
        val minValue: Int,
        val maxValue: Int,
) : IntCompanion<T>() {

  protected abstract fun unsafeFromInt(value: Int): T

  fun clamp(value: Int): T = unsafeFromInt(value.coerceIn(minValue..maxValue))

  override fun fromInt(value: Int): T? {
    return if (value in minValue..maxValue) {
      unsafeFromInt(value)
    } else {
      null
    }
  }

}