from file_types import *
from text_files import *


class FileFactory():
    def factory(file_type):
        if (file_type == "HTMl"):
            return HTMLfile()
        if (file_type == "JSON"):
            return JSONfile()
        if (file_type == "ArticolTXT"):
            return ArticleText()
        if (file_type == "BlogText"):
            return BlogText()
