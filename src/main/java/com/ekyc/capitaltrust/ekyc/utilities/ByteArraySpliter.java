package com.ekyc.capitaltrust.ekyc.utilities;

public class ByteArraySpliter {
    private final byte[] headerVersion;
    private final byte[] iv;
    private final byte[] encryptedSecretKey;
    private final byte[] encryptedData;
    private final byte[] publicKeyData;
    private static final byte[] HEADER_DATA = "VERSION_1.0".getBytes();
    private static final int PUBLIC_KEY_SIZE = 305;
    private static final int EID_SIZE = 32;
    private static final int SECRET_KEY_SIZE = 256;

    public ByteArraySpliter(byte[] data) throws Exception {
        int offset = 0;
        this.headerVersion = new byte[HEADER_DATA.length];
        this.copyByteArray(data, 0, this.headerVersion.length, this.headerVersion);
        offset += HEADER_DATA.length;
        this.publicKeyData = new byte[305];
        this.copyByteArray(data, offset, this.publicKeyData.length, this.publicKeyData);
        offset += 305;
        this.iv = new byte[32];
        this.copyByteArray(data, offset, this.iv.length, this.iv);
        offset += 32;
        this.encryptedSecretKey = new byte[256];
        this.copyByteArray(data, offset, this.encryptedSecretKey.length, this.encryptedSecretKey);
        offset += 256;
        this.encryptedData = new byte[data.length - offset];
        this.copyByteArray(data, offset, this.encryptedData.length, this.encryptedData);
    }

    public byte[] getIv() {
        return this.iv;
    }

    public byte[] getEncryptedSecretKey() {
        return this.encryptedSecretKey;
    }

    public byte[] getEncryptedData() {
        return this.encryptedData;
    }

    public byte[] getPublicKeyData() {
        return this.publicKeyData;
    }

    private void copyByteArray(byte[] src, int offset, int length, byte[] dest) throws Exception {
        if (src.length < offset + length) {
            throw new Exception("Source array is shorter than expected.");
        } else {
            try {
                System.arraycopy(src, offset, dest, 0, length);
            } catch (Exception var6) {
                Exception e = var6;
                throw new Exception("Decryption failed, Corrupted packet ", e);
            }
        }
    }
}
