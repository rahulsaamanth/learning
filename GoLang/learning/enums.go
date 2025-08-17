package main 

import "fmt"

type ServerState int

const (
	stateIdle ServerState = iota
	StateConnected
	StateError
	StateRetrying
)

var stateName = map[ServerState]string{
	StateIdle: 	"idle",
	StateConnected: "connected",
	StateError: "error",
	StateRetrying:"retrying"
}


func (ss ServerState) String() string {
	return stateName[ss]
}

func _enums(){
	ns := transition(StateIdle);
}