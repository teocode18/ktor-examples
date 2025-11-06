import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.html.respondHtml
import io.ktor.server.plugins.statuspages.StatusPages
import kotlinx.html.*

fun Application.configureErrors() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondHtml(HttpStatusCode.InternalServerError) {
                head {
                    title { +"Error: Die Roller" }
                }
                body {
                    h1 { +"500 Internal Server Error" }
                    p { +"$cause" }
                }
            }
        }
    }
}
