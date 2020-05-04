package com.example
import com.faunadb.client.query.Expr
import com.faunadb.client.query.Language.Obj
import com.faunadb.client.query.Language.Value
import com.faunadb.client.types.FaunaConstructor
import com.faunadb.client.types.FaunaField


data class Post @FaunaConstructor constructor(@FaunaField("title") val title: String, @FaunaField("summary")val summary: String) {

    fun toFauna(): Expr {
        return  Obj(
                "data", Obj(
                "title", Value(this.title),
                "summary", Value(this.summary))
        )
    }
}