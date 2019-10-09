package co.anbora.neurosdk.processor.wave;

import co.anbora.neurosdk.data.BrainData;

/**
 * @author darwin.algarin
 */
public class RawDataProcessor implements INeuralWaveProcessor {

    private short raw_data[] = {0};
    private int raw_data_index= 0;
    private WaveCallback callback;

    public RawDataProcessor(WaveCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onDataReceived(BrainData brainData) {
        if (brainData.isRawData()) {
            raw_data[raw_data_index++] = (short)brainData.getData();
            if (raw_data_index == 512) {
                this.callback.onWaveDetected(raw_data);
                raw_data_index = 0;
            }
        }
    }
}
