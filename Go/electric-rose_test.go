package main

import "testing"

func Test_Foo(t *testing.T) {
	var batteries = []*Battery{
		{"foo", false, 1},
	}

	UpdateCharge(batteries)

	if batteries[0].brand != "fixme" {
		t.Errorf("Brand: Expected %s but got %s ", "fixme", batteries[0].brand)
	}
}
