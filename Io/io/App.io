writeln("BZZ ZZZ!")

batteries := list(
    Battery with("Samsung Lithium-ion", false, 20),
    Battery with("Budget Nickel Cadmium", true, 7))

app := ElectricRose with(batteries)

times := 2
if (System args size > 1,
    times = System args at(1) asNumber + 1
)

for(i, 0, times - 1,
    writeln("-------- usage " .. i .. " --------")
    writeln("type, dry, charge")
    batteries foreach(battery,
        writeln(battery)
    )
    writeln
    app updateCharge
)
