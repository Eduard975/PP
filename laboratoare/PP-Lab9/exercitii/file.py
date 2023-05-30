from abc import ABC


class File(ABC):
    def __init__(self):
        self.private_title = "title"
        self.private_author = "author"
        self.private_paragraphs = []

    def read_file_from_stdin(self):
        f = open("test.txt", "r")
        temp = f.read()
        temp = temp.splitlines()
        self.private_title = temp.pop(0)
        self.private_author = temp.pop(0)
        for i in temp:
            self.private_paragraphs.append(i)
