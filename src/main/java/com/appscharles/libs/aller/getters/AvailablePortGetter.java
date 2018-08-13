package com.appscharles.libs.aller.getters;

import com.appscharles.libs.aller.exceptions.AllerException;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * The type Available port getter.
 */
public class AvailablePortGetter {

    /**
     * Get integer.
     *
     * @param ports the ports
     * @return the integer
     * @throws AllerException the aller exception
     */
    public static Integer get(Integer ... ports) throws AllerException {
        for (int i = 0; i < ports.length ; i++) {
            try(ServerSocket socket = new ServerSocket(ports[i])) {
                socket.close();
                return ports[i];
            } catch (IOException e) {
                continue;
            }
        }
        throw new AllerException("Available port is not found");
    }
}
