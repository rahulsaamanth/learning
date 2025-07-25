package main

import "fmt"

func main() {
	fmt.Println("Hello, World!")
	
	fmt.Println("------------- values -------------")
	values()
	
	fmt.Println("------------- variables -------------")
	variables()

	fmt.Println("------------- constants -------------")
	constants()

	fmt.Println("------------- for loop -------------")
	forLoop()

	fmt.Println("------------- if/else -------------")
	if_else()

	fmt.Println("------------- switch -------------")
	_switch()

	fmt.Println("------------- arrays -------------")
	arrays()

	fmt.Println("------------- slices -------------")
	_slices()
	
	fmt.Println("------------- maps -------------")
	_maps()

	fmt.Println("------------- functions -------------")
	fmt.Println(plus(1,2))
	fmt.Println(plusPlus(1,2,3))
	
	fmt.Println("------------- multiple return values -------------")
	fmt.Println(vals())
	sum(1,2,3,4,5,6,7,8,9)

	fmt.Println("------------- closures -------------")
	nextInt := intSeq()
	fmt.Println(nextInt())
	fmt.Println(nextInt())
	fmt.Println(nextInt())
	nextInts := intSeq()
	fmt.Println(nextInts())

	fmt.Println("------------- recursion -------------")
	fmt.Println(fact(5))
}
