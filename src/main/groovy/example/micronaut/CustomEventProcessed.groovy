package example.micronaut

import groovy.transform.CompileStatic
import io.micronaut.core.annotation.Introspected
import io.micronaut.core.annotation.NonNull

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import java.time.Instant


@CompileStatic
@Introspected
class CustomEventProcessed {

    @NonNull
    Instant processedAt = Instant.now()

    @NotBlank
    String processedBy

    @NotNull
    Integer totalEventsProcessed

    @NotBlank
    String specialMessage
}
