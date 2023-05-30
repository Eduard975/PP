from file_types import text_File


class ArticleText(text_File):
    def __init__(self):
        super().__init__("Article")

    def print_text(self):
        print("                  " + self.private_title + "                  ")
        print("                          by " + self.private_author)
        for i in self.private_paragraphs:
            print(i)


class BlogText(text_File):
    def __init__(self):
        super().__init__("Blog")

    def print_text(self):
        print(self.private_title)
        for i in self.private_paragraphs:
            print(self.private_paragraphs)
        print("Written by " + self.private_author)
