package main

import "fmt"

func if_else(){
	if 7%2 == 0 {
		fmt.Println("7 is even")
	} else {
		fmt.Println("7 is odd")
	}

	if 8%4 == 0 {
		fmt.Println("8 is divisible by 4")
	}

	if num := 9; num < 0{
		fmt.Println(num, "is negative")
	} else if num < 10{
		fmt.Println(num, "has 1 digit")
	}else {
		fmt.Println(num, "has multiple digits")
	}
	// will return an error as it is not defined outside the if block
	// fmt.Println(num)

	// There is no ternary operator in Go, so you cannot do something like:
	// fmt.Println(num < 10 ? "has 1 digit" : "has multiple digits")
}