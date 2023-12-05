extends Node

var SERVER_PORT = 3892 
var MAX_PLAYERS = 16

func _ready():
	var peer = NetworkedMultiplayerENet.new() 
	peer.create_server(SERVER_PORT, MAX_PLAYERS) 
	get_tree ().network_peer = peer
	get_tree().connect("network_peer_connected", self , "_on_network_peer_connected")
	get_tree().connect("network_peer_disconnected", self , "_on_network_peer_disconnected")

remote func message_from_client(mess):
	var pid = get_tree ().get_rpc_sender_id()
	print("Message recevied from %d: %s"%[pid , mess ])
	rpc_id(pid, "message_from_server", "Hello from server side !")
	
func _on_network_peer_connected(id : int):
	 print("New client connected : %d"%[id ])

func _on_network_peer_disconnected(id: int): 
	print (" Client disconnected : %d"%[id ])

