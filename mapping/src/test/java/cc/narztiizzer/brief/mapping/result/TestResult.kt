package cc.narztiizzer.brief.mapping.result

object TestResult {
    fun strategyResult()=  """{"uniqueID":10,"message":"My name is narztiizzer."}""".trimIndent()

    fun serializeResult() = """{"uniqueID":10,"updateDate":1540194660000}""".trimIndent()

    fun deserializeResult() = 1540194660000L
}