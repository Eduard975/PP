import os
import sqlite3
from collections import namedtuple

Book = namedtuple("Book", ["id", "title", "author", "publisher"])


class DatabaseManager:
    CREATE_CMD = '''CREATE TABLE IF NOT EXISTS books (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    title VARCHAR(100) UNIQUE,
                    author VARCHAR(100) NOT NULL,
                    publisher VARCHAR(100))'''
    INSERT_CMD = '''INSERT INTO books(title, author, publisher)
                    VALUES (?, ?, ?)'''
    SELECT_BY_AUTHOR_CMD = '''SELECT * FROM books WHERE author=?'''
    SELECT_BY_ID_CMD = '''SELECT * FROM books WHERE id = ?'''

    UPDATE_CMD = '''UPDATE books SET title=?, author=?, publisher=?
                    WHERE id=?'''
    DELETE_ALL_CMD = '''DELETE FROM books'''

    CURRENT_PATH = os.path.dirname(os.path.abspath(__file__))
    DATABASE_PATH = os.path.join(CURRENT_PATH, 'books.db')

    def __init__(self):
        with sqlite3.connect(self.DATABASE_PATH) as db:
            cursor = db.cursor()
            cursor.execute(self.CREATE_CMD)
            cursor.close()

    def insert(self, book):
        with sqlite3.connect(self.DATABASE_PATH) as db:
            cursor = db.cursor()
            cursor.execute(self.INSERT_CMD,
                           (book.title, book.author, book.publisher))
            cursor.close()

    def select_by_author(self, author):
        with sqlite3.connect(self.DATABASE_PATH) as db:
            cursor = db.cursor()
            cursor.execute(self.SELECT_BY_AUTHOR_CMD, (author,))
            rows = cursor.fetchall()
            cursor.close()
            return [Book(*row) for row in rows]

    def select_by_id(self, book_id):
        with sqlite3.connect(self.DATABASE_PATH) as db:
            cursor = db.cursor()
            cursor.execute(self.SELECT_BY_ID_CMD, (book_id,))
            row = cursor.fetchone()
            cursor.close()
            if row:
                return Book(*row)
            return None

    def update(self, book):
        with sqlite3.connect(self.DATABASE_PATH) as db:
            cursor = db.cursor()
            cursor.execute(self.UPDATE_CMD,
                           (book.title, book.author,
                            book.publisher, book.id))
            cursor.close()

    def delete_all(self):
        with sqlite3.connect(self.DATABASE_PATH) as db:
            cursor = db.cursor()
            cursor.execute(self.DELETE_ALL_CMD)
            cursor.close()


database_manager = DatabaseManager()

if __name__ == '__main__':
    book0 = Book(id=None,
                 title="Insula Misterioasa",
                 author="Jules Verne",
                 publisher="Adevarul")
    book1 = Book(id=None,
                 title="Steaua Sudului",
                 author="Jules Verne",
                 publisher="Adevarul")
    book2 = Book(id=None,
                 title="Pupaza din tei",
                 author="Ion Creanga",
                 publisher="Corint")
    # INSERT
    for book in [book0, book1, book2]:
        database_manager.insert(book)

    # SELECT
    print(database_manager.select_by_author("Jules Verne"))
    print(database_manager.select_by_id(2))

    # UPDATE
    book1 = Book(id=2,
                 title="STEAUA SUDULUI",
                 author="JULES VERNE",
                 publisher="Art")
    database_manager.update(book1)

    # DELETE
    # database_manager.delete_all()
