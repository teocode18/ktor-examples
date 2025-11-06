import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.html.respondHtml
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import io.ktor.server.util.getValue
import kotlinx.html.*

fun Application.configureRouting() {
    routing {
        get("/roll/d{sides}") {
            val sides: Int by call.parameters
            val number = dieRoll(sides)
            call.respondHtml(HttpStatusCode.OK) {
                head {
                    title { +"Die Roller" }
                }
                body {
                    h1 { +"d${sides} Dice Roll" }
                    p { +"Result = $number" }
                }
            }
        }
    }
}
