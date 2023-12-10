package im.tox.tox4j.av.data

import im.tox.core.typesafe.DiscreteIntCompanion

data class AudioChannels internal constructor(val value: Int) {

  companion object : DiscreteIntCompanion<AudioChannels>(1, 2) {
    val mono = AudioChannels(1)
    val stereo = AudioChannels(2)

    override fun unsafeFromInt(value: Int): AudioChannels {
      return AudioChannels(value)
    }

    override fun toInt(self: AudioChannels): Int {
      return self.value
    }
  }

}