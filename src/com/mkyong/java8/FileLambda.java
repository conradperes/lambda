package com.mkyong.java8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileLambda {

	private static final String REGEXP = null;
	private static BufferedReader bufferedReader;

	public static void main(String[] args) {

		// FileFilter x = File::canRead;
		Factory<List<String>> f = ArrayList<String>::new;
		List<String> make = f.make();
		make.addAll(getList());
		make.forEach(item->System.out.println(item));

		List<String> wordList = getList();
		List<String> output = toUpperCase(wordList);
		output.forEach(item -> System.out.println(item));
		
		try {
			System.out.println(countFileLines(new File("C:\\Users\\f537565\\eclipse-workspace\\lambda\\src\\com\\mkyong\\java8\\FileLambda.java")));
			System.out.println(linhaMaisLongaFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Seleciona somente as palavras com tamanho par e joga para uma List<String>
	 * 
	 * @param wordList
	 * @return
	 */
	private static List<String> filter(List<String> wordList) {
		// List<String> output = wordList.stream().filter(w -> (w.length() & 1 ==
		// 0).collect(Collectors.toList());
		return null;
	}
	
	
	private static List<String> getPalavras(){
		return bufferedReader.lines().
				  flatMap(line -> Stream.of(line.split(REGEXP))). 
				  // Recebe um stream de palavras de
				  // todas as linhas.
				  filter(word -> word.length() > 0).
				  // Filtra as Strings vazias.
				  collect(Collectors.toList());
				// Cria a lista de retorno.
	}
	
	
	private static long linhaMaisLongaFile() {
		return  bufferedReader.lines().
				  mapToInt(String::length).
				  // Cria uma novo Stream com o tamanhos das Strings mapeando
				  // a atual String ao tamanho correspondente.
				  max().
				  // Coleta o maior elemento do stream de tamanho (como uma OptionalInt).
				  getAsInt();
				  // Atualiza o OptionalInt com um int.
	}
	
	private static long countFileLines(File f) throws FileNotFoundException {
		bufferedReader = new BufferedReader (new FileReader (f));
		return  bufferedReader.
				  // Recebe um stream com linhas individuais. Esse é o novo método do
				  // bufferedReader que retorna um stream<string>.
				  lines(). 
				  // Conta os elementos do stream de entrada.
				  count();
	}

	private static List<String> toUpperCase(List<String> wordList) {
		List<String> output = wordList.stream().
		// Mapa de toda a lista de String em maiúsculo.
				map(String::toUpperCase).
				// Converte o stream para uma lista.
				collect(Collectors.toList());
		return output;
	}

	private static List<String> getList() {
		List<String> wordList = Arrays.asList("fasdfas", "zcvzxcv", "zcxvzxcv", "zxcvzxc", "zxc", "zxcvzcxv",
				"zxcvzxcv");
		return wordList;
	}

	interface Factory<T> {

		T make();

	}

}
