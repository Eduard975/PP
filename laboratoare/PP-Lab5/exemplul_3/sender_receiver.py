import sysv_ipc


def send_message(message_queue, message):
    message_queue.send(message)


def receive_messages(message_queue):
    for item in message_queue.receive():
        if type(item) == bytes:
            print("received: {}".format(item.decode()))


if __name__ == '__main__':
    try:
        # put the key (integer) as parameter (in this case: -1)
        message_queue = sysv_ipc.MessageQueue(-1)
        send_message(message_queue, "Python says: Hello!")
        receive_messages(message_queue)
    except sysv_ipc.ExistentialError:
        print("Message queue not initialized. Please run the C program first")
