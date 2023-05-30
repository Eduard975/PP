import copy
from file import File


class text_File(File):
    def __init__(self, template):
        super().__init__()
        self.private_template = template

    def print_text():
        pass

    def clone(self):
        return copy.copy(self)


class JSONfile(File):
    def print_JSON():
        pass


class HTMLfile(File):
    def print_HTML():
        pass
