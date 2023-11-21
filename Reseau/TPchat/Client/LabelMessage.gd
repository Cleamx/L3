class_name LabelMessage extends Label

var chat_message : ChatMessage

func set_chat_message(new_chat_mess : ChatMessage):
	chat_message = new_chat_mess
	self.text = chat_message.mess_content
