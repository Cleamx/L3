extends Node

var my_data = {
	"pseudo": "NA",
	"pid": -1,
}

var server_info = {}
var users = {}

# Called when the node enters the scene tree for the first time.
func _ready():
	get_tree().connect("connected_to_server", self , "_on_connected_to_server")
	get_tree().connect("connection_failed", self , "_on_connection_failed")
	get_tree().connect("server_disconnected", self , " _on_disconnected_from_server ")

func join_server(ip , port , pseudo):
	var net = NetworkedMultiplayerENet.new()
	my_data["pseudo"] = pseudo
	if (net.create_client(ip, int(port)) != OK) : 
		print("Failed to create client")
		return
	get_tree ().set_network_peer(net) 
	print("Server joined!")

func send_message_test():
	var mess = "Hello"
	rpc_id(1, "message_from_client", mess)

remote func message_from_server(mess : String):
	print ("Message received from server : %s"%[mess ])

func _on_connected_to_server():
	print("Connection success !")
	var pid = get_tree ().get_network_unique_id ()
	my_data["pid"] = pid
	print("My pid is %d. Sending a test message."%[pid]) 
	send_message_test ()

func _on_connection_failed () :
	print ("The connection has failed !")

func on_disconnected_from_server():
	my_data["pid"] = -1
	print("Disconnected")
