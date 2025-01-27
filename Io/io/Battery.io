Battery := Object clone do(

    brand := nil
    dry := nil
    charge := nil

    with := method(brand, dry, charge,
        result := self clone
        result brand := brand
        result dry := dry
        result charge := charge
        result
    )

    asString = method(
        return self brand .. ", " .. self dry .. ", " .. self charge
    )

)
