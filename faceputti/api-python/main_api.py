from flask import Flask
app = Flask(__name__)

@app.route("/api/badges/<id>")
def retrieve_badge(id):
    return "http://localhost:80/gui/images/" + id + ".png"

@app.route("/api/people/all")
def retrieve_people_all():
    return """
			[
			  {
				"id": "1",
				"name": "Jose Porto",
				"rank": "24",
				"badges": ["killer","cooker"]
			  },
			  {
				"id": "2",
				"name": "Jeferson Machado(Putotti)",
				"rank": "25",
				"badges": ["cooker","cowboy"]
			  }
			]
			"""
		
if __name__ == "__main__":
    app.run()