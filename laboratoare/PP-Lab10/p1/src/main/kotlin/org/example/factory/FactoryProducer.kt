package factory

import kotlin.system.exitProcess

class FactoryProducer {
    fun getFactory(choice: String): AbstractFactory {
        return when(choice){
            "Elite" -> EliteFactory();
            "Worker" -> HappyWorkerFactory();
            else -> exitProcess(0);
        }
    }
}