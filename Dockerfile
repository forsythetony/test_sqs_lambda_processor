FROM public.ecr.aws/lambda/java:11

COPY build/classes/groovy/main ${LAMBDA_TASK_ROOT}
COPY build/dependencies/* ${LAMBDA_TASK_ROOT}/lib/

CMD ["example.micronaut.SQSMessageProcessor::execute"]