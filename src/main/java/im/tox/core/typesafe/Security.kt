package im.tox.core.typesafe

sealed interface Security {

  data object Sensitive : Security

  data object NonSensitive : Security

}