package pl.opms.fe.controller;

import pl.opms.fe.state.AbstractState;

import java.io.Serializable;

/**
 * Created by Piotr Borczyk on 15.11.2016.
 */
public abstract class AbstractController<T extends AbstractState> implements Serializable {
    public abstract void init(T state);

}
