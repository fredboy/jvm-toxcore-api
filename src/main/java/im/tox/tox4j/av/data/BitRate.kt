package im.tox.tox4j.av.data

import im.tox.core.typesafe.BoundedIntCompanion

data class BitRate internal constructor(val value: Int) {

  companion object : BoundedIntCompanion<BitRate>(-1, Int.MAX_VALUE) {

    val unchanged = BitRate(-1)
    val disabled = BitRate(0)

    override fun unsafeFromInt(value: Int): BitRate {
      return BitRate(value)
    }

    override fun toInt(self: BitRate): Int {
      return self.value
    }

  }

}