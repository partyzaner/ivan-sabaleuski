package pet

import kotlinx.serialization.Required
import kotlinx.serialization.Serializable

@Serializable
data class Category(@Required val id: Int, @Required val name: String)

@Serializable
data class Tags(@Required val id: Int, @Required val name: String)

@Serializable
data class Pet(@Required val id: Int, @Required val name: String,
               @Required val category: Category,
               @Required val photoUrls: Array<String>,
               @Required val tags: Array<Tags>,
               @Required val status: String) {
}