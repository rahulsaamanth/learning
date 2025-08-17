package main

import "testing"

func TestHello(t *testing.T){
	got := Hello("rahul")
	want := "Hello, rahul"

	if got != want{
		t.Errorf("got %q want %q", got, want)
	}
}
