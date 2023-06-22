/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beyza_nur_sahin_hw1;

/**
 *
 * @author Beyza
 */
public class Kuba {
    private Integer Currency;
    
        public void Add(Kuba newKuba) {
		int onlukSayi1 = 0, onlukSayi2 = 0, sayi;
		char sayiKarakter;
		// iki sayının 7 likten 10luğa çevrilip toplanması
		for (int i = 0; i < String.valueOf(this.Currency).length(); i++) {
			sayiKarakter = String.valueOf(this.Currency).charAt(i);
			sayi = Character.digit(sayiKarakter, 10);
			onlukSayi1 += sayi * Math.pow(7, String.valueOf(this.Currency).length() - i - 1);
		}
		for (int i = 0; i < String.valueOf(newKuba.GetCurrency()).length(); i++) {
			sayiKarakter = String.valueOf(newKuba.GetCurrency()).charAt(i);
			sayi = Character.digit(sayiKarakter, 10);
			onlukSayi2 += sayi * Math.pow(7, String.valueOf(newKuba.GetCurrency()).length() - i - 1);
		}

		//System.out.println("cevrilmis sayi :" + onlukSayi1);
		//System.out.println("cevrilmis sayi :" + onlukSayi2);
		int onluktoplam = onlukSayi1 + onlukSayi2;
		//System.out.println("onluk toplam :" + onluktoplam);

		int toplam = 0, i = 0, basamak; // Değişkenlerin tanımlanması
		while (onluktoplam > 0) {
			// Sonucun kuba olarak yazdırılması
			basamak = (int) ((onluktoplam % 7) * Math.pow(10, i));
			i++;
			onluktoplam = onluktoplam / 7;
			toplam = toplam + basamak;
		}

		System.out.println("toplam :" + toplam);
		this.Currency=toplam;

	}

	public void Add(Galli newGalli) {
		// ilk girilen kuba sayıyı 10luğa çevir
		int onlukSayi1 = 0, onlukSayi2 = 0, sayi;

		char sayiKarakter;
		for (int i = 0; i < String.valueOf(this.Currency).length(); i++) {
			sayiKarakter = String.valueOf(this.Currency).charAt(i);
			sayi = Character.digit(sayiKarakter, 10);
			onlukSayi1 += sayi * Math.pow(7, String.valueOf(this.Currency).length() - i - 1);
		}
		// ikinci girilen galli sayıyı 10luğa çevrilir
		for (int i = 0; i < String.valueOf(newGalli.GetCurrency()).length(); i++) {
			sayiKarakter = String.valueOf(newGalli.GetCurrency()).charAt(i);
			sayi = Character.digit(sayiKarakter, 10);
			onlukSayi2 += sayi * Math.pow(9, String.valueOf(newGalli.GetCurrency()).length() - i - 1);
		}
		//System.out.println("cevrilmis sayi :" + onlukSayi1);
		//System.out.println("cevrilmis sayi :" + onlukSayi2);
		int onluktoplam = onlukSayi1 + onlukSayi2;
		//System.out.println("onluk toplam : " + onluktoplam);

		int toplam = 0, i = 0, basamak; // Değişkenlerin tanımlanması
		while (onluktoplam > 0) {
			// toplamın galliye çevrilerek yazılması
			basamak = (int) ((onluktoplam % 9) * Math.pow(10, i));
			i++;
			onluktoplam = onluktoplam / 9;
			toplam = toplam + basamak;
		}
		
		System.out.println("toplam :" + toplam);
		
	}

	public Integer GetCurrency() {
		return this.Currency;
	}

	public void GetCurrency(Integer newKuba) {
	
		int temp = 0;
		int kontrol = newKuba;
		boolean flag = true;
		int x = String.valueOf(kontrol).length();
		while (kontrol != 0) {
			temp = kontrol % 10;
			kontrol = kontrol / 10;
			if (temp > 6) {
				flag = false;
			}
		}
		if (flag) {
			this.Currency = newKuba;
		} else {
			System.out.println("Kuba degeri giriniz. ");

		}
	}

	public void ShowCurrency() {
		// Put the Currency to the screen
		System.out.println(this.Currency);
	}

	public void Subtract(Kuba newKuba) {
		int onlukSayi1 = 0, onlukSayi2 = 0, sayi;

		char sayiKarakter;
		for (int i = 0; i < String.valueOf(this.Currency).length(); i++) {
			sayiKarakter = String.valueOf(this.Currency).charAt(i);
			sayi = Character.digit(sayiKarakter, 10);
			onlukSayi1 += sayi * Math.pow(7, String.valueOf(this.Currency).length() - i - 1);
		}
		for (int i = 0; i < String.valueOf(newKuba.GetCurrency()).length(); i++) {
			sayiKarakter = String.valueOf(newKuba.GetCurrency()).charAt(i);
			sayi = Character.digit(sayiKarakter, 10);
			onlukSayi2 += sayi * Math.pow(7, String.valueOf(newKuba.GetCurrency()).length() - i - 1);
		}

		//System.out.println("cevrilmis sayi :" + onlukSayi1);
		//System.out.println("cevrilmis sayi :" + onlukSayi2);
		int onlukfark = onlukSayi1 - onlukSayi2;
		//System.out.println("10lukfark :" + onlukfark);

		int fark = 0, i = 0, basamak; // Değişkenlerin tanımlanması
		while (onlukfark > 0) {
			// Çevirme işleminin yapılması
			basamak = (int) ((onlukfark % 7) * Math.pow(10, i));
			i++;
			onlukfark = onlukfark / 7;
			fark = fark + basamak;

		}
		System.out.println("fark :" + fark);

		
	}
	public Galli Convert() {
		Galli galli= new Galli();
		int onlukSayi1 = 0, sayi;
		int dokuzluksayi1 = 0, k = 0, basamak; 

		char sayiKarakter;
		for (int i = 0; i < String.valueOf(this.Currency).length(); i++) {
			sayiKarakter = String.valueOf(this.Currency).charAt(i);
			sayi = Character.digit(sayiKarakter, 10);
			onlukSayi1 += sayi * Math.pow(7, String.valueOf(this.Currency).length() - i - 1);
		} 
		// Değişkenlerin tanımlanması
		while (onlukSayi1 > 0) {
			// Çevirme işleminin yapılması
			basamak = (int) ((onlukSayi1% 9) * Math.pow(10, k));
			k++;
			onlukSayi1= onlukSayi1 / 9;
			dokuzluksayi1 = dokuzluksayi1 + basamak;
		}
		// Çevrilen sayının ekrana yazdırılması
		//System.out.println("9luk sayi:" + dokuzluksayi1);	
		galli.GetCurrency(dokuzluksayi1); //onlukSayi1 9luk tabanda olmalı
		
	  
		return galli;

	 }
}
