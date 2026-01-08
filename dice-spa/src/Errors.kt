// Custom page for 404 errors

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.pebble.respondTemplate
import io.ktor.server.plugins.statuspages.StatusPages

fun Application.configureErrorHandling() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound) { call, _ ->
            call.respondTemplate("not-found.peb", mapOf())
        }
    }
}
