package im.tox.tox4j.av.data

import im.tox.core.typesafe.BoundedIntCompanion

data class Height internal constructor(val value: Int) {

  companion object : BoundedIntCompanion<Height>(1, 1200) {

    override fun unsafeFromInt(value: Int): Height {
      return Height(value)
    }

    override fun toInt(self: Height): Int {
      return self.value
    }

  }

}