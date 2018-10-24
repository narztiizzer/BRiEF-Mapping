package cc.narztiizzer.brief.mapping

import com.google.gson.GsonBuilder
import org.junit.Assert.*
import org.junit.Test
import cc.narztiizzer.brief.mapping.deserializer.DateDeserializer
import cc.narztiizzer.brief.mapping.extension.buildDefault
import cc.narztiizzer.brief.mapping.extension.deserialize
import cc.narztiizzer.brief.mapping.extension.registerSerializer
import cc.narztiizzer.brief.mapping.extension.registerDeserializer
import cc.narztiizzer.brief.mapping.extension.serialize
import cc.narztiizzer.brief.mapping.model.ParseDataModel
import cc.narztiizzer.brief.mapping.model.ParseModel
import cc.narztiizzer.brief.mapping.model.StrategyModel
import cc.narztiizzer.brief.mapping.resources.TestResources
import cc.narztiizzer.brief.mapping.result.TestResult
import cc.narztiizzer.brief.mapping.serializer.DateSerializer
import cc.narztiizzer.brief.mapping.strategy.MappingStrategy

class MappingTest {
    @Test
    fun createInstance() {
        assertNotNull(GsonBuilder().buildDefault())
    }

    @Test
    fun testSerializer() {
        val builder = GsonBuilder().
                setExclusionStrategies(MappingStrategy()).
                registerSerializer(DateSerializer()).
                registerDeserializer(DateDeserializer())

        assertEquals(TestResult.serializeResult(),
                builder.create().serialize(TestResources.serializeResource()))
    }

    @Test
    fun testDeserializer() {
        val builder = GsonBuilder().
                setExclusionStrategies(MappingStrategy()).
                registerSerializer(DateSerializer()).
                registerDeserializer(DateDeserializer())

        assertEquals(TestResult.deserializeResult(),
                builder.create().deserialize<ParseModel>(TestResources.deserializeResource()).updateDate!!.time)
    }

    @Test
    fun testDataModelDeserializer() {
        val builder = GsonBuilder().
                setExclusionStrategies(MappingStrategy()).
                registerSerializer(DateSerializer()).
                registerDeserializer(DateDeserializer())

        val model = builder.create().deserialize<ParseDataModel>(TestResources.deserializeResource())

        assertEquals(TestResult.deserializeResult(),
                model.updateDate!!.time)
    }

    @Test
    fun testStrategy() {
        assertEquals(TestResult.strategyResult(),
                GsonBuilder().buildDefault().serialize(StrategyModel()))
    }
}
