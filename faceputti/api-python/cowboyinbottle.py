import datetime
import json    
from bson import json_util
from bottle import route, run
from pymongo import Connection

connection = Connection()
	
@route("/api/badges/:id")
def retrieve_badge(id):
    return "http://localhost:80/gui/images/" + id + ".png"

@route("/api/people/all")
def retrieve_people_all():
	db = connection['cowboy-database']
	collection = db['cowboy-collection']
	x = ""
	for gambero in collection.find():
	 x = x + json.dumps(gambero, default=json_util.default)
	return x
	
@route("/api/load/db")	
def load_db():
	connection.drop_database("cowboy-database")
	db = connection['cowboy-database']
	collection = db['cowboy-collection']
	user = {"name": "Jose Porto",
			"rank": "24",
			"badges": ["killer","cooker"]}
	collection.insert(user)
	user2 = {"name": "Jeferson Machado(Putotti)",
			"rank": "25",
			"badges": ["cowboy","cooker"]}
	collection.insert(user2)
	return "DONE"
	
run(host='localhost', port=8080)