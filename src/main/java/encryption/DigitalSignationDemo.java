package encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Arrays;

public class DigitalSignationDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException, SignatureException {
        //B send message to A
        byte[] plain = "message".getBytes();
        System.out.println("The original message is: " + Arrays.toString(plain));

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024);

        //A generate keypair
        KeyPair aKeyPair = generator.generateKeyPair();
        //A public keypair
        PublicKey aPublicKey = aKeyPair.getPublic();
        //A saves private keypair
        PrivateKey aPrivateKey = aKeyPair.getPrivate();

        System.out.println("A's public keypair: " + aPublicKey);
        System.out.println("A's private keypair: " + aPrivateKey);

        //B generate keypair
        KeyPair bKeyPair = generator.generateKeyPair();
        PublicKey bPublicKey = bKeyPair.getPublic();
        PrivateKey bPrivateKey = bKeyPair.getPrivate();

        System.out.println("B's public keypair: " + bPublicKey);
        System.out.println("B's private keypair: " + bPrivateKey);

        //I: B's steps:
        //encryption
        Cipher cipher = Cipher.getInstance("RSA");
        //B encrypt message with A's public keypair.
        cipher.init(Cipher.ENCRYPT_MODE, aPublicKey);
        cipher.update(plain);

        byte[] result1 = cipher.doFinal();
        System.out.println("Encryption Result: " + Arrays.toString(result1));





        //make a digest for message
        MessageDigest digest = MessageDigest.getInstance("SHA1");
        digest.update(plain);
        byte[] hash1 = digest.digest();
        System.out.println("hash1: " + Arrays.toString(hash1));

        //Signature
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(bPrivateKey);
        signature.update(hash1);
        byte[] signByte = signature.sign();
        System.out.println("signByte: " + Arrays.toString(signByte));

        //B send signByte and result1 to A

        //A得到B发过来的信息后用自己的私钥进行解密
        cipher.init(Cipher.DECRYPT_MODE, aPrivateKey);
        cipher.update(result1);
        byte[] result2 = cipher.doFinal();
        System.out.println("Decryption Result: " + Arrays.toString(result2));
        System.out.println("原文比较："+Arrays.equals(result2, plain));
        System.out.println("B's message is: " + new String(result2));

        //把解密的结果进行信息摘要
        digest.reset();
        digest.update(result2);
        byte[] hash2 = digest.digest();

        //比较两次摘要的结果是否一致
        signature.initVerify(bPublicKey);
        signature.update(hash2);
        boolean b = signature.verify(signByte);
        System.out.println("验证签名结果:"+b);


    }
}
