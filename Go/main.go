package main

import (
	"fmt"
	"os"
	"strconv"
)

func main() {
	fmt.Println("BZZ ZZZ!")

	var batteries = []*Battery{
		{"Samsung Lithium-ion", false, 20}, //
		{"Budget Nickel Cadmium", true, 7},
	}

	times := 2
	var err error
	if len(os.Args) > 1 {
		times, err = strconv.Atoi(os.Args[1])
		if err != nil {
			fmt.Println(err.Error())
			os.Exit(1)
		}
		times++
	}

	for t := 0; t < times; t++ {
		fmt.Printf("-------- usage %d --------\n", t)
		fmt.Println("type, dry, charge")
		for i := 0; i < len(batteries); i++ {
			fmt.Print(batteries[i].Print())
		}
		fmt.Println("")
		UpdateCharge(batteries)
	}
}
