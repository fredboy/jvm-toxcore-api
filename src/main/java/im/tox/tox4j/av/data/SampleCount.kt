package im.tox.tox4j.av.data

data class SampleCount internal constructor(val value: Int) {

  companion object : (AudioLength, SamplingRate) -> SampleCount {

    override fun invoke(audioLength: AudioLength, samplingRate: SamplingRate): SampleCount {
      return SampleCount(samplingRate.value / 1000 * audioLength.value.inWholeMilliseconds.toInt())
    }

  }

}