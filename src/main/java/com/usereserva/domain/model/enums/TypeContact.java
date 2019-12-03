package com.usereserva.domain.model.enums;

public enum TypeContact {
	
	OFFICE,
	HOUSE;
	
	
    public static TypeContact getByString(String value){
		
		for(TypeContact s : TypeContact.values()){
			if(s.toString().equals(value)){
				return s;
			}
		}
		return null;
	}

	

}
