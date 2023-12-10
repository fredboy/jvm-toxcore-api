package im.tox.tox4j.av.callbacks

import im.tox.tox4j.av.data.*

import im.tox.tox4j.av.enums.ToxavFriendCallState
import im.tox.tox4j.core.data.ToxFriendNumber
import java.util.*

interface ToxAvEventSynth {

  fun invokeAudioBitRate(friendNumber: ToxFriendNumber, audioBitRate: BitRate)

  fun invokeAudioReceiveFrame(friendNumber: ToxFriendNumber, pcm: ShortArray, channels: AudioChannels, samplingRate: SamplingRate)

  fun invokeCall(friendNumber: ToxFriendNumber, audioEnabled: Boolean, videoEnabled: Boolean)

  fun invokeCallState(friendNumber: ToxFriendNumber, callState: EnumSet<ToxavFriendCallState>)

  fun invokeVideoBitRate(friendNumber: ToxFriendNumber, videoBitRate: BitRate)

  fun invokeVideoReceiveFrame(friendNumber: ToxFriendNumber, width: Width, height: Height, y: ByteArray, u: ByteArray, v: ByteArray, yStride: Int, uStride: Int, vStride: Int)

}
