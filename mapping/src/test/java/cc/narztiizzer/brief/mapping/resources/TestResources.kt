package cc.narztiizzer.brief.mapping.resources

import cc.narztiizzer.brief.mapping.model.ParseModel
import java.util.*

object TestResources {
    fun strategyResource(): String{
        return """
            {
              "uniqueID": 10,
              "message": "My name is narztiizzer.",
              "exception": "Not found."
            }
        """.trimIndent()
    }

    fun serializeResource(): ParseModel{
        val model = ParseModel()
        model.uniqueID = 10L
        model.updateDate = Date(1540194660000)
        return model
    }

    fun deserializeResource(): String{
        return """
            {"uniqueID":10,"updateDate":1540194660000}
        """.trimIndent()
    }
}