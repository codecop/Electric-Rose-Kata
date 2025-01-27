ElectricRose := Object clone do(

    batteries := nil

    with := method(batteries,
        result := self clone
        result batteries := batteries
        result
    )

    updateCharge := method(
        for(i, 0, batteries size - 1,
            if (batteries at(i) charge >= 0.1,
                batteries at(i) charge = 0 max(batteries at(i) charge - 0.1)
            )

            if (batteries at(i) dry,
                if (batteries at(i) charge >= 0.1,
                    batteries at(i) charge = 0 max(batteries at(i) charge - 0.1)
                )
            )
        )
    )

)
