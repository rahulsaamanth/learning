package main

import (
	"fmt"
	"unicode/utf8"
)

func strings_runes() {
	const s = "สวัสดี" // hello in thai language

	// since strings are equivalent to []byte, this will produce the length of the raw bytes stroed within
	fmt.Println("Len: ", len(s))

	for i := 0; i < len(s); i++ {
		fmt.Printf("%x ", s[i])
	}

	fmt.Println()

	fmt.Println("Rune count:", utf8.RuneCountInString(s))

	for idx, runeVal := range s {
		fmt.Printf("%#U starts at %d \n", runeVal, idx)
	}

	fmt.Println("\nUsing DecodeRuneInString")
	for i, w := 0, 0; i < len(s); i += w {
		runeVal, width := utf8.DecodeRuneInString(s[i:])
		fmt.Printf("%#U starts at %d\n", runeVal, i)
		w = width

		examineRune(runeVal)
	}
}

func examineRune(r rune) {
	if r == 't' {
		fmt.Println("found tee")
	} else if r == 'ส' {
		fmt.Println("found so sua")
	}
}
