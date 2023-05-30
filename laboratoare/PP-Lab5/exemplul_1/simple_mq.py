from multiprocessing import Process, Queue
# from queue import Queue
from collections import deque


def task0(message_queue):
    result = message_queue.get()
    result.append('task1: Hello World! - sent by task0')
    result.append('Process0 exists')
    message_queue.put(result)


def task1(message_queue):
    all_messages = message_queue.get()
    try:
        message = all_messages.popleft()
        if 'task1:' in message:
            print(message.split(':')[1].strip())
        else:
            print(message)
        all_messages.append('Process1 exits')
        message_queue.put(all_messages)
    except IndexError:
        print("Task1: Empty message queue")


if __name__ == '__main__':
    message_queue = Queue()
    message_queue.put(deque([]))

    process0 = Process(target=task0, args=(message_queue,))
    process1 = Process(target=task1, args=(message_queue,))

    process0.start()
    process1.start()

    process0.join()
    process1.join()

    print(message_queue.get())
