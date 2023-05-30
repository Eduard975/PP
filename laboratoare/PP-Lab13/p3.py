from typing import Any, TypeVar, List, Tuple

T = TypeVar("T")


def zip(l1: List[T], l2: List[T]) -> List[Tuple[T, T]]:
    if len(l1) != len(l2):
        raise RuntimeError("Marimi diferite la liste")

    result = map(lambda x: (x[1], l2[x[0]]), enumerate(l1))

    return list(result)


a = list("225")
b = list("200")

c = zip(a, b)

print(c)