package source;

import commons.Entry;

import exceptions.InvalidKeyException;

// Interface para um mapa que aceita um chave única para um valor.
public interface Map<K,V> {
	// Retorna o número de itens do mapa
	public int size();
	
	// Retorna se o mapa está vazio
	public boolean isEmpty();
	// Coloca uma par chave-valor no mapa, trocando o anterior,
	// se houver algum e retorna o valor anterior
	public V put(K key, V value) throws InvalidKeyException;
	// Retorna o valor associado com uma chave
	public V get(K key) throws InvalidKeyException;
	// Remove o par chave-valor de uma dada chave
	public V remove(K key) throws InvalidKeyException;
	// Retorna um objeto iterable para todoas as chaves do mapa
	public Iterable<K> keySet();
	// Retorna um objeto iterable para todos os valores do mapa
	public Iterable<V> values();
	// Retorna um objeto iterable para todas as entradas do mapa
	public Iterable<Entry<K,V>> entrySet();

}