package example.micronaut

import com.amazonaws.services.lambda.runtime.events.SQSEvent
import io.micronaut.core.annotation.Introspected
import io.micronaut.function.aws.MicronautRequestHandler

@Introspected
class SQSMessageProcessor extends MicronautRequestHandler<SQSEvent, CustomEventProcessed> {

    @Override
    CustomEventProcessed execute(SQSEvent input) {

        CustomEventProcessed customEventProcessed = new CustomEventProcessed()

        String customMessage = input.records*.body.join(' ____ ')

        customEventProcessed.with {
            specialMessage = "something new"
            processedBy = "me"
            specialMessage = "Here's everything joined together...\n${customMessage}"
            totalEventsProcessed = input.records.size()
        }

        customEventProcessed
    }


}