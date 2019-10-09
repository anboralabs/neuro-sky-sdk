package co.anbora.neurosdk.processor.wave;

import co.anbora.neurosdk.data.BrainData;

/**
 * @author darwin.algarin
 */
public interface INeuralWaveProcessor {

    void onDataReceived(BrainData brainData);

}
