import math


class FactorialIterator:
    def __init__(self, maximum=0):
        self.maximum = maximum

    def __iter__(self):
        self.n = 2
        return self

    def __next__(self):
        if self.n <= self.maximum:
            result = math.factorial(self.n)
            self.n += 1
            return result
        else:
            raise StopIteration


if __name__ == '__main__':
    iterator = iter("car")
    print(next(iterator))
    print(next(iterator))
    print(next(iterator), "\n")

    factorial_iterator = iter(FactorialIterator(10))
    for item in factorial_iterator:
        print(item)
