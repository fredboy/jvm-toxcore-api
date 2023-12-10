package im.tox.core.typesafe

abstract class DiscreteValueCompanion<Repr, T : Any>(
    override val toValue: (T) -> Repr,
    protected vararg val values: Repr,
) : WrappedValueCompanion<Repr, T, Security.Sensitive>() {

    override fun validate(value: Repr): Exception? {
        return require(values.contains(value)) { "Invalid value: $value; accepted values: $values" }
    }

}