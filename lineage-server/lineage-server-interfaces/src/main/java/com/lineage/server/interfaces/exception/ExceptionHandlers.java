package com.lineage.server.interfaces.exception;

import com.lineage.server.interfaces.result.Result;
import com.lineage.server.interfaces.result.ResultCode;
import com.lineage.server.interfaces.result.ResultMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * refers to @see <a href="https://github.com/apache/shenyu">https://github.com/apache/shenyu</a>. thanks
 *
 * @description: ExceptionHandlers
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/1 4:31 PM
 */
@ResponseBody
@ControllerAdvice
public class ExceptionHandlers {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlers.class);

    @ExceptionHandler(Exception.class)
    protected Result<Boolean> handleExceptionHandler(final Exception exception) {
        LOG.error(exception.getMessage(), exception);
        return Result.error(exception.getMessage());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    protected Result<Boolean> handleDuplicateKeyException(final DuplicateKeyException exception) {
        LOG.error("duplicate key exception ", exception);
        return Result.error(ResultMessage.UNIQUE_INDEX_CONFLICT_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    protected Result<Boolean> handleNullPointException(final NullPointerException exception) {
        LOG.error("null pointer exception ", exception);
        return Result.error(ResultCode.NOT_FOUND_EXCEPTION, ResultMessage.NOT_FOUND_EXCEPTION);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected Result<Boolean> handleHttpRequestMethodNotSupportedException(final HttpRequestMethodNotSupportedException e) {
        LOG.warn("http request method not supported", e);
        StringBuilder sb = new StringBuilder();
        sb.append(e.getMethod());
        sb.append(
                " method is not supported for this request. Supported methods are ");
        Objects.requireNonNull(e.getSupportedHttpMethods()).forEach(t -> sb.append(t).append(" "));
        return Result.error(sb.toString());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected Result<Boolean> handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        LOG.warn("method argument not valid", e);
        BindingResult bindingResult = e.getBindingResult();
        String errorMsg = bindingResult.getFieldErrors().stream()
                .map(f -> f.getField().concat(": ").concat(Optional.ofNullable(f.getDefaultMessage()).orElse("")))
                .collect(Collectors.joining("| "));
        return Result.error(String.format("Request error! invalid argument [%s]", errorMsg));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected Result<Boolean> handleMissingServletRequestParameterException(final MissingServletRequestParameterException e) {
        LOG.warn("missing servlet request parameter", e);
        return Result.error(String.format("%s parameter is missing", e.getParameterName()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected Result<Boolean> handleMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException e) {
        LOG.warn("method argument type mismatch", e);
        return Result.error(String.format("%s should be of type %s", e.getName(), Objects.requireNonNull(e.getRequiredType()).getName()));
    }
}
