package org.payment.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.Random;

/**
 * @author caroline
 * @since 17/07/2017
 */
public class EncryptionUtils {

    protected static final Logger LOGGER = LoggerFactory.getLogger(EncryptionUtils.class);
    private static final String ENCRYPTION_TYPE = "AES";
    private static final String ENCRYPTION_KEY = "MySecr3tUltrakey";

    /**
     * Define private constructor so this class cannot be initialised.
     */
    private EncryptionUtils() {

    }

    /**
     * Generates a random number from 0 to 9.
     *
     * @return a random number between 0 and 9.
     */
    public static int generateRandomNumber() {
        return new Random().nextInt(9);
    }

    /**
     * This method will convert the input string into a more cryptic string for more security during encryption.
     *
     * @param input The string to convert.
     * @return converted string.
     */
    public static String convertToCrypticString(String input) {
        if(Optional.ofNullable(input).isPresent()) {
            //Create a new string builder and reverse the sequence.
            StringBuilder stringBuilder = new StringBuilder(input).reverse();
            //Insert random numbers at points 1/3/7/9
            stringBuilder.insert(1, generateRandomNumber());
            stringBuilder.insert(3, generateRandomNumber());
            stringBuilder.insert(7, generateRandomNumber());
            stringBuilder.insert(9, generateRandomNumber());
            return stringBuilder.toString();
        }
       return null;
    }

    /**
     * This method will convert the input string back into the original string which was converted using convertToCrypticString.
     *
     * @param input The string to convert.
     * @return unconverted string
     */
    public static String convertFromCrypticString(String input) {
        if(Optional.ofNullable(input).isPresent()) {
            //Create a new string builder.
            StringBuilder stringBuilder = new StringBuilder(input);
            //Delete randomly generated numbers. Since string length is always decreasing, the position will not match that
            //of the previously inserted offset hence logic should be offset - number of removed characters.
            stringBuilder.deleteCharAt(1); //inserted by offset 1. No change needed.
            stringBuilder.deleteCharAt(2); //inserted by offset 3 (3 - deleted character)
            stringBuilder.deleteCharAt(5); //inserted by offset 7 (7 - 2 deleted characters)
            stringBuilder.deleteCharAt(6); //inserted by offset 9 (9- 3 deleted characters)
            //Reverse the string
            stringBuilder.reverse();
            return stringBuilder.toString();
        }
        return null;
    }

    /**
     * Encrypt the input data.
     * @param data to be encrypted.
     * @return encrypted string. Will return null if encryption fails.
     */
    public static String encrypt(String data)  {
        if(Optional.ofNullable(data).isPresent()) {
            try {
                //Initialise JAVA Cipher using AES encryption.
                Cipher c = Cipher.getInstance(ENCRYPTION_TYPE);
                //Set to encrypt and generate required key.
                c.init(Cipher.ENCRYPT_MODE, generateKey());
                //Convert the data to a cryptic string to make decryption harder to crack.
                String dataToEnrypt = convertToCrypticString(data);
                //Return the encoded string
                if(dataToEnrypt == null) {
                    return null;
                }
                byte[] encVal = c.doFinal(dataToEnrypt.getBytes());
                return DatatypeConverter.printBase64Binary(encVal);
            } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
                    | BadPaddingException e) {
                LOGGER.error("Error occurred when encrypting data",e);
            }
        }
        return null;
    }

    /**
     * Decrypts the encryptedData.
     * @param encryptedData to be decrypted
     * @return decrypted string. Will return null if encryption fails.
     */
    public static String decrypt(String encryptedData)  {
        if(Optional.ofNullable(encryptedData).isPresent()) {
            try {
                //Initialise JAVA Cipher using AES encryption
                Cipher c = Cipher.getInstance(ENCRYPTION_TYPE);
                //Set to decrypt and generate required key
                c.init(Cipher.DECRYPT_MODE, generateKey());
                //Do decryption.
                byte[] decodedValue = DatatypeConverter.parseBase64Binary(encryptedData);
                byte[] decValue = c.doFinal(decodedValue);
                //Convert the resultant byte array to a string and run through convert method.
                return convertFromCrypticString(new String(decValue));
            } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
                    | BadPaddingException  e) {
                LOGGER.error("Error occurred when decrypting data", e);
            }
        }
        return null;
    }

    /**
     * Generate a security key to use for encryption/decryption.
     * @return Key instance.
     */
    private static Key generateKey() {
        return new SecretKeySpec(ENCRYPTION_KEY.getBytes(), ENCRYPTION_TYPE);
    }


    /**
     * Given a card number as a string this method will replace all digits with * and only return the last 4.
     * @param cardNumber which needs to be masked
     * @return masked card number
     */
    public static String maskCardNumber(String cardNumber) {
        if(cardNumber != null) {
            //Extract last 4 digits
            String lastFourDigits = cardNumber.substring(cardNumber.length() - 4, cardNumber.length());
            //Replace the rest of the digits with *
            String maskedCardNumer = cardNumber.substring(0, cardNumber.length() - 4).replaceAll("[0-9]", "*");
            return maskedCardNumer + lastFourDigits;
        }
        return null;
    }
}
