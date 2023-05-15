import asyncio


async def sum(name, queue):
    n = await queue.get()

    await asyncio.sleep(1)

    result = (n*(n+1))/2

    queue.task_done()

    print(f'Task {name}: Pentru n = {n} suma este {result}')


async def main():
    queue = asyncio.Queue()

    queue.put_nowait(6)
    queue.put_nowait(678)
    queue.put_nowait(9800)
    queue.put_nowait(323)


    await asyncio.gather(
        sum("1", queue),
        sum("2", queue),
        sum("3", queue),
        sum("4", queue),
    )

if __name__ == '__main__':
    asyncio.run(main())
