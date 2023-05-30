import kotlin.math.log

class SyslogRecord (
    var timeStamp:String = "",
    var hostName:String = "",
    var appName:String = "",
    var PID:Double = 0,
    var logEntry:String = "",
){
    public fun print(){
        println("$timeStamp $hostName $appName[$PID]: $logEntry");
    }

    public fun formatString(log:String){
        val splitString = log.split("\\s".toRegex()).filter { it.isNotEmpty() }.toMutableList()
        timeStamp = splitString[0] + " " + splitString[1] + " " + splitString[2];
        hostName = splitString[3];
        appName = splitString[4].filter { !it.isDigit() && (it != '[' && it != ']' && it != ':' && it != '.')};

        if(appName != "kernel")
            PID = splitString[4].filter { it.isDigit()}.toDouble();
        else
            PID = splitString[5].filter { (it != '[' && it != ']' && it != ' ') }.toDouble();

        for(i in 0..4){
            splitString.removeAt(0);
        }

        logEntry = splitString.joinToString(" ").substring(0);
    }
}