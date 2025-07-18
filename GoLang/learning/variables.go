package main

import "fmt"
import "reflect"

func variables(){
	var a = "init val"
	fmt.Println(a)

	var b, c  = 1, 2
	fmt.Println(b, c)
	fmt.Println("b:", reflect.TypeOf(b), "c:", reflect.TypeOf(c))

	var d = true
	fmt.Println(d)

	var e int
	fmt.Println(e)
	
	// shorthand for declaring and initializing a variable
	f:= "apple"
	fmt.Println(f)
}