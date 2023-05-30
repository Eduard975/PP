from file_factory import *
import file_types
import text_files


def main():
    A = FileFactory.factory("ArticolTXT")
    B = FileFactory.factory("BlogText")
    A.read_file_from_stdin()
    A.print_text()

    B.read_file_from_stdin()
    B.print_text()


main()
