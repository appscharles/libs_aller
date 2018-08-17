package com.appscharles.libs.aller.listeners;

import com.appscharles.libs.aller.exceptions.AllerException;
import fi.iki.elonen.NanoHTTPD;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The type Browser authorization code listener.
 */
public class BrowserAuthorizationCodeListener extends NanoHTTPD implements IAuthorizationCodeListener{

    private String code;

    private String htmlSuccessResponse;

    private Boolean interrupt;

    private ObjectProperty<AllerException> exception;

    /**
     * Instantiates a new Browser authorization code listener.
     *
     * @param port                the port
     * @param htmlSuccessResponse the html success response
     */
    public BrowserAuthorizationCodeListener(Integer port, String htmlSuccessResponse) {
        super(port);
        this.htmlSuccessResponse = htmlSuccessResponse;
        this.exception = new SimpleObjectProperty<>();
    }

    public String waitAndGet() throws AllerException {
        this.interrupt = false;
        try {
            start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
            while (this.interrupt == false) {
                Thread.sleep(100);
                if (this.exception.getValue() != null){
                    throw this.exception.getValue();
                }
                if (this.code != null){
                    stop();
                    return code;
                }
            }
            stop();
            throw new AllerException("Interrupted listener for authorization code.");
        } catch (IOException | InterruptedException e) {
            stop();
            throw new AllerException(e);
        }
    }



    @Override
    public Response serve(IHTTPSession session) {
        Map<String, List<String>> parms = session.getParameters();
        if (parms.containsKey("code")){
            List<String> values = parms.get("code");
            this.code = values.get(0);
            return newFixedLengthResponse(Response.Status.OK, NanoHTTPD.MIME_HTML, this.htmlSuccessResponse);
        } else {
            this.exception.setValue(new AllerException("Response not contains 'code' parameter."));
            return newFixedLengthResponse(Response.Status.BAD_REQUEST, NanoHTTPD.MIME_HTML, "Response not contains 'code' parameter.");
        }

    }

    public void interrupt() {
        this.interrupt = true;
    }
}
