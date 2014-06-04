package com.dao;

import java.util.List;

import com.entity.Log;

public interface LogDAO {
	public abstract void save(Log log);
	public abstract List<Log> findAll();
}
