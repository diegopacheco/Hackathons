from flask import Flask
app = Flask(__name__)

@app.route("/api/badges/<id>")
def retrieve_badge(id):
    return "Hello World! fro ID: " id

if __name__ == "__main__":
    app.run()