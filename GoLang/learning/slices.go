package main

import (
	"fmt"
	"slices"
)					


func _slices(){
	// An uninitialized slice equals to nil and has a length of 0
	var s []string
	fmt.Println("uninitialized:", s , s == nil, len(s) == 0)

	// To create a slice with non-zero length, use the builtin make 
	s = make([]string, 3)
	fmt.Println("empty:", s, "length:", len(s), "capacity:", cap(s));

	// We can get and set just like arrays
	s[0] = "a"
	s[1] = "b"
	s[2] = "c"
	fmt.Println("set:", s)
	fmt.Println("get:", s[2])

	fmt.Println("length:", len(s))

	// Slices support several more that make them richer than arrays
	s = append(s, "d")
	s = append(s, "e", "f")
	fmt.Println("append:", s)

	// Slices can be copied, here we create an empty slice c of the same length and then copy into c from s

	c := make([]string, len(s))
	copy(c, s)
	fmt.Println("copy:", c)

	// Slices support slice operator
	l := s[2:5]
	fmt.Println("slice:1", l)

	l = s[:5]
	fmt.Println("slice:2", l)

	l = s[2:]
	fmt.Println("slice:3", l)

	// We can declare and init. a variable for slice in a single line as well

	t := []string{"g", "h", "i"}
	fmt.Println("declared:", t)

	t2 := []string{"g", "h", "i" }
	if slices.Equal(t, t2){
		fmt.Println("t == t2")
	}

	// Slices can be composed in to  multi-dimensional data structures
	twoD := make([][]int, 3)
	for i := range twoD {
		innerLen := i + 1
		twoD[i] = make([]int, innerLen)
		for j := range innerLen{
			twoD[i][j] = i + j
		}
	}
	fmt.Println("2D slice:", twoD)
	// fmt.Println("flatten:", slices.flatten(twoD, ", "))
}