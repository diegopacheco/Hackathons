import datetime
import json    
from bson import json_util
from flask import Flask
from pymongo import Connection

app = Flask(__name__)

@app.route("/api/badges/<id>")
def retrieve_badge(id):
    return "http://localhost:80/gui/images/" + id + ".png"

@app.route("/api/people/all")
def retrieve_people_all():
	connection = Connection()
	db = connection['cowboy-database']
	collection = db['cowboy-collection']
	user = {"name": "Poletto", "date": datetime.datetime.utcnow()}
	collection.insert(user)
	u = collection.find_one({"name": "Poletto"})
	return json.dumps(u, default=json_util.default)
		
if __name__ == "__main__":
    app.run()