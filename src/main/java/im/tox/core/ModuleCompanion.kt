package im.tox.core

import im.tox.core.typesafe.Security

abstract class ModuleCompanion<in T, in S : Security> {

  abstract fun equals(a: T, b: T): Boolean

}