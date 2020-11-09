package alpha;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ResultHelper {
    private Result _result;

    public ResultHelper(Result result) {
        _result = result;
    }

    public String toJson() {
        return "{}";
    }

    public boolean isEmpty() {
        return _result.isEmpty();
    }

    public List<String> families() {
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(_result.getNoVersionMap().navigableKeySet().iterator(), Spliterator.ORDERED), false)
                .map(b -> Bytes.toString(b)).collect(Collectors.toList());
    }

    public List<String> columns(String family) {
        List<String> families = families();
        if (!families.contains(family)) {
            throw new IllegalArgumentException(String.format("family %d does not exist", family));
        }
        NavigableMap<byte[], byte[]> navigableMap = _result.getNoVersionMap().get(Bytes.toBytes(family));
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(navigableMap.keySet().iterator(), Spliterator.ORDERED), false)
                .map(b -> Bytes.toString(b))
                .collect(Collectors.toList());
    }

    /**
     * prints a pretty tree of family:columns to stdout.
     */
    public void printRowTree() {
        Set<Map.Entry<byte[], NavigableMap<byte[], byte[]>>> entries = _result.getNoVersionMap().entrySet();
        for (Map.Entry<byte[], NavigableMap<byte[], byte[]>> e : entries) {
            String family = Bytes.toString(e.getKey());
            System.out.printf("family: %s %n", family);

            for (byte[] f : e.getValue().keySet()) {
                System.out.printf("\t:%s %n", Bytes.toString(f));
            }
        }
    }
}
