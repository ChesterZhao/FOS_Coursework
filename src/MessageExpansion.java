public class MessageExpansion {
    public static int[] expand(int[] message) {
        int[] expandMsg = new int[64];

        for (int i = 0; i < 16; i++) {
            expandMsg[i] = message[i + 16];
        }

        for (int i = 0; i < 32; i++) {
            expandMsg[i + 16] = 1 - message[i];
        }

        for (int i = 0; i < 16; i++) {
            expandMsg[i + 16 + 32] = message[i];
        }

        return expandMsg;
    }

    public static void main(String[] args) {
        int[] message = {0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1}; // 用一个32位的整数数组表示明文消息
        int[] expandedMessage = expand(message);
        for (int i = 0; i < expandedMessage.length; i++) {
            System.out.print(expandedMessage[i]);
        }
    }
}