package co.anbora.neurosdk.data;

import com.neurosky.connection.ConnectionStates;

/**
 * @author darwin.algarin
 */
public class SignalState {

    private int connectionStates;

    private SignalState(int connectionStates) {
        this.connectionStates = connectionStates;
    }

    public Boolean isConnectedState() {
        return ConnectionStates.STATE_CONNECTED == this.connectionStates;
    }

    public static SignalState of(int connectionStates) {
        return new SignalState(connectionStates);
    }

}
