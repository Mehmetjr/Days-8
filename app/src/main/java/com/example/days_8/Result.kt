package com.example.days_8

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class Result {

    fun news() : List<News>{

        val arr = mutableListOf<News>()

        val url = "https://www.haberler.com/"
        val doc:Document = Jsoup.connect(url).timeout(15000).get()//15 saniye
        val elements: Elements = doc.getElementsByAttribute("data-headlinenumber")
        for (item in elements){
           // Log.d("item", item.html())
            //Log.d("item", item.toString())

            val img = item.getElementsByTag("img")

            val href = item.attr("abs:href")
            val src = img.attr("data-src")
            val title = img.attr("alt")

            if (title != "" && href != "" && src != ""){

                val news=News(title,src,href)
                arr.add(news)

            }


        }
        return arr
    }
}