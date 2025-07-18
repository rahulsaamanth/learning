package main

import (
	"fmt"
)					


func _maps() {
	m := make(map[string]int)
	m["k1"] = 7
	m["k2"] = 13
	fmt.Println("map:", m)

	v1 := m["k1"]
	fmt.Println("value1: " , v1)

	// if the key doesn't exist , the zero value of the value type is returned
	v3 := m["k3"]
	fmt.Println("value3: ", v3)

	fmt.Println("length: ", len(m))

	delete(m, "k2")
	fmt.Println(m)

	clear(m)
	fmt.Println(m)
	
	// there is an optional second return value when getting a value from a map, indicates if the key was present in the map. This can be used to disambiguate b/w missing keys and keys with zero values like 0 or " "

	_,prs := m["k2"]
	fmt.Println("prs:", prs)
}