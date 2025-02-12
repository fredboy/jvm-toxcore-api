package im.tox.tox4j.av.callbacks

import im.tox.tox4j.av.data.AudioChannels
import im.tox.tox4j.av.data.SamplingRate
import im.tox.tox4j.core.data.ToxFriendNumber

/**
 * Called when an audio frame is received.
 */
interface AudioReceiveFrameCallback<ToxCoreState> {

  /**
   * @param friendNumber The friend number of the friend who sent an audio frame.
   * @param pcm An array of audio samples (sample_count * channels elements).
   * @param channels Number of audio channels.
   * @param samplingRate Sampling rate used in this frame.
   */
  fun audioReceiveFrame(
          friendNumber: ToxFriendNumber,
          pcm: ShortArray,
          channels: AudioChannels,
          samplingRate: SamplingRate,
          state: ToxCoreState,
  ) = state

}