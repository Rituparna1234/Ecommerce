package com.spring.dao;

import java.util.List;


import com.spring.model.Supplier;

public interface SupplierDAO {

	public boolean saveSupplier(Supplier supplier);

	public List<Supplier> list();

	public Supplier getSupplierById(int supplier_id);

	public Supplier removeSupplierById(int supplier_id);
}