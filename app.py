app = Flask(__name__)

# Sample data (in-memory list of books)
books = [
    {"id": 1, "title": "The Lord of the Rings", "author": "J.R.R. Tolkien"},
    {"id": 2, "title": "Pride and Prejudice", "author": "Jane Austen"},
    {"id": 3, "title": "1984", "author": "George Orwell"},
]
# Cambios desa

# Helper to find a book by ID
def find_book(book_id):
    return next((book for book in books if book["id"] == book_id), None)

# Route to get all books
@app.route("/books", methods=["GET"])
def get_books():
    return jsonify(books)

# Route to get a single book by ID
@app.route("/books/<int:book_id>", methods=["GET"])
def get_book(book_id):
    book = find_book(book_id)
    if book:
        return jsonify(book)
    return jsonify({"message": "Book not found"}), 404

# Route to add a new book
@app.route("/books", methods=["POST"])
def add_book():
    new_book = request.get_json()
    if not new_book or "title" not in new_book or "author" not in new_book:
        return jsonify({"message": "Invalid book data"}), 400

    new_book["id"] = len(books) + 1  # Simple ID generation
    books.append(new_book)
    return jsonify(new_book), 201

# Route to update an existing book
@app.route("/books/<int:book_id>", methods=["PUT"])
def update_book(book_id):
    book = find_book(book_id)
    if not book:
        return jsonify({"message": "Book not found"}), 404

    updated_data = request.get_json()
    if not updated_data:
        return jsonify({"message": "No update data provided"}), 400

    book.update(updated_data)
    return