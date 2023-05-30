package factory

import chain.CEOHandler
import chain.ExecutiveHandler
import chain.Handler
import chain.ManagerHandler
import kotlin.system.exitProcess

class EliteFactory: AbstractFactory() {
    override fun getHandler(handler: String): Handler {
        return when(handler){
            "CEO" -> CEOHandler();
            "Executive" -> ExecutiveHandler();
            "Manager" -> ManagerHandler();
            else -> exitProcess(0);
        }
    }
}