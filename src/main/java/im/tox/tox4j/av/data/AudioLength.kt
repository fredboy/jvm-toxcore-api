package im.tox.tox4j.av.data

import im.tox.core.typesafe.DiscreteValueCompanion
import kotlin.time.Duration
import kotlin.time.Duration.Companion.microseconds

data class AudioLength internal constructor(val value: Duration) {

  companion object : DiscreteValueCompanion<Duration, AudioLength>(
          AudioLength::value,
          5000.microseconds,
          10000.microseconds,
          20000.microseconds,
          40000.microseconds,
          60000.microseconds,
  ) {

    val length2_5 = AudioLength(values[0])
    val length5 = AudioLength(values[1])
    val length10 = AudioLength(values[2])
    val length20 = AudioLength(values[3])
    val length40 = AudioLength(values[4])
    val length60 = AudioLength(values[5])

    override fun unsafeFromValue(value: Duration): AudioLength {
      return AudioLength(value)
    }

    override fun equals(a: AudioLength, b: AudioLength): Boolean {
      return a.value == b.value
    }

  }

}