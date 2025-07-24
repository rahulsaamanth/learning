package main

import "fmt"

func plus(a int , b int) int {
	return a + b
}

func plusPlus(a, b, c int) int {
	return a + b + c
}

// multiple return values
func vals()(int, int) {
	return 3, 7
}

//vaiadic functions : can be called with any number of trailing arguments

func sum(nums ...int){
	fmt.Println(nums, "")
	total := 0

	for idx, num := range nums {
		fmt.Print(idx," ")
		total += num
	}
	fmt.Println("\n",total)
}