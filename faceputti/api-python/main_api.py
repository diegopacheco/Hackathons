from flask import Flask
app = Flask(__name__)

@app.route("/api/badges/<id>")
def retrieve_badge(id):
    return "http://localhost:80/gui/images/" + id + ".png"

if __name__ == "__main__":
    app.run()