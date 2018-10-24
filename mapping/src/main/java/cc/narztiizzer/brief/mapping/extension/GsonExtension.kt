package cc.narztiizzer.brief.mapping.extension

import com.google.gson.*
import com.google.gson.reflect.TypeToken
import cc.narztiizzer.brief.mapping.deserializer.DateDeserializer
import cc.narztiizzer.brief.mapping.serializer.DateSerializer
import cc.narztiizzer.brief.mapping.strategy.MappingStrategy
import java.util.*

inline fun <reified T> Gson.deserialize(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)
inline fun <reified T> Gson.serialize(instance: T) = this.toJson(instance, object: TypeToken<T>() {}.type)

inline fun <reified T> GsonBuilder.registerDeserializer(deserializer: JsonDeserializer<T>) = this.registerTypeAdapter(T::class.java, deserializer)
inline fun <reified T> GsonBuilder.registerSerializer(serializer: JsonSerializer<T>) = this.registerTypeAdapter(T::class.java, serializer)
inline fun <reified T> GsonBuilder.registerInstanceCreator(creator: InstanceCreator<T>) = this.registerTypeAdapter(T::class.java, creator)
inline fun <reified T> GsonBuilder.registerTypeAdapter(adapter: TypeAdapter<T>) = this.registerTypeAdapter(T::class.java, adapter)

fun GsonBuilder.buildDefault() = this.serializeNulls().
        registerTypeAdapter(Date::class.java, DateSerializer()).
        registerTypeAdapter(Date::class.java, DateDeserializer()).
        setExclusionStrategies(MappingStrategy()).
        create()!!