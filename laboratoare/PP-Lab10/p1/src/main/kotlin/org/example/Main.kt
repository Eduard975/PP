import factory.FactoryProducer

suspend fun main(args: Array<String>) {
    // se creeaza 1xFactoryProducer, 1xEliteFactory, 1xHappyWorkerFactory
    val producer = FactoryProducer();
    val Elite = producer.getFactory("Elite");
    val Worker = producer.getFactory("Worker");

    // crearea instantelor (prin intermediul celor 2 fabrici):
    val ceo1 = Elite.getHandler("CEO");
    val ceo2 = Elite.getHandler("CEO");

    val exec1 = Elite.getHandler("Executive");
    val exec2 = Elite.getHandler("Executive");

    val man1 = Elite.getHandler("Manager");
    val man2 = Elite.getHandler("Manager");

    val worker1 = Worker.getHandler("Worker");
    val worker2 = Worker.getHandler("Worker");

    // se construieste lantul (se verifica intai diagrama de obiecte si se realizeaza legaturile)
    ceo1.setNext(exec1, ceo2);
    ceo2.setNext(ceo1, exec2);

    exec1.setNext(man1, exec2);
    exec2.setNext(exec1, man2);

    man1.setNext(worker1, man2);
    man2.setNext(man1, worker2);

    worker1.setNext(null, worker2);
    worker2.setNext(worker1, null);

    // se executa lantul utilizand atat mesaje de prioritate diferita, cat si directii diferite in lant
    ceo1.handleRequest("Right", "1:Misto");
    exec2.handleRequest("Up", "4:Naspa");
    man1.handleRequest("Right", "3:Asa");
    man2.handleRequest("Up", "4: Haide");
    exec1.handleRequest("Right", "3:mesajul");
}