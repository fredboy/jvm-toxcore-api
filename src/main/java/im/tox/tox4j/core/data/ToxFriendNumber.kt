package im.tox.tox4j.core.data

import im.tox.core.typesafe.BoundedIntCompanion

data class ToxFriendNumber internal constructor(val value: Int) {

  companion object : BoundedIntCompanion<ToxFriendNumber>(0, Int.MAX_VALUE) {

    override fun unsafeFromInt(value: Int): ToxFriendNumber {
      return ToxFriendNumber(value)
    }

    override fun toInt(self: ToxFriendNumber): Int {
      return self.value
    }

  }

}