extends Node

signal join_success
signal join_fail
signal player_added(pid , pseudo)
signal player_removed(pinfo)
signal player_list_changed 
signal disconnected(cause) 
signal kicked(pid ,reason)

var server_info = {
	used_port = 35555,
	max_players = 50
}

var player_info = {
	pseudo = "",
	id = 0
}

func _ready():
	multiplayer.multiplayer_peer = null
	
func join_server(ip, port, pseudo):
	if multiplayer.multiplayer_peer != null : 
		print ("A connection already exists ") 
		return
		
	var multiplayer_peer = ENetMultiplayerPeer.new() 
	player_info["pseudo"] = pseudo
	
	var error = multiplayer_peer.create_client(ip, port) 
	if (error != OK) :
		print("Failed to create client") 
		join_fail.emit()
		end_connection()
		return
	print("Client created")

	multiplayer.multiplayer_peer = multiplayer_peer

	get_multiplayer().connected_to_server.connect(_on_connected_to_server) 
	get_multiplayer().connection_failed.connect( _on_connection_failed ) 
	get_multiplayer().server_disconnected.connect( _on_disconnected_from_server)

func end_connection():
	multiplayer.multiplayer_peer = null
	player_info.pseudo = ""
	player_info.id = 0

func call_test_rpc():
	test_rpc.rpc_id(1, 55, "Hello")

@rpc("any_peer") func test_rpc(arg1 : int, arg2 : String):
	pass

@rpc("authority") func test_rpc_answer(mess: String):
	print("Server answer to test_rpc: " + mess)

func _on_connected_to_server():
	pass

func _on_disconnected_():
	pass

func _on_connection_failed():
	pass

func _on_disconnected_from_server():
	pass
