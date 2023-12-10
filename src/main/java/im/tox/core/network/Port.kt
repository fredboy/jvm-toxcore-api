package im.tox.core.network

import im.tox.core.typesafe.BoundedIntCompanion

/**
 * IP_Port stores an IP datastructure with a port.
 */
@JvmInline
value class Port(val value: Int) {

  companion object : BoundedIntCompanion<Port>(0, 0xffff) {

    override fun unsafeFromInt(value: Int): Port = Port(value)

    override fun toInt(self: Port): Int = self.value

  }

}