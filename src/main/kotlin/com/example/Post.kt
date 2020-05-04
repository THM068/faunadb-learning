package com.example
import com.faunadb.client.query.Expr
import com.faunadb.client.query.Language.Obj
import com.faunadb.client.query.Language.Value

data class Post(val title: String, val summary: String) {

    fun toFauna(): Expr {
        return  Obj(
                "data", Obj(
                "title", Value(this.title),
                "summary", Value(this.summary))
        )
    }
}