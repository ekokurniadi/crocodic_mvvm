package id.ekokurniadi.myapplication.api

/**
 * [LOADING] status ketika request ke server sedang berjalan
 * [SUCCESS] status ketika request ke server telah selesai dan sukses
 * [WRONG] status ketika request ke server telah selesai dan terjadi kesalahan
 * [ERROR] status ketika request ke server dan terjadi error
 */
enum class ApiStatus {
    LOADING,
    SUCCESS,
    WRONG,
    ERROR
}