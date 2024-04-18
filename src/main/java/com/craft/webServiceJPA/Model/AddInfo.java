package com.craft.webServiceJPA.Model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable    //add to the other class
@Builder
public class AddInfo {
	
	private String email;
	private String SSN;
	private String phoneNumber;

}
