package alpha;

import java.io.IOException;

public class UtilTest {
    public static void main(String[] args) throws IOException {
        ResultHelper helper = HBaseUtil.getRow("TransactionJournal", "AAA188");
        helper.printRowTree();
    }
}
