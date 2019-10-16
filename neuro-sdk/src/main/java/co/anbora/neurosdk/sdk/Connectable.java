package co.anbora.neurosdk.sdk;

/**
 * @author darwin.algarin
 */
public interface Connectable {

    void connect();

    boolean isConnected();

    void disconnect();
}
