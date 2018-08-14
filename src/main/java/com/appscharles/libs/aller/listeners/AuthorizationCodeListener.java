package com.appscharles.libs.aller.listeners;

import com.appscharles.libs.aller.exceptions.AllerException;
import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The type Authorization code listener.
 */
public class AuthorizationCodeListener extends NanoHTTPD implements IAuthorizationCodeListener{

    private long listenerTimeout;

    private String code;

    private String htmlSuccessResponse;

    private String htmlFailedResponse;

    private Boolean interrupt;

    /**
     * Instantiates a new Authorization code listener.
     *
     * @param port            the port
     * @param listenerTimeout the listener timeout
     */
    public AuthorizationCodeListener(Integer port, long listenerTimeout, String htmlSuccessResponse, String htmlFailedResponse) {
        super(port);
        this.htmlSuccessResponse = htmlSuccessResponse;
        this.htmlFailedResponse = htmlFailedResponse;
        this.listenerTimeout = listenerTimeout;
    }

    /**
     * Wait and get string.
     *
     * @return the string
     * @throws AllerException the aller exception
     */
    public String waitAndGet() throws AllerException {
        this.interrupt = false;
        try {
            start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
            long timeout = System.currentTimeMillis() + this.listenerTimeout;
            while (System.currentTimeMillis() < timeout) {
                if (this.interrupt){
                    stop();
                    throw new AllerException("Interrupted listener for authorization code.");
                }
                Thread.sleep(100);
                if (this.code != null){
                    stop();
                    Thread.sleep(1000);
                    return code;
                }
            }
            stop();
            throw new AllerException("Timeout listener for authorization code.");
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
            return newFixedLengthResponse(Response.Status.BAD_REQUEST, NanoHTTPD.MIME_HTML, this.htmlFailedResponse);
        }

    }

    public void interrupt() {
        this.interrupt = true;
    }
}
