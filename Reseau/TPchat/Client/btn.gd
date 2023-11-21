extends Button

@onready var ip : LineEdit = $Panel/VBoxContainer/LineEdit
@onready var port : LineEdit = $Panel/VBoxContainer/LineEdit2
@onready var pseudo : LineEdit = $Panel/VBoxContainer/LineEdit3

# Called when the node enters the scene tree for the first time.
func _ready():
	pass # Replace with function body.


# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(delta):
	pass

func _on_btn_pressed():
	Network.join_server(ip.text, int(port.text), pseudo.text)


func _on_pressed():
	Network.join_server(ip.text, int(port.text), pseudo.text)
