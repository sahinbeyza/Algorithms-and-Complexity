/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beyza_nur_sahin_hw1;

/**
 *
 * @author Beyza
 */
public class Galli {
    private Integer Currency;
    
            public void Add(Galli newGalli) {
		int onlukSayi1 = 0, onlukSayi2 = 0, sayi;

		char sayiKarakter;
		for (int i = 0; i < String.valueOf(this.Currency).length(); i++) {
			sayiKarakter = String.valueOf(this.Currency).charAt(i);
			sayi = Character.digit(sayiKarakter, 10);
			onlukSayi1 += sayi * Math.pow(9, String.valueOf(this.Currency).length() - i - 1);
		}
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
			// Çevirme işleminin yapılması
			basamak = (int) ((onluktoplam % 9) * Math.pow(10, i));
			i++;
			onluktoplam = onluktoplam / 9;
			toplam = toplam + basamak;
		}
		// Çevrilen sayının ekrana yazdırılması
		System.out.println("toplam :" + toplam);
		// Add your code here
		// int toplam= this.Currency+newGalli.GetCurrency();
		//System.out.println(toplam);
		this.Currency=toplam;
	}

	public Kuba Add(Kuba newKuba) {
		// Add your code here
		int onlukSayi1 = 0, onlukSayi2 = 0, sayi;

		char sayiKarakter;
		for (int i = 0; i < String.valueOf(this.Currency).length(); i++) {
			sayiKarakter = String.valueOf(this.Currency).charAt(i);
			sayi = Character.digit(sayiKarakter, 10);
			onlukSayi1 += sayi * Math.pow(9, String.valueOf(this.Currency).length() - i - 1);
		}
		// galli 10luğa çevrilir
		for (int i = 0; i < String.valueOf(newKuba.GetCurrency()).length(); i++) {
			sayiKarakter = String.valueOf(newKuba.GetCurrency()).charAt(i);
			sayi = Character.digit(sayiKarakter, 10);
			onlukSayi2 += sayi * Math.pow(7, String.valueOf(newKuba.GetCurrency()).length() - i - 1);
		}
		System.out.println("cevrilmis sayi :" + onlukSayi1);
		System.out.println("cevrilmis sayi :" + onlukSayi2);
		int onluktoplam = onlukSayi1 + onlukSayi2;
		System.out.println("onluk toplam :" + onluktoplam);

		int toplam = 0, i = 0, basamak; // Değişkenlerin tanımlanması
		while (onluktoplam > 0) {
			// galliye çevirme işleminin yapılması
			basamak = (int) ((onluktoplam % 7) * Math.pow(10, i));
			i++;
			onluktoplam = onluktoplam / 7;
			toplam = toplam + basamak;
		}
		// Çevrilen sayının ekrana yazdırılması
		System.out.println("toplam :" + toplam);

		return newKuba;
	}

	public Integer GetCurrency() {
		// User can enter Currency but check it
		return this.Currency;

	}

	public void GetCurrency(Integer newGalli) {
		int temp = 0;
		int kontrol = newGalli;
		boolean flag = true;
		int x = String.valueOf(kontrol).length();
		while (kontrol != 0) {
			temp = kontrol % 10;
			kontrol = kontrol / 10;
			if (temp > 8) {
				flag = false;
			}
		}
		if (flag) {
			this.Currency = newGalli;
		} else {
			System.out.println("Galli degeri giriniz. ");

		}
	}

	public void ShowCurrency() {
		
		System.out.println(this.Currency);
	}

	public void Subtract(Galli newGalli) {
		int onlukSayi1 = 0, onlukSayi2 = 0, sayi;

		char sayiKarakter;
		for (int i = 0; i < String.valueOf(this.Currency).length(); i++) {
			sayiKarakter = String.valueOf(this.Currency).charAt(i);
			sayi = Character.digit(sayiKarakter, 10);
			onlukSayi1 += sayi * Math.pow(9, String.valueOf(this.Currency).length() - i - 1);
		}
		for (int i = 0; i < String.valueOf(newGalli.GetCurrency()).length(); i++) {
			sayiKarakter = String.valueOf(newGalli.GetCurrency()).charAt(i);
			sayi = Character.digit(sayiKarakter, 10);
			onlukSayi2 += sayi * Math.pow(9, String.valueOf(newGalli.GetCurrency()).length() - i - 1);
		}

		//System.out.println("cevrilmis sayi :" + onlukSayi1);
		//System.out.println("cevrilmis sayi :" + onlukSayi2);
		int onlukfark = onlukSayi1 - onlukSayi2;
		//System.out.println("10lukfark :" + onlukfark);

		int fark = 0, i = 0, basamak; // Değişkenlerin tanımlanması
		while (onlukfark > 0) {
			// Çevirme işleminin yapılması
			basamak = (int) ((onlukfark % 9) * Math.pow(10, i));
			i++;
			onlukfark = onlukfark / 9;
			fark = fark + basamak;
		}
		System.out.println("fark :" + fark);
	}
        
	public Kuba Convert() {
			Kuba kuba = new Kuba();
			int onlukSayi1 = 0, sayi;
			int yediliksayi1 = 0, k = 0, basamak; 

			char sayiKarakter;
			for (int i = 0; i < String.valueOf(this.Currency).length(); i++) {
				sayiKarakter = String.valueOf(this.Currency).charAt(i);
				sayi = Character.digit(sayiKarakter, 10);
				onlukSayi1 += sayi * Math.pow(9, String.valueOf(this.Currency).length() - i - 1);
			} 
			// Değişkenlerin tanımlanması
			while (onlukSayi1 > 0) {
				// Çevirme işleminin yapılması
				basamak = (int) ((onlukSayi1% 7) * Math.pow(10, k));
				k++;
				onlukSayi1= onlukSayi1 / 7;
				yediliksayi1 = yediliksayi1 + basamak;
			}
			// Çevrilen sayının ekrana yazdırılması
			System.out.println("7lik sayi:" + yediliksayi1);	
			kuba.GetCurrency(yediliksayi1); 
			
	
		  
			return kuba;
		
		 }
	

}
