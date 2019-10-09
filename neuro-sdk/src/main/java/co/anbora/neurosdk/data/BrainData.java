package co.anbora.neurosdk.data;

import com.neurosky.connection.DataType.MindDataType;

/**
 * @author darwin.algarin
 */
public class BrainData {

    private int dataType;
    private int data;
    private Object obj;

    private BrainData(int dataType, int data, Object obj) {
        this.dataType = dataType;
        this.data = data;
        this.obj = obj;
    }

    public Boolean isRawData() {
        return MindDataType.CODE_RAW == dataType;
    }

    public int getData() {
        return data;
    }

    public static BrainData of(int dataType, int data, Object obj) {
        return new BrainData(dataType, data, obj);
    }
}
