package falsigram.exceptions;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RequestMapping
@RestController
@ControllerAdvice
    public class Exceptions extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RequestNotFound.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    SimpleErrorMessage handleException(RequestNotFound exception){
        log.debug("Request not found {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Bad request","Error 400");
    }

    @ExceptionHandler({UsernameNotFoundException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    SimpleErrorMessage handleException(UsernameNotFoundException exception){
        log.debug("Username not found {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Unauthorized","Error 401");
    }

    @ExceptionHandler({PaymentNotFound.class})
    @ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
    @ResponseBody
    SimpleErrorMessage handleException(PaymentNotFound exception){
        log.debug("Payment required to continue {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Payment required","Error 402");
    }

    @ExceptionHandler({Forbidden.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    SimpleErrorMessage handleException(Forbidden exception){
        log.debug("Access refused {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Forbidden","Error 403");
    }

    @ExceptionHandler({EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    SimpleErrorMessage handleException(EntityNotFoundException exception){
        log.debug("Entity not found {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Not found","Error 404");
    }

    @ExceptionHandler({MethodNotAllowed.class})
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    SimpleErrorMessage handleException(MethodNotAllowed exception){
        log.debug("Request not supported {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Method not allowed","Error 405");
    }

    @ExceptionHandler({NotAccepteable.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    SimpleErrorMessage handleException(NotAccepteable exception){
        log.debug("Request not valid {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Not acceptable","Error 406");
    }

    @ExceptionHandler({ProxyAuthenticationRequired.class})
    @ResponseStatus(HttpStatus.PROXY_AUTHENTICATION_REQUIRED)
    @ResponseBody
    SimpleErrorMessage handleException(ProxyAuthenticationRequired exception){
        log.debug("Proxy not found {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Proxy authetication required","Error 407");
    }

    @ExceptionHandler({RequestTimeout.class})
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    @ResponseBody
    SimpleErrorMessage handleException(RequestTimeout exception){
        log.debug("Connexion timeout with server {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Request timeout","Error 408");
    }

    @ExceptionHandler({Conflict.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    SimpleErrorMessage handleException(Conflict exception){
        log.debug("Request send conflict with other(s) {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Conflict","Error 409");
    }

    @ExceptionHandler({Gone.class})
    @ResponseStatus(HttpStatus.GONE)
    @ResponseBody
    SimpleErrorMessage handleException(Gone exception){
        log.debug("Entity permanently erased {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Gone","Error 410");
    }

    @ExceptionHandler({LengthRequired.class})
    @ResponseStatus(HttpStatus.LENGTH_REQUIRED)
    @ResponseBody
    SimpleErrorMessage handleException(LengthRequired exception){
        log.debug("Length not found {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Length required","Error 411");
    }

    @ExceptionHandler({PreconditionFailed.class})
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ResponseBody
    SimpleErrorMessage handleException(PreconditionFailed exception){
        log.debug("Server not ready for client {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Precondition failed","Error 412");
    }

    @ExceptionHandler({PayloadTooLarge.class})
    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
    @ResponseBody
    SimpleErrorMessage handleException(PayloadTooLarge exception){
        log.debug("Request out of range {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Payload too large","Error 413");
    }

    @ExceptionHandler({URITooLong.class})
    @ResponseStatus(HttpStatus.URI_TOO_LONG)
    @ResponseBody
    SimpleErrorMessage handleException(URITooLong exception){
        log.debug("URI out of range {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("URI too long","Error 414");
    }

    @ExceptionHandler({UnsupportedMediaType.class})
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ResponseBody
    SimpleErrorMessage handleException(UnsupportedMediaType exception){
        log.debug("Unsupported type of media {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Unsupported media type","Error 415");
    }

    @ExceptionHandler({RangeNotSatisfiable.class})
    @ResponseStatus(HttpStatus.RANGE_NOT_SATISFIABLE)
    @ResponseBody
    SimpleErrorMessage handleException(RangeNotSatisfiable exception){
        log.debug("Entity out of range {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Range not satisfiable","Error 416");
    }

    @ExceptionHandler({ExpectationFailed.class})
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    @ResponseBody
    SimpleErrorMessage handleException(ExpectationFailed exception){
        log.debug("Server failed to carry out request(s) {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Expectation failed","Error 417");
    }

    @ExceptionHandler({IAmATeapot.class})
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    @ResponseBody
    SimpleErrorMessage handleException(IAmATeapot exception){
        log.debug("This server is a fuck*ng teapot, seriously {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("I'm a  T E A P O T","Error 418");
    }

    @ExceptionHandler({MisdirectedRequest.class})
    @ResponseStatus(HttpStatus.MISDIREQUED_REQUEST)
    @ResponseBody
    SimpleErrorMessage handleException(MisdirectedRequest exception){
        log.debug("Request failed to give answer {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Misdirected request","Error 421");
    }

    @ExceptionHandler({UnprocessableEntity.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    SimpleErrorMessage handleException(UnprocessableEntity exception){
        log.debug("Request failed because of semantical(s) error(s) {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Unprocessable entity","Error 422");
    }

    @ExceptionHandler({Locked.class})
    @ResponseStatus(HttpStatus.LOCKED)
    @ResponseBody
    SimpleErrorMessage handleException(Locked exception){
        log.debug("Entity locked {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Locked","Error 423");
    }

    @ExceptionHandler({FailedDependency.class})
    @ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
    @ResponseBody
    SimpleErrorMessage handleException(FailedDependency exception){
        log.debug("Request failed because of anterior request {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Failed dependency","Error 424");
    }

    @ExceptionHandler({TooEarly.class})
    @ResponseStatus(HttpStatus.TOO_EARLY)
    @ResponseBody
    SimpleErrorMessage handleException(TooEarly exception){
        log.debug("Request ignored because of may be replay {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Too early","Error 425");
    }

    @ExceptionHandler({UpgradeRequired.class})
    @ResponseStatus(HttpStatus.UPGRADE_REQUIRED)
    @ResponseBody
    SimpleErrorMessage handleException(UpgradeRequired exception){
        log.debug("Request may be accepted with other protocol(s) {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Upgrade required","Error 426");
    }

    @ExceptionHandler({PreconditionRequired.class})
    @ResponseStatus(HttpStatus.PRECONDITION_REQUIRED)
    @ResponseBody
    SimpleErrorMessage handleException(PreconditionRequired exception){
        log.debug("Request may be accepted with conditional(s) {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Precondition required","Error 428");
    }

    @ExceptionHandler({TooMaynRequests.class})
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    @ResponseBody
    SimpleErrorMessage handleException(TooMaynRequests exception){
        log.debug("Too many requests arrived {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Too many requests","Error 429");
    }

    @ExceptionHandler({RequestHeaderFieldsTooLarge.class})
    @ResponseStatus(HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE)
    @ResponseBody
    SimpleErrorMessage handleException(RequestHeaderFieldsTooLarge exception){
        log.debug("Request header fields too large for server {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Request header fields too large","Error 431");
    }

    @ExceptionHandler({UnavailableForLegalReasons.class})
    @ResponseStatus(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS)
    @ResponseBody
    SimpleErrorMessage handleException(UnavailableForLegalReasons exception){
        log.debug("Entity permanently erased by government {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Unavailable for legal reasons","Error 451");
    }










    @ExceptionHandler({InternalServerError.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    SimpleErrorMessage handleException(InternalServerError exception){
        log.debug("Server don't know what to do {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Internal server error","Error 500");
    }

    @ExceptionHandler({NotImplemented.class})
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ResponseBody
    SimpleErrorMessage handleException(NotImplemented exception){
        log.debug("Request can't be processed {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Not implemented","Error 501");
    }

    @ExceptionHandler({BadGateway.class})
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ResponseBody
    SimpleErrorMessage handleException(BadGateway exception){
        log.debug("Request waited invalid {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Bad gateway","Error 502");
    }

    @ExceptionHandler({ServiceUnavailable.class})
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ResponseBody
    SimpleErrorMessage handleException(ServiceUnavailable exception){
        log.debug("Server may be overloaded {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Service unavailable","Error 503");
    }

    @ExceptionHandler({GatewayTimeout.class})
    @ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
    @ResponseBody
    SimpleErrorMessage handleException(GatewayTimeout exception){
        log.debug("Server can't have answers in time {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Gateway timeout","Error 504");
    }

    @ExceptionHandler({HTTPVersionNotSupported.class})
    @ResponseStatus(HttpStatus.HTTP_VERSION_NOT_SUPPORTED)
    @ResponseBody
    SimpleErrorMessage handleException(HTTPVersionNotSupported exception){
        log.debug("Server can't take in charge this version of HTTP {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("HTTP version not supported","Error 505");
    }

    @ExceptionHandler({VariantAlsoNegotiates.class})
    @ResponseStatus(HttpStatus.VARIANT_ALSO_NEGOTIATES)
    @ResponseBody
    SimpleErrorMessage handleException(VariantAlsoNegotiates exception){
        log.debug("Result of request can't be in its construction {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Variant also negotiates","Error 506");
    }

    @ExceptionHandler({InsufficientStorage.class})
    @ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
    @ResponseBody
    SimpleErrorMessage handleException(InsufficientStorage exception){
        log.debug("Entity can't be a part of the request {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Insufficient storage","Error 507");
    }

    @ExceptionHandler({LoopDetected.class})
    @ResponseStatus(HttpStatus.LOOP_DETECTED)
    @ResponseBody
    SimpleErrorMessage handleException(LoopDetected exception){
        log.debug("Request resulted in a loop {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Loop detected","Error 508");
    }

    @ExceptionHandler({NotExtended.class})
    @ResponseStatus(HttpStatus.NOT_EXTENDED)
    @ResponseBody
    SimpleErrorMessage handleException(NotExtended exception){
        log.debug("Some extended must be in here {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Not extended","Error 510");
    }

    @ExceptionHandler({NetworkAuthenticationRequired.class})
    @ResponseStatus(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED)
    @ResponseBody
    SimpleErrorMessage handleException(NetworkAuthenticationRequired exception){
        log.debug("Client must be identified {}",exception.getMessage());
        log.trace(exception.getMessage(),exception);
        return new SimpleErrorMessage("Network authentication required","Error 511");
    }
}