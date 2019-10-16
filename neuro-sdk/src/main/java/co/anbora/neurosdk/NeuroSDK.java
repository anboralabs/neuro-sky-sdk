package co.anbora.neurosdk;

import android.bluetooth.BluetoothAdapter;

import com.neurosky.connection.TgStreamHandler;
import com.neurosky.connection.TgStreamReader;

import java.util.ArrayList;
import java.util.Collection;

import co.anbora.neurosdk.exception.BluetoothNotEnabledException;
import co.anbora.neurosdk.handler.NeuroSkyHandler;
import co.anbora.neurosdk.processor.state.INeuralStateProcessor;
import co.anbora.neurosdk.processor.wave.INeuralWaveProcessor;
import co.anbora.neurosdk.sdk.Connectable;
import co.anbora.neurosdk.sdk.Debuggeable;
import co.anbora.neurosdk.validation.DefaultPreconditions;
import co.anbora.neurosdk.validation.Preconditions;

/**
 * @author darwin.algarin
 */
public final class NeuroSDK implements Connectable, Debuggeable {

    private TgStreamHandler handler;
    private TgStreamReader reader;
    private Preconditions preconditions;

    private NeuroSDK(Collection<INeuralWaveProcessor> waveProcessors,
                     Collection<INeuralStateProcessor> stateProcessors,
                     Preconditions preconditions) {

        if (preconditions.isBluetoothAdapterInitialized()) {
            this.preconditions = preconditions;
            handler = new NeuroSkyHandler(waveProcessors, stateProcessors);
            reader = new TgStreamReader(BluetoothAdapter.getDefaultAdapter(), handler);
        }
    }

    @Override
    public void connect() {
        if (!preconditions.isBluetoothEnabled()) {
            throw new BluetoothNotEnabledException();
        }
        reader.connectAndStart();
    }

    @Override
    public boolean isConnected() {
        return reader.isBTConnected();
    }

    @Override
    public void disconnect() {
        reader.stop();
        reader.close();
    }

    @Override
    public void startConsoleLog() {
        reader.startLog();
    }

    @Override
    public void stopConsoleLog() {
        reader.stopLog();
    }

    public static final class Builder {

        private Collection<INeuralWaveProcessor> waveProcessors = new ArrayList<>();
        private Collection<INeuralStateProcessor> stateProcessors = new ArrayList<>();

        public Builder addWaveProcessor(INeuralWaveProcessor waveProcessor) {
            this.waveProcessors.add(waveProcessor);
            return this;
        }

        public Builder addStateProcessor(INeuralStateProcessor stateProcessor) {
            this.stateProcessors.add(stateProcessor);
            return this;
        }


        public NeuroSDK build() {
            return new NeuroSDK(waveProcessors,
                    stateProcessors,
                    new DefaultPreconditions());
        }
    }
}
