package com.cgi.learning.common;

import java.sql.ResultSet;

public interface ResultsCallBack<T> {

	T readResult(ResultSet resultSet);

}
