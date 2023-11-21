class_name ChatMessage extends Object

static var nb_message = 0
var id : int
#var mess_content : String
var timestamp : float

func _init(mess_content : String):
	id = nb_message
	nb_message += 1
	self.mess_content = mess_content
	timestamp = Time.get_unix_time_from_system()
