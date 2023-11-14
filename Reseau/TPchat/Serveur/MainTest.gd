extends Control

@onready var chat_window : ChatWindow = $Chat_Window


func _on_chat_window_message_sent(mess : String):
	#Create the ChatMessage instance
	var chat_message = ChatMessage.new(mess)
	chat_window.add_message(chat_message)
