import threading
import multiprocessing
from concurrent.futures import ThreadPoolExecutor
import time
import numpy as np

v = np.random.randint(5, size=(10))

print(v)


def is_not_prime(n):
    if n < 2:
        return False
    i = 2
    while i*i <= n:
        if n % i == 0:
            return True
        i += 1
    return False


def countdown():
    global v
    v_copy = v.copy()

    # print(v_copy)

    v_copy.sort()

    v = v_copy.copy()
    # print(v_filtred)


def prime_filter(vec):
    v_filtred = list(filter(lambda numfil: is_not_prime(numfil), vec))
    vec = v_filtred


def ver_1(vec):
    l = int(len(vec)/2)
    v1 = vec[:l]
    v2 = vec[l:]
    thread_1 = threading.Thread(target=prime_filter(v1))
    thread_2 = threading.Thread(target=prime_filter(v2))
    thread_1.start()
    thread_2.start()
    thread_1.join()
    thread_2.join()

    vec = [*v1, *v2]
    print("\nAici ------>")
    print(v1)
    print(v2)
    print(vec)


def ver_2(vec):
    l = int(len(vec)/2)
    prime_filter(vec[:l])
    prime_filter(vec[l:])


def ver_3(vec):
    l = int(len(vec)/2)
    process_1 = multiprocessing.Process(target=prime_filter(vec[:l]))
    process_2 = multiprocessing.Process(target=prime_filter(vec[l:]))
    process_1.start()
    process_2.start()
    process_1.join()
    process_2.join()


def ver_4(vec):
    l = int(len(vec)/2)
    with ThreadPoolExecutor(max_workers=2) as executor:
        future = executor.submit(prime_filter(vec[:l]))
        future = executor.submit(prime_filter(vec[l:]))


if __name__ == '__main__':
    v1 = v.copy()
    v2 = v.copy()
    v3 = v.copy()
    v4 = v.copy()

    start = time.time()
    ver_1(v1)
    end = time.time()
    print(v1)
    print("\n Timp executie pseudoparalelism cu GIL")

    print(end - start)
    start = time.time()
    ver_2(v2)
    end = time.time()
    print(v2)
    print("\n Timp executie secvential")

    print(end - start)
    start = time.time()
    ver_3(v3)
    end = time.time()
    print(v3)
    print("\n Timp executie paralela cu multiprocessing")

    print(end - start)
    start = time.time()
    ver_4(v4)
    end = time.time()
    print(v4)
    print("\n Timp executie paralela cu concurrent.futures")
    print(end - start)
