package com.prototype.enc.service;


import com.prototype.enc.api.dto.MessageDTO;
import com.prototype.enc.api.dto.PasswordDTO;
import com.prototype.enc.repository.EncryptionPrototype;
import com.prototype.enc.repository.EncryptionPrototypeRepository;
import com.prototype.enc.utils.GenSignature;
import com.prototype.enc.utils.RSACryptography;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

@Service
public class EncryptionPrototypeServiceImpl implements EncryptionPrototypeService {
    @Autowired
    private PublicKey publicKey;
    @Autowired
    private PrivateKey privateKey;
//    @Autowired
//    private EncryptionPrototypeRepository encryptionExampleRepo;

//    @Override
//    public Page<EncryptionPrototype> listAllByPage(Pageable pageable) {
//        return encryptionExampleRepo.findAll(pageable);
//    }
//
//    @Override
//    @Transactional
//    public EncryptionPrototype updateEncryptionExample(EncryptionPrototype encryptionPrototype) throws Exception {
//        return encryptionExampleRepo.save(encryptionPrototype);
//    }

//    @Override
//    public EncryptionPrototype updateEncryptionExample(String clearText) throws Exception {
//        EncryptionPrototype newEncryptionPrototype = new EncryptionPrototype(clearText, clearText);
//
//        return updateEncryptionExample(newEncryptionPrototype);
//    }

    /**
     * @param keySize
     * @param algorithm
     */
    public void generateKeyPair(int keySize, String algorithm) throws NoSuchAlgorithmException {
        GenSignature.generateKeyPair(keySize, algorithm);
    }

    /**
     * @param passwordDTO
     * @return
     */
    public String encryptE(PasswordDTO passwordDTO)
            throws NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException,
            IllegalBlockSizeException, InvalidKeyException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(passwordDTO);
        return RSACryptography.encrypt(publicKey, jsonInString);
    }

    public String decryptD(MessageDTO messageDTO)
            throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException,
            NoSuchAlgorithmException, NoSuchPaddingException, IOException {

        String plainMessage = RSACryptography.decrypt(privateKey, messageDTO.getMessage());
        System.out.println(plainMessage);
        return plainMessage;
    }

}
