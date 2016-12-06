package pl.opms.consts;

import javax.faces.application.FacesMessage;

/**
 * Created by Piotr Borczyk on 06.12.2016.
 */
public enum MessageType {
    ERROR(FacesMessage.SEVERITY_ERROR,"Błąd"),
    INFO(FacesMessage.SEVERITY_INFO,"Komunikat"),
    WARN(FacesMessage.SEVERITY_WARN,"Ostrzeżenie"),
    FATAL(FacesMessage.SEVERITY_FATAL,"Błąd krytyczny");

    private FacesMessage.Severity severity;
    private String messageTitle;

    MessageType(FacesMessage.Severity severity,String messageTitle) {
        this.severity = severity;
        this.messageTitle = messageTitle;
    }

    public FacesMessage.Severity getSeverity() {
        return severity;
    }

    public String getMessageTitle() {
        System.out.println("IN");
        return messageTitle;
    }
}
