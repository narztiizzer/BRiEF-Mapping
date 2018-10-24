package cc.narztiizzer.brief.mapping.deserializer

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.util.*

class DateDeserializer: JsonDeserializer<Date> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Date {
        var jsonValue = json!!.asJsonPrimitive.asLong

        if("$jsonValue".toCharArray().size < 13){
            var tempValue = "$jsonValue"
            while(tempValue.toCharArray().size < 13){
                tempValue = ""
            }
            jsonValue = tempValue.toLong()
        }

        return Date(jsonValue)
    }
}