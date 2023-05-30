import os
import sys
from PyQt5.QtWidgets import QWidget, QApplication, QFileDialog
from PyQt5.uic import loadUi
from PyQt5 import QtCore
import sysv_ipc


def debug_trace(ui=None):
    from pdb import set_trace

    QtCore.pyqtRemoveInputHook()
    set_trace()
    # QtCore.pyqtRestoreInputHook()


class HTMLConverter(QWidget):
    ROOT_DIR = os.path.dirname(os.path.abspath(__file__))

    def __init__(self):
        super(HTMLConverter, self).__init__()
        ui_path = os.path.join(self.ROOT_DIR, "html_converter.ui")
        loadUi(ui_path, self)
        self.browse_btn.clicked.connect(self.browse)
        self.convert_html_btn.clicked.connect(self.convert_html)
        self.send_c_btn.clicked.connect(self.send_c)
        self.file_path = None

        self.document_title = ""
        self.document_content = []
        self.document_html = ""

    def browse(self):
        options = QFileDialog.Options()
        options |= QFileDialog.DontUseNativeDialog
        file, _ = QFileDialog.getOpenFileName(
            self,
            caption="Select file",
            filter="Text Files (*.txt)",
            directory="",
            options=options,
        )
        if file:
            self.file_path = file
            self.path_line_edit.setText(file)

            f = open(file, "r")

            title, *content = f.readlines()

            self.document_title = title
            self.document_content = content

            f.close()

    def convert_html(self):
        self.document_html = (
            "<html>\n\t<head>\n\t\t<title>"
            + self.document_title.strip()
            + "</title>\n\t</head>\n\t<body>"
        )

        for c in self.document_content:
            if len(c) >= 2:
                self.document_html += "\n\t\t<p>" + c.strip() + "</p>"

        self.document_html += "\n\t</body>\n</html>"

        self.html_result.setPlainText(self.document_html)

    def send_c(self):
        try:
            message_queue = sysv_ipc.MessageQueue(225200)
            message_queue.send(self.document_html)
        except sysv_ipc.ExistentialError:
            print("Message queue not initialized. Please run the C program first")


if __name__ == "__main__":
    app = QApplication(sys.argv)
    window = HTMLConverter()
    window.show()
    sys.exit(app.exec_())
