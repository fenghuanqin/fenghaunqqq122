package com.tnr.scgcxx.util;

import java.util.List;

@FunctionalInterface
public interface QueryAction<T> {

	List<T> execute();

}