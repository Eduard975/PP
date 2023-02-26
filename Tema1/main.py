fin = open("data.txt", "rt")

inlocuitori = [
    ".", ",", "?",
    "!", "-", "_",
    ":", ";", "/",
    "(", ")", "'", '"']

print("Textul fara punctuatie: ")
for linie in fin:
    for caracter in inlocuitori:
        if caracter in linie:
            linie = linie.replace(caracter, "")

    print(linie, end="")

fin.close()
