package br.com.nbis;

import java.util.Properties;

public class Main {

	public static void main(String[] args) {
		
		String name = "teste.png";
		
		System.out.println(name.substring(0, name.lastIndexOf(".")) + ".wsq");
		
	}

}
