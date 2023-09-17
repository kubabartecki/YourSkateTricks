package pl.sk8.trickslist.error;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyErrorController implements ErrorController {

    @RequestMapping("error")
    public String handleError(HttpServletRequest request) {
        String errorMessagePrefix = "Congrats, You encountered ";
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String appendix = "some error";
        if (status != null) {
            appendix = status.toString();
        }
        return errorMessagePrefix + appendix;
    }
}
