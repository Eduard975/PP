package ro.mike.tuiasi

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.io.File

/**
 * @param url - Uniform Resource Locator - address of an website
 * @return HTML content corresponding to the URL as a string
 */
fun testKhttpGetRequest(url: String) : String {
    val response = khttp.get(url)
    println("${response.statusCode}\t ${response.headers["Content-Type"]}")
    return response.text
}

/**
 * @param source - string specifying the source type (url, file, string)
 * @param url - string containing an URL, a path to a HTML file or an HTML string
 * @param baseURI - string used for the relative links inside of a local HTML file
 * @throws Exception - if the source is unknown
 */
fun testJsoup(source: String, url: String, baseURI: String?=null) {
    var htmlDocument: Document? = null
    htmlDocument = when(source) {
        "url" -> Jsoup.connect(url).get()
        "file" -> Jsoup.parse(File(url), "UTF-8", baseURI)
        "string" -> Jsoup.parse(url)
        else -> throw Exception("Unknown source")
    }

    val cssHeadlineSelector: String = "#khttp-http-without-the-bullshit h1"
    val cssParagraphSelector = "#khttp-http-without-the-bullshit p"
    val cssLinkSelector = "#khttp-http-without-the-bullshit > p > a"
    println(htmlDocument.title())
    println(htmlDocument.select(cssHeadlineSelector).text())
    val paragraphs: Elements = htmlDocument.select(cssParagraphSelector)
    for (paragraph in paragraphs) {
        println("\t${paragraph.text()}")
    }
    val links = htmlDocument.select(cssLinkSelector)
    println("-".repeat(100))
    for (link in links) {
        println("${link.text()}\n\t${link.absUrl("href")}")
    }
}

fun main() {
    val projectPath: String = System.getProperty("user.dir")
    val htmlPath: String = "${projectPath}/src/main/resources/example.html"
    val url: String = "https://khttp.readthedocs.io/en/latest/"
    val htmlContent: String = testKhttpGetRequest(url)
    println("*".repeat(100))
    testJsoup("url", url)
    println("*".repeat(100))
    testJsoup("file", htmlPath, "mike.tuiasi.ro")
    println("*".repeat(100))
    testJsoup("string", htmlContent)
}