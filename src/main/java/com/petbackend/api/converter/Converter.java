package com.petbackend.api.converter;

import java.util.List;

public interface Converter<T, R> {

	R convert(T t) throws IllegalArgumentException;
	List<R> convert(List<T> ts) throws IllegalArgumentException;
	
}
