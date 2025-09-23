package com.events.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GlobalExceptionHandler extends DataFetcherExceptionResolverAdapter {
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        Throwable t = NestedExceptionUtils.getMostSpecificCause(ex);

        if (t instanceof ConstraintViolationException cve) {
            return GraphqlErrorBuilder.newError(env)
                    .message("Validation failed: " + cve.getMessage())
                    .errorType(graphql.ErrorType.ValidationError)
                    .build();
        }

        if (t instanceof BadRequest err) {
            return GraphqlErrorBuilder.newError().errorType(ErrorType.BAD_REQUEST).message(err.getMessage()).build();
        }

        if (t instanceof NotFound err) {
            return GraphqlErrorBuilder.newError().errorType(ErrorType.NOT_FOUND).message(err.getMessage()).build();
        }

        return GraphqlErrorBuilder.newError().errorType(ErrorType.INTERNAL_ERROR).message("Internal Server Error!").build();
    }
}
