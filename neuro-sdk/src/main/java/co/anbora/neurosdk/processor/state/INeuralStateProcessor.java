package co.anbora.neurosdk.processor.state;

import co.anbora.neurosdk.data.SignalState;

/**
 * @author darwin.algarin
 */
public interface INeuralStateProcessor {

    void onStatesChanged(SignalState signalState);
}
