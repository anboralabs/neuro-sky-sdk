package co.anbora.neurosdk.handler;

import com.neurosky.connection.TgStreamHandler;

import java.util.Collection;

import co.anbora.neurosdk.data.BrainData;
import co.anbora.neurosdk.data.SignalState;
import co.anbora.neurosdk.processor.state.INeuralStateProcessor;
import co.anbora.neurosdk.processor.wave.INeuralWaveProcessor;

/**
 * @author darwin.algarin
 */
public class NeuroSkyHandler implements TgStreamHandler {

    private Collection<INeuralWaveProcessor> waveProcessors;
    private Collection<INeuralStateProcessor> stateProcessors;

    public NeuroSkyHandler(Collection<INeuralWaveProcessor> waveProcessors,
                           Collection<INeuralStateProcessor> stateProcessors){
        this.waveProcessors = waveProcessors;
        this.stateProcessors = stateProcessors;
    }

    @Override
    public void onDataReceived(int dataType, int data, Object obj) {
        for (INeuralWaveProcessor waveProcessor: waveProcessors) {
            waveProcessor.onDataReceived(BrainData.of(dataType, data, obj));
        }
    }

    @Override
    public void onStatesChanged(int connectionStates) {
        for (INeuralStateProcessor stateProcessor: stateProcessors) {
            stateProcessor.onStatesChanged(SignalState.of(connectionStates));
        }
    }

    @Override
    public void onChecksumFail(byte[] bytes, int i, int i1) {

    }

    @Override
    public void onRecordFail(int i) {

    }
}
