This application is meant to be a quick demonstration of some code with Quarkus.

Data is retrieved from ridb API, more information about it is available thanks to the following URL :

https://ridb.recreation.gov/docs

# Path ("/activities")

This endpoint shows a usage of Uni type from Mutiny. Data is retrieved from ridb API, according a reactive I/O Thread.

Deserialization is performed by custom deserializer ActivitiesDeserializer.

# Path ("/activities/special-activity")

This endpoint uses a worker Thread and takes advantage of interceptor SpecialActivityInterceptor, which intercepts the incoming request.

Some Java Reflection job is shown inside business class SpecialActivityBusiness.

# Path ("/activities/{maxId}")

This endpoint shows a usage of Multi type from Mutiny. Data is retrieved from ridb API, according a reactive I/O Thread and is streamed every second.

Deserialization is performed by custom deserializer ActivitiesDeserializer.

Usage is made of interceptor thanks to annotation, in order to make sure that the path parameter's value doesn't exceed API limitation.

# Path ("/random-filters")

This endpoint makes use of a worker Thread and shows a filtering task thanks to jakarta.enterprise.inject.Instance injecting each instance of filter.

# Exceptions handling

Exception are handled thanks to GlobalExceptionMapper class, which makes use of the builder pattern to build AppError dto according to the exception data.