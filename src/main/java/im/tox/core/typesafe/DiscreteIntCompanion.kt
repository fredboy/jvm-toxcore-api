package im.tox.core.typesafe

abstract class DiscreteIntCompanion<T : Any>(
        protected vararg val values: Int
) : IntCompanion<T>() {

  abstract fun unsafeFromInt(value: Int): T

  override fun fromInt(value: Int): T? {
    return if (values.contains(value)) {
      unsafeFromInt(value)
    } else {
      null
    }
  }

}