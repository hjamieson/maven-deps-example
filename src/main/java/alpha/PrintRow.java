package alpha;

import java.io.IOException;

/**
 * fetch a row from an hbase table and output to stdout.
 * user specifies the table and the row.
 * row is emitted in text
 */
public class PrintRow {
    public static void main(String[] args) {
        int rc = 0;

        if (args.length < 2){
            throw new IllegalArgumentException("args: table rowkey");
        }
        try {
             HBaseUtil.getRow(args[0], args[1]).printRowTree();
            rc = 0;
        } catch (IOException e) {
            e.printStackTrace();
            rc = 1;
        }
        System.exit(rc);
    }
}
