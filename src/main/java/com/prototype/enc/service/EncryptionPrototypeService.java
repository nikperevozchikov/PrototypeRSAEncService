package com.prototype.enc.service;


import com.prototype.enc.api.dto.MessageDTO;
import com.prototype.enc.api.dto.PasswordDTO;
import com.prototype.enc.repository.EncryptionPrototype;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface EncryptionPrototypeService {

    //EncryptionPrototype updateEncryptionExample(String clearText) throws Exception;

    void generateKeyPair(int keySize, String algorithm) throws NoSuchAlgorithmException;

    //EncryptionPrototype updateEncryptionExample(EncryptionPrototype encryptionPrototype) throws Exception;

    String encryptE(PasswordDTO passwordDTO)
            throws NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException,
            IllegalBlockSizeException, InvalidKeyException, JsonProcessingException;

    String decryptD(MessageDTO messageDTO) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException,
            NoSuchAlgorithmException, NoSuchPaddingException, IOException;

    //Page<EncryptionPrototype> listAllByPage(Pageable pageable);
}
