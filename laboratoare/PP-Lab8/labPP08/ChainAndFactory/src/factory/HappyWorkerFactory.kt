package factory

import chain.*
import kotlin.system.exitProcess

class HappyWorkerFactory: AbstractFactory() {
    override fun getHandler(handler: String): Handler {
        return when(handler){
            "Worker" -> HappyWorkerHandler();
            else -> exitProcess(0);
        }
    }
}