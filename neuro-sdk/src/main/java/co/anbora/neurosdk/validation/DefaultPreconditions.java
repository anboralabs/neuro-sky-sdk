package co.anbora.neurosdk.validation;

import android.bluetooth.BluetoothAdapter;

/**
 * @author darwin.algarin
 */
public class DefaultPreconditions implements Preconditions {
    @Override
    public boolean isBluetoothAdapterInitialized() {
        return isBluetoothAdapterInitialized(BluetoothAdapter.getDefaultAdapter());
    }

    @Override
    public boolean isBluetoothAdapterInitialized(BluetoothAdapter bluetoothAdapter) {
        return bluetoothAdapter != null;
    }

    @Override
    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled(BluetoothAdapter.getDefaultAdapter());
    }

    @Override
    public boolean isBluetoothEnabled(BluetoothAdapter bluetoothAdapter) {
        return (bluetoothAdapter != null && bluetoothAdapter.isEnabled());
    }
}
