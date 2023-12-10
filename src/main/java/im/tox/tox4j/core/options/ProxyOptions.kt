package im.tox.tox4j.core.options
import im.tox.core.network.Port
import im.tox.tox4j.core.enums.ToxProxyType

/**
 * Base type for all proxy kinds.
 */
sealed interface ProxyOptions {

  /**
   * Low level enumeration value to pass to [ToxCore.load].
   */
  val proxyType: ToxProxyType

  /**
   * The IP address or DNS name of the proxy to be used.
   *
   * If used, this must be a valid DNS name. The name must not exceed [[ToxCoreConstants.MaxHostnameLength]] characters.
   * This member is ignored (it can be anything) if [[proxyType]] is [[ToxProxyType.NONE]].
   */
  val proxyAddress: String

  /**
   * The port to use to connect to the proxy server.
   *
   * Ports must be in the range (1, 65535). The value is ignored if [[proxyType]] is [[ToxProxyType.NONE]].
   */
  val proxyPort: Port

  /**
   * Don't use a proxy. Attempt to directly connect to other nodes.
   */
  data object None : ProxyOptions {
    override val proxyType = ToxProxyType.NONE
    override val proxyAddress = ""
    override val proxyPort: Port = Port.unsafeFromInt(0)
  }

  /**
   * Tunnel Tox TCP traffic over an HTTP proxy. The proxy must support CONNECT.
   */
  data class Http(
          override val proxyAddress: String,
          override val proxyPort: Port,
  ) : ProxyOptions {
    override val proxyType = ToxProxyType.HTTP
  }

  /**
   * Use a SOCKS5 proxy to make TCP connections. Although some SOCKS5 servers
   * support UDP sockets, the main use case (Tor) does not, and Tox will not
   * use the proxy for UDP connections.
   */
  data class Socks5(
          override val proxyAddress: String,
          override val proxyPort: Port,
  ) : ProxyOptions {
    override val proxyType = ToxProxyType.SOCKS5
  }

}
