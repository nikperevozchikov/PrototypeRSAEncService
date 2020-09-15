package com.prototype.enc.api;

import com.prototype.enc.api.dto.MessageDTO;
import com.prototype.enc.api.dto.PasswordDTO;
import com.prototype.enc.repository.EncryptionPrototype;
import com.prototype.enc.service.EncryptionPrototypeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/encryptionExample")
public class EncryptionPrototypeController {
    private static Logger log = LoggerFactory.getLogger(EncryptionPrototypeController.class);
    @Autowired
    private EncryptionPrototypeService encryptionExampleService;

    //----------------------------RETRIEVE ALL Encryption Examples WITH PAGING -------------------------------
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<Page<EncryptionPrototype>> listAllByPage(Pageable pageable) {
//        Page<EncryptionPrototype> encryptedRecords = encryptionExampleService.listAllByPage(pageable);
//
//        return new ResponseEntity<Page<EncryptionPrototype>>(encryptedRecords, HttpStatus.OK);
//    }

    //----------------------------CREATE Encryption Example Record -------------------------------
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<EncryptionPrototype> createEncryptionExample(@RequestBody String clearText) {
//        log.info("Creating encryption example record");
//
//        if (StringUtils.isBlank(clearText)) {
//            log.error("Clear text is null");
//            return new ResponseEntity<EncryptionPrototype>(HttpStatus.BAD_REQUEST);
//        }
//
//        try {
//            encryptionExampleService.updateEncryptionExample(clearText);
//        } catch (Exception e) {
//            log.error("Create encryption example error");
//            return new ResponseEntity<EncryptionPrototype>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<EncryptionPrototype>(HttpStatus.OK);
//    }

    @RequestMapping(value = "/enc", method = RequestMethod.POST)
    public String encryptedE(@RequestBody PasswordDTO passwordDTO)
            throws IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, BadPaddingException, JsonProcessingException {
        return encryptionExampleService.encryptE(passwordDTO);
    }

    @RequestMapping(value = "/dec", method = RequestMethod.POST)
    public String decryptD(@RequestBody MessageDTO messageDTO) throws IllegalBlockSizeException,
            NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IOException {
        return encryptionExampleService.decryptD(messageDTO);
    }


    @RequestMapping("/generateKeyPair")
    public void generateKeyPair(@RequestParam(value = "keySize") int keySize,
                                @RequestParam(value = "algorithm") String algorithm) throws NoSuchAlgorithmException {
        this.encryptionExampleService.generateKeyPair(keySize, algorithm);
    }

    //----------------------------UPDATE Encryption Example Record -------------------------------
//    @RequestMapping(method = RequestMethod.PUT)
//    public ResponseEntity<EncryptionPrototype> updateEncryptionExample(@RequestBody String clearText) {
//        log.info("Creating encryption example record");
//        if (StringUtils.isBlank(clearText)) {
//            log.error("Clear text is null");
//            return new ResponseEntity<EncryptionPrototype>(HttpStatus.BAD_REQUEST);
//        }
//
//        try {
//            encryptionExampleService.updateEncryptionExample(clearText);
//        } catch (Exception e) {
//            log.error("Create encryption example error");
//            return new ResponseEntity<EncryptionPrototype>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<EncryptionPrototype>(HttpStatus.OK);
//    }
}
