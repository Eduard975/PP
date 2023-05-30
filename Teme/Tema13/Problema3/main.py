from functional import seq
def numere():
    numbers = seq(1, 21, 75, 39, 7, 2, 35, 3, 31, 7, 8)
    result = numbers.filter(lambda x: x >= 5).grouped(2).map(lambda y: y[0] * y[1]).sum()
    print(f'\tRezultat: {result}')

if __name__ == "__main__":
    numere()