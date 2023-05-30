from multiprocessing.managers import BaseManager


class QueueManager(BaseManager):
    pass


if __name__ == '__main__':
    QueueManager.register('get_queue')
    manager = QueueManager(address=('localhost', 50000),
                           authkey=b'your_secret_key')
    manager.connect()
    queue = manager.get_queue()
    result = queue.get()
    result.append('Client 0: Hello!')
    queue.put(result)
