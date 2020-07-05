package com.example.data.core

import okhttp3.Interceptor
import okhttp3.Response

class HeadersInterceptor () : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val headers = request.headers()
            .newBuilder()
            .add("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
            .add("x-rapidapi-key", "c2f17b3dc2msh3fbe1fcbb9fb346p1b3fc1jsn0b0457ee9550")
            .build()
        request = request.newBuilder().headers(headers).build()
        return chain.proceed(request)
    }
}