import subprocess

if __name__ == "__main__":
    command = input("Introduceti comanda: ")
    command_list = []

    for c in command.split("|"):
        command_list.append(filter(lambda c: c != "", c.split(" ")))

    prev = subprocess.run(command_list[0], stdout=subprocess.PIPE)

    for c in command_list[1:]:
        prev = subprocess.run(c, input=prev.stdout, stdout=subprocess.PIPE)

    print(f'{prev.stdout.decode("utf-8")}')
