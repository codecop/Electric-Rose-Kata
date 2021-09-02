package main

import (
	"fmt"
	"math"
)

type Battery struct {
	brand  string
	dry    bool
	charge float64
}

func (battery Battery) Print() string {
	return fmt.Sprintf("%s, %t, %.1f\n", battery.brand, battery.dry, battery.charge)
}

func UpdateCharge(batteries []*Battery) {
	for i := 0; i < len(batteries); i++ {

		if batteries[i].charge >= 0.1 {
			batteries[i].charge = math.Max(0, batteries[i].charge-0.1)
		}

		if batteries[i].dry {
			if batteries[i].charge >= 0.1 {
				batteries[i].charge = math.Max(0, batteries[i].charge-0.1)
			}
		}

	}
}
