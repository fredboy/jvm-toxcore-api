package im.tox.core.typesafe

import im.tox.core.ModuleCompanion

abstract class IntCompanion<T : Any> : ModuleCompanion<T, Security.Sensitive>() {

  protected abstract fun fromInt(value: Int): T?

  protected abstract fun toInt(self: T?): Int

  override fun equals(a: T?, b: T?): Boolean = toInt(a) == toInt(b)

}