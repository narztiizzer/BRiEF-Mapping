package cc.narztiizzer.brief.mapping.model

import cc.narztiizzer.brief.mapping.annotation.SkipProperty

class StrategyModel {
    var uniqueID: Long = 10
    var message: String = "My name is narztiizzer."

    @SkipProperty
    var exception: String = "Not found."
}