package util;

import java.util.ArrayList;
import java.util.Random;

import abstraction.IRandom;

public class CharRandomizer implements IRandom<Character> {

	private ArrayList<Character> alphabets;
	
	public CharRandomizer() {
		alphabets = new ArrayList<>();
		for (int i = 'A'; i <= 'Z'; i++) {
			alphabets.add((char) i);
		}
	}
	
	@Override
	public Character random() {
		Random rand = new Random();
		int num = rand.nextInt();
		if (num % 2 == 0) return alphabets.get(rand.nextInt(alphabets.size()));
		else return String.valueOf(rand.nextInt(10)).toCharArray()[0];
	}

}
