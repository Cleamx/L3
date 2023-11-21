extends Node

signal mess_received(mess_obj)

func change_pseudo(new_pseudo : String):
	set_pseudo.rpc_id(1, new_pseudo)

@rpc("authority")
func set_pseudo(new_pseudo: String):
	pass

func send_message(mess_obg : ChatMessage):
	pass

@rpc("authority") func receive_message(mess_obj : ChatMessage):
	pass


