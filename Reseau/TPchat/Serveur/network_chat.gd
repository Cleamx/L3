extends Node

var user = {}

@rpc("authority")
func set_pseudo(new_pseudo: String):
	pass

func send_message(mess_obg : ChatMessage):
	pass

@rpc("authority") func receive_message(mess_obj : ChatMessage):
	pass
