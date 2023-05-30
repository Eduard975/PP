import time
import math
from datetime import datetime


class Accepts(object):
    def __init__(self, data_type):
        self.data_type = data_type

    def __call__(self, f):
        def wrapped_f(*args, **kwargs):
            for arg in args:
                if not isinstance(arg, self.data_type):
                    raise Exception(
                        "Invalid parameter {} for function {}".format(
                            arg, f.__name__))
            for key in kwargs:
                if not isinstance(kwargs[key], self.data_type):
                    raise Exception(
                        "Invalid parameter {} for function {}".format(
                            kwargs[key], f.__name__))
            return f(*args, **kwargs)

        return wrapped_f


class Returns(object):
    def __init__(self, data_type):
        self.data_type = data_type

    def __call__(self, f):
        def wrapped_f(*args, **kwargs):
            output = f(*args, **kwargs)
            if not isinstance(output, self.data_type):
                raise Exception(
                    "The function {} returned a {} type instead of {}".format(
                        f.__name__, type(output), self.data_type))
            return output

        return wrapped_f


class TimeIt(object):
    def __init__(self, f):
        self.f = f
        self.__name__ = f.__name__

    def __call__(self, *args, **kwargs):
        begin = time.time()
        output = self.f(*args)
        end = time.time()
        print("Total time taken in : ", self.f.__name__, end - begin)
        return output


class LogIt(object):
    def __init__(self, f):
        self.f = f
        self.__name__ = f.__name__

    def __call__(self, *args, **kwargs):
        timestamp = datetime.now().timestamp()
        output = self.f(*args)
        with open('log_decorator.txt', 'a') as fp:
            fp.write("[{}]: function '{}' returned {}\n".format(
                timestamp, self.f.__name__, output))
        return output


@Accepts(int)
@Returns(int)
@LogIt
@TimeIt
def factorial(num):
    time.sleep(1)
    return math.factorial(num)


if __name__ == '__main__':
    for i in range(3, 11):
        print("factorial({})={}".format(i, factorial(i)))
