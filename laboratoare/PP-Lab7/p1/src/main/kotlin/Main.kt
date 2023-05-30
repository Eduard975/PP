import java.io.File

fun main(args: Array<String>) {
    println("Hello World!")

    val test = SyslogRecord("23:00:02", "Mihai", "fifa 3", 254, "a fost aici");


    val fileLines = File("src/main/kotlin/syslog").readLines();

    val sysLogs = ArrayList<SyslogRecord>();

    var i:Int = 0;
    for(line in fileLines){
        sysLogs.add(SyslogRecord());
        sysLogs[i].formatString(line);
        print(i);
        i += 1;
    }

    for(log in sysLogs){
        log.print();
    }
}