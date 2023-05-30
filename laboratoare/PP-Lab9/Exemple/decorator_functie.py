import time
import math
from datetime import datetime


def time_it(func):
    def wrapper(*args, **kwargs):
        begin = time.time()
        output = func(*args, **kwargs)
        end = time.time()
        print("Total time taken in : ", func.__name__, end - begin)
        return output

    return wrapper


def log_it(func):
    def wrapper(*args, **kwargs):
        timestamp = datetime.now().timestamp()
        output = func(*args, **kwargs)
        with open('log_decorator.txt', 'a') as fp:
            fp.write("[{}]: function '{}' returned {}\n".format(
                timestamp, func.__name__, output))
        return output

    return wrapper


def accepts(data_type):
    def wrap(f):
        def wrapped_f(*args, **kwargs):
            for arg in args:
                if not isinstance(arg, data_type):
                    raise Exception(
                        "Invalid parameter {} for function {}".format(
                            arg, f.__name__))
            for key in kwargs:
                if not isinstance(kwargs[key], data_type):
                    raise Exception(
                        "Invalid parameter {} for function {}".format(
                            kwargs[key], f.__name__))
            return f(*args, **kwargs)

        return wrapped_f

    return wrap


def returns(data_type):
    def wrap(f):
        def wrapped_f(*args, **kwargs):
            output = f(*args, **kwargs)
            if not isinstance(output, data_type):
                raise Exception(
                    "The function {} returned a {} type instead of {}".format(
                        f.__name__, type(output), data_type))
            return output

        return wrapped_f

    return wrap


@accepts(int)
@returns(int)
@log_it
@time_it
def factorial(num):
    time.sleep(1)
    return math.factorial(num)


if __name__ == '__main__':
    for i in range(3, 11):
        print("factorial({})={}".format(i, factorial(i)))
