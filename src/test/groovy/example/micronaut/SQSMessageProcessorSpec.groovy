package example.micronaut

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class SQSMessageProcessorSpec extends Specification {

    @AutoCleanup
    @Shared
    SQSMessageProcessor sqsMessageProcessor = new SQSMessageProcessor()


    void "test Handler"() {
        given:

        List<String> messageBodies = ['first message', 'second message', 'third message']

        SQSEvent inputEvent = new SQSEvent()

        inputEvent.with {
            records = messageBodies.collect {
                new SQSEvent.SQSMessage(
                        body: it
                )
            }
        }

        when:
        CustomEventProcessed eventProcessed = sqsMessageProcessor.execute(inputEvent)

        then: 'book name matches the one supplied'
        eventProcessed.totalEventsProcessed == messageBodies.size()
    }
}
