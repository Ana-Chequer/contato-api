package br.com.ana.contato.model;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum TipoCadastro {
	
	ATIVO("ativo"),
	INATIVO ("inativo");
	
	 private String tipo;

	TipoCadastro(String tipo) {
		this.tipo = tipo;
	}
	

    private static final Map<String,TipoCadastro> ENUM_MAP;


    public String getTipo() {
        return this.tipo;
    }


    static {
        Map<String,TipoCadastro> map = new ConcurrentHashMap<String, TipoCadastro>();
        
        for (TipoCadastro instance : TipoCadastro.values()) {
            map.put(instance.getTipo().toLowerCase(),instance);
        }
        
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static TipoCadastro get (String name) {
        return ENUM_MAP.get(name.toLowerCase());
    }
	
	

}
