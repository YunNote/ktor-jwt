package ktor.jwt.io.core.base

enum class ErrorCode(val detailStatus: String, val message: String) {

    SAMPLE_EXCEPTION("S400", "샘플 에러 메세지")
    ;

    fun response() = mapOf(
        "status" to detailStatus,
        "message" to message
    )
}