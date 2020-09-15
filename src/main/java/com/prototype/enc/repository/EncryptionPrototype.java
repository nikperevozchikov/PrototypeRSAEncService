package com.prototype.enc.repository;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "encryption_example")
public class EncryptionPrototype implements Serializable {
	
	private static final long serialVersionUID = -7371781304063255782L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "encrypted_text")
	//@Convert(converter = JPACryptoConverter.class)
	private @NonNull String encryptedText;
	
	@Column(name = "clear_text")
	private @NonNull String clearText;


}
