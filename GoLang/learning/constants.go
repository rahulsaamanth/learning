package main

import (
	"fmt"
	"math"
)

const s string = "constant"

func constants(){
	fmt.Println(s)

	// A const statement can appear anywhere a var statement can
	const n = 500000000
	
	const d = 3e20 / n
	fmt.Println(d)

	// A numeric constant has no type until it's given one, such as by an explicit conversion
	fmt.Println(int64(d))

	fmt.Println(math.Sin(n))
}
