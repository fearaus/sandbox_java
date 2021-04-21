package crypto;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class Keygen {

    private static final String ALGO = "AES";


    public static void main(String[] args) throws NoSuchAlgorithmException, DecoderException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException {
        final String algo = "AES";
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algo);
        SecureRandom secureRandom = new SecureRandom();
        int keyBitSize = 128;
        keyGenerator.init(keyBitSize, secureRandom);
        SecretKey secretKey = keyGenerator.generateKey();
        System.out.println(secretKey.getEncoded()); //byte ke hex string (properties)

        System.out.println("encode byte" + secretKey.getEncoded());
        String secret = Hex.encodeHexString(secretKey.getEncoded());
        System.out.println("convert byte to Hexstring:" + secret);




        // TEST AREA

        secret = "not specified";
        String encrypData = "4eoA/iKgrZbdiajiYTO+AA==";

        //String enctdata = encrypt("PJMWxWRq2GZrDkMmdQC62A==",secret);
        System.out.println("ecrypt data " + encrypData);

        //String resultDecrypt = decrypt (     encrypData, secret);
        //System.out.println("decrypt data " + resultDecrypt);


        encrypt("koko",secret);



    }


    /**
     * Encrypt a string with AES algorithm.
     *
     * @param data is a string
     * @return the encrypted string
     */
    public static String encrypt(String data, String secretKey) {
        try {
            Key key = generateKey(secretKey);
            Cipher c = Cipher.getInstance(ALGO);
            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = c.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encVal);

        }catch(Exception ex) {
            throw new RuntimeException("encryption failure :" + ex.getMessage());
        }
    }

    /**
     * Decrypt a string with AES algorithm.
     *
     * @param encryptedData is a string
     * @return the decrypted string
     */
    public static String decrypt(String encryptedData, String secretKey) {

        try {
            Key key = generateKey(secretKey);
            Cipher c = Cipher.getInstance(ALGO);
            c.init(Cipher.DECRYPT_MODE, key);
            byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
            byte[] decValue = c.doFinal(decordedValue);
            return new String(decValue);
        } catch (Exception ex) {
            throw new RuntimeException("decryption failure :" + ex.getMessage());
        }
    }

    /**
     * Generate a new encryption key.
     */
    private static Key generateKey(String secretKey) throws DecoderException {
        final byte[] keyValue =  Hex.decodeHex(secretKey);
        return new SecretKeySpec(keyValue, ALGO);
    }
}
