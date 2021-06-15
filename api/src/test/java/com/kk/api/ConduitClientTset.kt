package com.kk.api

import com.kk.api.models.entites.UserCrede
import com.kk.api.models.request.SignUpRequest
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.random.Random

class ConduitClientTset {

    private val conduitcliets = ConduitClients()

    @Test
    fun `GET articles`() {
        runBlocking {
        val articles = conduitcliets.publicApi.getarticles()
        assertNotNull(articles.body()?.articles)
        }
        //  Assert.assertEquals(4, 2 + 2)
    }


    @Test
    fun `GET articles by Authors or faviourtite or tag`() {
        runBlocking {
            val articles = conduitcliets.publicApi.getarticles(author ="444")
            assertNotNull(articles.body()?.articles)
        }
        //  Assert.assertEquals(4, 2 + 2)
    }

    @Test
    fun `Post User Signup `(){
        val userCread = UserCrede(
            email = "kk${Random.nextInt(999,9999)}@kk.com",
            password = "kk@kkkk${Random.nextInt(999,9999)}",
            username = "mykkUsername"

        )

        runBlocking {
            val resp = conduitcliets.publicApi.signupuser(SignUpRequest(userCread))
            assertEquals(userCread.username ,resp.body()?.user?.username)
        }
    }

}