doRelativeFile("../../io/Battery.io")
doRelativeFile("../../io/ElectricRose.io")

ElectricRoseTest := UnitTest clone do(

    testFoo := method(
        batteries := list( Battery with("foo", false, 1) )
        app := ElectricRose with(batteries)
        app updateCharge
        assertEquals("fixme", app batteries at(0) brand)
    )

)
