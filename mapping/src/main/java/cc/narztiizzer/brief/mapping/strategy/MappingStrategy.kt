package cc.narztiizzer.brief.mapping.strategy

import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import cc.narztiizzer.brief.mapping.annotation.SkipProperty

class MappingStrategy: ExclusionStrategy {
    override fun shouldSkipClass(clazz: Class<*>?): Boolean {
        return false
    }

    override fun shouldSkipField(f: FieldAttributes?): Boolean {
        return f!!.getAnnotation(SkipProperty::class.java) != null
    }
}