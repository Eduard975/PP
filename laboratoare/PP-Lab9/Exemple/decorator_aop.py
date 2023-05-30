import types


def decorator_cu_argumente(before, after, replacement=None):
    def wrap(f):
        def wrapped_f(*args, **kwargs):
            if isinstance(before, types.FunctionType):
                before()  # execute before function
            if replacement and isinstance(replacement, types.FunctionType):
                output = replacement(*args, **kwargs)
            else:
                output = f(*args, **kwargs)
            if isinstance(after, types.FunctionType):
                after()  # execute after function
            return output
        return wrapped_f
    return wrap


def before():
    print("Before")


def after():
    print("After")


def replacement(*args, **kwargs):
    print("Replacement")
    return "replaced"


@decorator_cu_argumente(before=before, after=after, replacement=replacement)
def func0(name, question):
    print("func0")
    return f"Hello {name}, {question}"


@decorator_cu_argumente(before=before, after=after)
def func1(name):
    print("func1")
    return f"Hello {name}"


if __name__ == '__main__':
    print("Returned:", func0("Ion Popescu", "how are you?"))
    print("Returned:", func1("Ion Popescu"))
