import org.jsoup.Jsoup

data class general_attributes(
    val title: String,
    val link: String,
    val description: String,
    val pubDate: String
)

fun main() {
    val doc = Jsoup.connect("http://rss.cnn.com/rss/edition.rss").get();
    val rssFeed = arrayListOf<general_attributes>();


    rssFeed.add(0, general_attributes(doc.select("channel title").eq(0).text(),
        doc.select("channel link").eq(0).text(),
        doc.select("channel description").eq(0).text(),
        doc.select("channel pubDate").eq(0).text(),
    ))

    print(rssFeed[0].title + "\t" + rssFeed[0].link + "\n");

    var i = 1;

    while(doc.select("item").eq(i).isNotEmpty()){
        rssFeed.add(i, general_attributes(doc.select("item title").eq(i).text(),
                                          doc.select("item link").eq(i).text(),
                                          doc.select("item description").eq(i).text(),
                                          doc.select("item pubDate").eq(i).text(),
                                         ))

        print(rssFeed[i].title + "\t" + rssFeed[i].link + "\n");

        i++;
    }







}

