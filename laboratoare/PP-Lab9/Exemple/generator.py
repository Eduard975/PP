import math


def factorial_generator(maximum):
    for i in range(2, maximum):
        yield math.factorial(i)


if __name__ == '__main__':
    generator = factorial_generator(10)
    for item in generator:
        print(item)
