package pl.opms.fe.controller;

import pl.opms.consts.MessageType;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by Piotr Borczyk on 15.11.2016.
 */
public abstract class AbstractController implements Serializable {

    public abstract void init();

    protected void sendMessage(String message, MessageType messageType) {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(messageType.getSeverity(),messageType.getMessageTitle(),  message) );

    }

    protected void sendMessage(String message) {
        sendMessage(message,MessageType.INFO);
    }
}
