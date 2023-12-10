package im.tox.tox4j.core.callbacks

import im.tox.tox4j.core.data.ToxFriendNumber
import im.tox.tox4j.core.data.ToxNickname
import im.tox.tox4j.core.data.ToxPublicKey
import im.tox.tox4j.core.enums.ToxConnection
import im.tox.tox4j.core.enums.ToxFileControl
import im.tox.tox4j.core.enums.ToxMessageType
import im.tox.tox4j.core.enums.ToxUserStatus

interface ToxCoreEventSynth {

  fun invokeFriendName(friendNumber: ToxFriendNumber, name: ToxNickname)
  
  fun invokeFriendStatusMessage(friendNumber: ToxFriendNumber, message: ByteArray)
  
  fun invokeFriendStatus(friendNumber: ToxFriendNumber, status: ToxUserStatus)
  
  fun invokeFriendConnectionStatus(friendNumber: ToxFriendNumber, connectionStatus: ToxConnection)
  
  fun invokeFriendTyping(friendNumber: ToxFriendNumber, isTyping: Boolean)
  
  fun invokeFriendReadReceipt(friendNumber: ToxFriendNumber, messageId: Int)
  
  fun invokeFriendRequest(publicKey: ToxPublicKey, timeDelta: Int, message: ByteArray)
  
  fun invokeFriendMessage(friendNumber: ToxFriendNumber, messageType: ToxMessageType, timeDelta: Int, message: ByteArray)
  
  fun invokeFileChunkRequest(friendNumber: ToxFriendNumber, fileNumber: Int, position: Long, length: Int)
  
  fun invokeFileRecv(friendNumber: ToxFriendNumber, fileNumber: Int, kind: Int, fileSize: Long, filename: ByteArray)
  
  fun invokeFileRecvChunk(friendNumber: ToxFriendNumber, fileNumber: Int, position: Long, data: ByteArray)
  
  fun invokeFileRecvControl(friendNumber: ToxFriendNumber, fileNumber: Int, control: ToxFileControl)
  
  fun invokeFriendLossyPacket(friendNumber: ToxFriendNumber, data: ByteArray)
  
  fun invokeFriendLosslessPacket(friendNumber: ToxFriendNumber, data: ByteArray)
  
  fun invokeSelfConnectionStatus(connectionStatus: ToxConnection)

}
