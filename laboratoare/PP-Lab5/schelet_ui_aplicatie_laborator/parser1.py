import os
import tkinter as tk
from multiprocessing import Process, Queue


def is_prime(n):
    for i in range(2, n):
        if (n % i) == 0:
            return False
    return True


class Parser:
    ROOT_DIR = os.path.dirname(os.path.abspath(__file__))
    A = None
    B = None

    def __init__(self, gui):
        self.result = "Result"
        self.gui = gui
        self.gui.title('Exemplul 1 cu Tkinter')

        self.gui.geometry("600x200")

        self.integer_list_lbl = tk.Label(master=self.gui,
                                         text="List of integers:")
       # self.todo0_lbl = tk.Label(master=self.gui, text="TODO_0: Add a Text field to display the result")
       # self.todo1_lbl = tk.Label(master=self.gui, text="TODO_1: Add a button for each operation")

        self.add_list_btn = tk.Button(master=self.gui,
                                      text="Add list",
                                      command=self.add_list)

        self.integer_list_text = tk.Text(self.gui, width=50, height=1)
        self.integer_list_text.insert(tk.END, str(list(range(1, 16)))[1:-1])

        self.add_odd_num_btn = tk.Button(master=self.gui,
                                         text="Show only Odd Numbers",
                                         command=self.odd_numbers)

        self.add_prime_num_btn = tk.Button(master=self.gui,
                                           text="Show only Prime Numbers",
                                           command=self.prime_numbers)

        self.add_sum_num_btn = tk.Button(master=self.gui,
                                         text="Show Sum of Numbers",
                                         command=self.sum_numbers)

        self.Result = tk.Label(
            master=self.gui, text="Result: " + self.result)

        # alignment on the grid
        self.integer_list_lbl.grid(row=0, column=0)
        self.Result.grid(row=1, column=1)

        self.add_odd_num_btn.grid(row=2, column=1)
        self.add_prime_num_btn.grid(row=3, column=1)
        self.add_sum_num_btn.grid(row=4, column=1)

        self.integer_list_text.grid(row=0, column=1)
        self.add_list_btn.grid(row=0, column=2)

        self.gui.mainloop()

    def add_list(self):
        result = self.integer_list_text.get("1.0", tk.END)
        result = result.strip().replace(' ', '')
        result = [int(item) for item in result.split(',')]
        self.result = result
        print(result)

    def odd_numbers(self):
        result = self.integer_list_text.get("1.0", tk.END)
        result = result.strip().replace(' ', '')
        result = [int(item) for item in result.split(',')]
        for i in result:
            if (i % 2 != 1):
                result.remove(i)
        self.result = result
        print(result)

    def prime_numbers(self):
        result = self.integer_list_text.get("1.0", tk.END)
        result = result.strip().replace(' ', '')
        result = [int(item) for item in result.split(',')]
        for i in result:
            if (is_prime(i) != 1):
                result.remove(i)
        self.result = result
        print(result)

    def sum_numbers(self):
        sum = 0
        result = self.integer_list_text.get("1.0", tk.END)
        result = result.strip().replace(' ', '')
        result = [int(item) for item in result.split(',')]
        for i in result:
            sum += i
        self.result = result

        print(sum)


if __name__ == '__main__':
    root = tk.Tk()
    root.title('Exemplul 1 cu Tkinter')
    app = Parser(root)
    root.mainloop()
