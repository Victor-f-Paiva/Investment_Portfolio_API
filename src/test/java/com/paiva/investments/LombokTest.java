package com.paiva.investments;

import lombok.Getter;
import lombok.Setter;

public class LombokTest {
    @Getter @Setter
    private String nome;

    public static void main(String[] args) {
    	LombokTest t = new LombokTest();
        t.setNome("Victor");
        System.out.println(t.getNome());
    }
}
