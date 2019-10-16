package co.anbora.neurosdk.validation;

import android.bluetooth.BluetoothAdapter;

/**
 * @author darwin.algarin
 */
public interface Preconditions {

    boolean isBluetoothAdapterInitialized();

    boolean isBluetoothAdapterInitialized(BluetoothAdapter bluetoothAdapter);

    boolean isBluetoothEnabled();

    boolean isBluetoothEnabled(BluetoothAdapter bluetoothAdapter);
}
