package im.tox.tox4j.av.data

import im.tox.core.typesafe.BoundedIntCompanion

data class Width internal constructor(val value: Int) {

  companion object : BoundedIntCompanion<Width>(1, 1920) {

    override fun unsafeFromInt(value: Int): Width {
      return Width(value)
    }

    override fun toInt(self: Width): Int {
      return self.value
    }

  }

}