package ttpu.qabulxona.service;

/**
 * Класс преобразует входные данные в хэш-строку
 */
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {


    /**
     * внутренний метод класса для преобразования бинарных данных в строку utf-8
     * @param data (byte[])
     * @return String string
     */
    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9))
                    buf.append((char) ('0' + halfbyte));
                else
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    /**
     * Статичный метод, преобразующий строку в хэш-строку Sha1
     * @param text
     * @return String convertedToSha1
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */

    public static String SHA1(String text)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md;
        md = MessageDigest.getInstance("SHA-1");
        byte[] sha1hash = new byte[40];
        md.update(text.getBytes("utf-8"), 0, text.length());
        sha1hash = md.digest();
        return convertToHex(sha1hash);
    }

    /**
     * Статичный метод, преобразующий строку в хэш-строку BCrypt
     * @param text
     * @return String convertedToBCrypt
     */
    public static String BCrypt(String text){
        return new BCryptPasswordEncoder().encode(text);
    }


}