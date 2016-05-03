package br.univel.enums;

public enum EstadoCivil {
	SOLTEIRO, 
	CASADO, 
	VIUVO;

	public static Object getPorid(int value) {
		for (EstadoCivil item : EstadoCivil.values()) {
            if (item.ordinal() == value) {
            	return item;
            }
        }
		throw new RuntimeException("Não encontrado: " + value);
	}
}