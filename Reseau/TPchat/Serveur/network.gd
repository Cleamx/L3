extends Node

signal server_created 
signal join_success
signal join_fail
signal player_list_changed

func _ready(): 
	create_server ()

var server_info = {
	used_port = 35555,
	max_players = 50
}

func create_server () :
# Initialize the networking system
	var net = ENetMultiplayerPeer.new()
# Try to create the server
	if (net.create_server(server_info.used_port, server_info.max_players) != OK):
		print("Failed to create server")
		return
	
	print("Server created on port %d !"%[server_info.used_port])
	server_created.emit ()
	multiplayer.multiplayer_peer = net
	get_multiplayer().peer_connected.connect(_on_player_connected)
	get_multiplayer().peer_disconnected.connect( _on_player_disconnected )

@rpc("any_peer") func test_rpc(arg1 : int, arg2: String):
	var pid = multiplayer.get_remote_sender_id()
	print("user %d has sent a test_rpc" %[pid])
	test_rpc_answer.rpc_id(pid, "OK")

@rpc("authority") func test_rpc_answer(mess : String):
	pass

func _on_player_connected(id : int):
	print("New player connected : "[id])

func _on_player_disconnected(id : int):
	print("Player %d as been desconnected"[id])

