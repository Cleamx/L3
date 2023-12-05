extends Node2D

onready var input_ip = $Panel/VBoxContainer/ip
onready var input_port = $Panel/VBoxContainer/port
onready var input_pseudo = $Panel/VBoxContainer/pseudo

func _ready():
	print ("ConnectionBox ready !")

func _on_Button_button_down():
	var ip_addr = input_ip.text
	var port = input_port.text
	var nick = input_pseudo.text
