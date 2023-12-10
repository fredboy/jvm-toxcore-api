package im.tox.tox4j.av.data

import im.tox.core.typesafe.DiscreteIntCompanion

data class SamplingRate internal constructor(val value: Int) {

  companion object : DiscreteIntCompanion<SamplingRate>(
          8000,
          12000,
          16000,
          24000,
          48000
  ) {

    val rate8k = SamplingRate(values[0])
    val rate12k = SamplingRate(values[1])
    val rate16k = SamplingRate(values[2])
    val rate24k = SamplingRate(values[3])
    val rate48k = SamplingRate(values[4])

    override fun unsafeFromInt(value: Int): SamplingRate {
      return SamplingRate(value)
    }

    override fun toInt(self: SamplingRate): Int {
      return self.value
    }

  }

}