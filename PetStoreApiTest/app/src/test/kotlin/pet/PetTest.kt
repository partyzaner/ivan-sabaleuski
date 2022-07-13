package pet

import BaseTest
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.apache.http.HttpStatus
import org.hamcrest.Matchers.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.*

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class PetTest : BaseTest() {

    companion object {
        const val ID = 111
        const val NAME = "testDog"
        const val UPDATED_NAME = "testDog1"
        const val CATEGORY = "Dogs"
        const val TAG = "string"
        const val STATUS = "available"
    }

    @Test
    @Order(1)
    fun post_pet() {
        Given {
            spec(requestSpec)
            val pet = Pet(ID, NAME, Category(1, CATEGORY), arrayOf("photo"),
                                    arrayOf(Tags(0, TAG)), STATUS)
            body(Json.encodeToString(pet))
        } When {
            post("pet")
        } Then {
            statusCode(HttpStatus.SC_OK)
            body("name", equalTo(NAME))
        }
    }

    @Test
    @Order(2)
    fun get_pet_by_id() {
        Given {
            spec(requestSpec)
        } When {
            get("pet/$ID")
        } Then {
            statusCode(HttpStatus.SC_OK)
            body("name", equalTo(NAME))
        }
    }

    @Test
    @Order(3)
    fun get_pets_by_tags() {
        Given {
            spec(requestSpec)
        } When {
            get("pet/findByTags?tags=$TAG")
        } Then {
            statusCode(HttpStatus.SC_OK)
            body("name", hasItem(NAME))
        }
    }

    @Test
    @Order(4)
    fun get_pets_by_status() {
        Given {
            spec(requestSpec)
        } When {
            get("pet/findByStatus?status=$STATUS")
        } Then {
            statusCode(HttpStatus.SC_OK)
            body("name", hasItem(NAME))
        }
    }

    @Test
    @Order(5)
    fun upload_image() {
//        TODO: requestImageSpec for application/octet-stream
//        Given {
//            spec(requestImageSpec)
//        } When {
//            body("imgUrl")
//            post("pet/$ID/uploadImage")
//        } Then {
//            statusCode(HttpStatus.SC_OK)
//            body("name", hasItem(11))
//        }
    }

    @Test
    @Order(6)
    fun update_pet_put() {
        Given {
            spec(requestSpec)
            val pet = Pet(ID, UPDATED_NAME, Category(1, CATEGORY), arrayOf("photo"),
                arrayOf(Tags(0, TAG)), STATUS)
            body(Json.encodeToString(pet))
        } When {
            put("pet")
        } Then {
            statusCode(HttpStatus.SC_OK)
            body("name", equalTo(UPDATED_NAME))
        }
    }

    @Test
    @Order(7)
    fun update_pet_post() {
        Given {
            spec(requestSpec)
            val pet = Pet(ID, UPDATED_NAME, Category(1, CATEGORY), arrayOf("photo"),
                arrayOf(Tags(0, TAG)), STATUS)
            body(Json.encodeToString(pet))
        } When {
            post("pet")
        } Then {
            statusCode(HttpStatus.SC_OK)
            body("name", equalTo(UPDATED_NAME))
        }
    }

    @Test
    @Order(8)
    fun delete_pet() {
        Given {
            spec(requestSpec)
        } When {
            delete("pet/$ID")
        } Then {
            statusCode(HttpStatus.SC_OK)
        }
    }
}
