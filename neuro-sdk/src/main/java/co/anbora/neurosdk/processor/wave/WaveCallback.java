package co.anbora.neurosdk.processor.wave;

/**
 * @author darwin.algarin
 */
public interface WaveCallback {

    void onWaveDetected(short[] data);

}
