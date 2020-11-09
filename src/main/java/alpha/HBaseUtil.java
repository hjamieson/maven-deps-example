package alpha;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * client-side access code for HBase.
 */
public class HBaseUtil {
    public static ResultHelper getRow(String table, String rowkey) throws IOException {
        TableName tableName = TableName.valueOf(table);

        try (Connection con = ConnectionFactory.createConnection(); Table hTable = con.getTable(tableName);) {
            Get get = new Get(Bytes.toBytes(rowkey));
            Result result = hTable.get(get);
            return new ResultHelper(result);
        } finally {
        }
    }
}
