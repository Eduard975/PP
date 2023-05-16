import subprocess

if __name__ == "__main__":
    command = input("Introduceti comanda: ")
    raw_commands = command.split("|")
    command_list = []

    for c in raw_commands:
        command_args = c.split(" ")
        command_list.append(filter(lambda c: c != "", command_args))

    prev = subprocess.run(command_list[0], stdout=subprocess.PIPE)

    for c in command_list[1:]:
        prev = subprocess.run(c, input=prev.stdout, stdout=subprocess.PIPE)

    print(f'{prev.stdout.decode("utf-8")}')
