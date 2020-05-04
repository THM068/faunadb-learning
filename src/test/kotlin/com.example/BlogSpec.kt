package com.example

import com.beust.klaxon.Klaxon
import com.fasterxml.jackson.databind.ObjectMapper
import com.faunadb.client.FaunaClient
import com.faunadb.client.query.Language.*
import org.junit.jupiter.api.Test

class BlogSpec {
    val objectMapper = ObjectMapper()
    var serverClient = FaunaClient.builder()
            .withSecret("fnADq_1T0DACAH0Ut_hKsEOWXwMyQSRbaxLsFZCp\n")
            .build()

    @Test
    fun `Can save a blog post`() {
        val post = Post("Pepsi causing corona", "It has been discovered that pepsi is causing corona virus")
        serverClient.query(
                Create(
                        Collection(Value("post")),
                        post.toFauna()
                )
        ).get()
    }

    @Test
    fun `Can retrieve some posts`() {
        val doc  = serverClient.query(Get(Ref(Collection("post"),Value("264593116921594370"))))
                .get()
        println(doc.at("data").toString())
        val data = doc.at("data").to(Post::class.java)

        println(data?.get()?.summary)
    }
}
