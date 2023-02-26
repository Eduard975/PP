fin = open("data.txt", "rt")

inlocuitori = [
    ".", ",", "?",
    "!", "-", "_",
    ":", ";", "/",
    "(", ")", "'", '"']

for linie in fin:
    for caracter in inlocuitori:
        if caracter in linie:
            linie = linie.replace(caracter, "")
    print(linie, end="")

fin.close()
