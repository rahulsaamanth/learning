package main

func fact(n int ) int {
	if n == 0 {
		return 1
	}

	return n * fact(n-1)
}