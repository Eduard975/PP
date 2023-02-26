fin = open("data.txt", "rt")

punctuatie_si_numere = [
    ".", ",", "?",
    "!", "-", "_",
    ":", ";", "/",
    "(", ")", "'",
    '"', "0", "1",
    "2", "3", "4",
    "5", "6", "7",
    "8", "9"]

for linie in fin:
    for caracter in punctuatie_si_numere:
        if caracter in linie:
            linie = linie.replace(caracter, "")

    linie = linie.swapcase()

    print(linie, end="")

fin.close()
